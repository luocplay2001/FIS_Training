package fis.training.criminalsystemmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_evidence")
public class Evidence extends AbstractEntity {
    private String number;

    private String itemName;

    private String notes;

    private Boolean archived;

    @ManyToOne
    @JoinColumn(name = "criminal_case_id")
    @JsonBackReference(value="criminal-evidence")
    private CriminalCase criminalCase;

    @ManyToOne
    @JoinColumn(name = "storage_id")
    @JsonBackReference(value="evidence-storage")
    private Storage storage;

    @OneToMany(mappedBy = "evidence")
    @JsonManagedReference(value="evidence-track")
    private Set<TrackEntry> trackEntries;

//    @Override
//    public String toString() {
//        return "Evidence{" +
//                "number='" + number + '\'' +
//                ", itemName='" + itemName + '\'' +
//                ", notes='" + notes + '\'' +
//                ", archived=" + archived +
//                ", criminalCase=" + criminalCase +
//                ", storage=" + storage +
////                ", trackEntries=" + trackEntries +
//                '}';
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Evidence)) return false;
        if (!super.equals(o)) return false;
        Evidence evidence = (Evidence) o;
        return number.equals(evidence.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), number);
    }
}
