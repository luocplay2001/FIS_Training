package core;

import java.time.LocalDateTime;

public class TrackEntry {
    private Long trackEntryId;
    private int version;
    private LocalDateTime cretedAt;
    private LocalDateTime modifiedAt;
    private LocalDateTime date;
    private Evidence evidence;
    private Detective detective;
    private TrackAction action;
    private String resson;
}
