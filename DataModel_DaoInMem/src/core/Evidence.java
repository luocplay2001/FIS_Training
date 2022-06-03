package core;

import java.time.LocalDateTime;
import java.util.Set;

public class Evidence {
    private Long evidenceId;
    private int version;
    private LocalDateTime cretedAt;
    private LocalDateTime modifiedAt;
    private String number;
    private String itemName;
    private String notes;
    private Boolean archived;
    private CriminalCase criminalCase;
    private Storage storage;
    private Set<TrackEntry> trackEntries;
}
