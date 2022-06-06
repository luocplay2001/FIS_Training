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

    public Evidence() {
    }

    public Evidence(Long evidenceId, int version, LocalDateTime cretedAt,
                    LocalDateTime modifiedAt, String number, String itemName,
                    String notes, Boolean archived, CriminalCase criminalCase,
                    Storage storage, Set<TrackEntry> trackEntries) {
        this.evidenceId = evidenceId;
        this.version = version;
        this.cretedAt = cretedAt;
        this.modifiedAt = modifiedAt;
        this.number = number;
        this.itemName = itemName;
        this.notes = notes;
        this.archived = archived;
        this.criminalCase = criminalCase;
        this.storage = storage;
        this.trackEntries = trackEntries;
    }

    public Long getEvidenceId() {
        return evidenceId;
    }

    public void setEvidenceId(Long evidenceId) {
        this.evidenceId = evidenceId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public LocalDateTime getCretedAt() {
        return cretedAt;
    }

    public void setCretedAt(LocalDateTime cretedAt) {
        this.cretedAt = cretedAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public CriminalCase getCriminalCase() {
        return criminalCase;
    }

    public void setCriminalCase(CriminalCase criminalCase) {
        this.criminalCase = criminalCase;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Set<TrackEntry> getTrackEntries() {
        return trackEntries;
    }

    public void setTrackEntries(Set<TrackEntry> trackEntries) {
        this.trackEntries = trackEntries;
    }

    public void setEvidence(Evidence evidence) {

    }

    @Override
    public String toString() {
        return "Evidence{" +
                "evidenceId=" + evidenceId +
                ", version=" + version +
                ", cretedAt=" + cretedAt +
                ", modifiedAt=" + modifiedAt +
                ", number='" + number + '\'' +
                ", itemName='" + itemName + '\'' +
                ", notes='" + notes + '\'' +
                ", archived=" + archived +
                ", criminalCase=" + criminalCase +
                ", storage=" + storage +
                ", trackEntries=" + trackEntries +
                '}';
    }
}
