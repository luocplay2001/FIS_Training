package fis.training.criminalsystemmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import fis.training.criminalsystemmanagement.model.enums.CaseStatus;
import fis.training.criminalsystemmanagement.model.enums.CaseType;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_criminal")
public class CriminalCase extends AbstractEntity {
    private String number;

    @Enumerated(EnumType.STRING)
    private CaseType type;

    private String shortDescription;

    private String detailedDescription;

    @Enumerated(EnumType.STRING)
    private CaseStatus status;

    private String notes;

    @OneToMany(mappedBy = "criminalCase")
    @JsonManagedReference(value="criminal-evidence")
    private Set<Evidence> evidences;

    @ManyToOne
    @JoinColumn(name = "lead_investigator", nullable = false)
    private Detective leadInvestigator; // lead

    @ManyToMany(mappedBy = "criminalCases")
//    @JsonBackReference(value="criminal-detective")
    @JsonIgnore
    @JsonBackReference
    private Set<Detective> assigned;

//    @Override
//    public String toString() {
//        return "CriminalCase{" +
//                "number='" + number + '\'' +
//                ", type=" + type +
//                ", shortDescription='" + shortDescription + '\'' +
//                ", detailedDescription='" + detailedDescription + '\'' +
//                ", status=" + status +
//                ", notes='" + notes + '\'' +
//                ", leadInvestigator=" + leadInvestigator +
//                '}';
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CriminalCase)) return false;
        if (!super.equals(o)) return false;
        CriminalCase that = (CriminalCase) o;
        return number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), number);
    }
}
