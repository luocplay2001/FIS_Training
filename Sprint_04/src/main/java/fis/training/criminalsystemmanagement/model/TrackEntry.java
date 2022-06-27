package fis.training.criminalsystemmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import fis.training.criminalsystemmanagement.model.enums.TrackAction;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_trackEntry")
public class TrackEntry extends AbstractEntity {
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "evidence_id", nullable = false)
    @JsonBackReference(value="evidence-track")
    private Evidence evidence;

    @ManyToOne
    @JoinColumn(name = "detective_id", nullable = false)
    @JsonBackReference(value="detective-track")
    private Detective detective;

    @Enumerated(EnumType.STRING)
    private TrackAction action;

    private String resson;

//    @Override
//    public String toString() {
//        return "TrackEntry{" +
//                "date=" + date +
//                ", evidence=" + evidence +
//                ", detective=" + detective +
//                ", action=" + action +
//                ", resson='" + resson + '\'' +
//                '}';
//    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}
