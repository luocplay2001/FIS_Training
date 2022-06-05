package core;

import java.time.LocalDateTime;
import java.util.Set;

public class Storage {
    private Long storageId;
    private int version;
    private LocalDateTime cretedAt;
    private LocalDateTime modifiedAt;
    private String name;
    private String location;
    private Set<Evidence> evidenceSet;
}
