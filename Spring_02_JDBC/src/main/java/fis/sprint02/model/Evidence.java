package fis.sprint02.model;

import lombok.Data;

import java.util.Set;

@Data
public class Evidence extends AbstractEntity {
    private String number;
    private String itemName;
    private String notes;
    private Boolean archived;
    private CriminalCase criminalCase;
    private Storage storage;
    private Set<TrackEntry> trackEntries;

    public Evidence() {
    }
}
