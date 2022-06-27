package fis.training.criminalsystemmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import fis.training.criminalsystemmanagement.model.enums.EmploymentStatus;
import fis.training.criminalsystemmanagement.model.enums.Rank;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_detective")
public class Detective extends AbstractEntity {

    @Column(name = "username", unique = true)
    private String username;

    private String firstName;

    private String lastName;

    private String password;

    private String badgeNumber;

    private LocalDateTime hiringDate;

    @Column(name = "rank_detective")
    @Enumerated(EnumType.STRING)
    private Rank rank;

    private Boolean armed;

    @Column(name = "status_detective")
    @Enumerated(EnumType.STRING)
    private EmploymentStatus status;

    @ManyToMany
    @JoinTable(name = "tbl_criminal_detective", joinColumns = @JoinColumn(name = "detective_id")
            , inverseJoinColumns = @JoinColumn(name = "criminal_case_id"))
//    @JsonManagedReference(value="criminal-detective")
    @JsonBackReference
    private Set<CriminalCase> criminalCases;

    @OneToMany(mappedBy = "detective")
    @JsonManagedReference(value="detective-track")
    private Set<TrackEntry> trackEntries;

//    @Override
//    public String toString() {
//        return "Detective{" +
//                "username='" + username + '\'' +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", password='" + password + '\'' +
//                ", badgeNumber='" + badgeNumber + '\'' +
//                ", hiringDate=" + hiringDate +
//                ", rank=" + rank +
//                ", armed=" + armed +
//                ", status=" + status +
//                '}';
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Detective)) return false;
        if (!super.equals(o)) return false;
        Detective detective = (Detective) o;
        return badgeNumber.equals(detective.badgeNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), badgeNumber);
    }
}
