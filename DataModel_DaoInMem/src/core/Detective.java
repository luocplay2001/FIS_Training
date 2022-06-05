package core;

import java.time.LocalDateTime;
import java.util.Set;

public class Detective {
    private Long detectiveId;
    private int version;
    private LocalDateTime cretedAt;
    private LocalDateTime modifiedAt;
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


}
