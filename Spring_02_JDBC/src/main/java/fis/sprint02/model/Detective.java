package fis.sprint02.model;

import fis.sprint02.model.enums.EmploymentStatus;
import fis.sprint02.model.enums.Rank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class Detective extends AbstractEntity {

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private LocalDateTime hiringDate;
    private String badgeNumber;
    private Rank rank;
    private Boolean armed;
    private EmploymentStatus status;
    private Set<CriminalCase> criminalCases;
    private Set<TrackEntry> trackEntries;
    public Detective() {
    }

}
