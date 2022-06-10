package fis.sprint02.model;

import lombok.Data;

import java.util.Set;

@Data
public class Evidence extends AbstractEntity {
    CriminalCase criminalCase;
    Storage storage;
    String number;
    String itemName;
    String notes;
    Boolean archived;
    Set<TrackEntry> trackEntries;

    public Evidence() {
    }
}
