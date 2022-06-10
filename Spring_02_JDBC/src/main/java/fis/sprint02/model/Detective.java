package fis.sprint02.model;

import fis.sprint02.model.enums.EmploymentStatus;
import fis.sprint02.model.enums.Rank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class Detective extends AbstractEntity {

    String badgeNumber;
    Rank rank;
    Boolean armed;
    EmploymentStatus status;
    Set<CriminalCase> criminalCases;
    Set<TrackEntry> trackEntries;
    String username;
    String firstName;
    String lastName;
    String password;
    LocalDateTime hiringDate;
    public Detective() {
    }

}
