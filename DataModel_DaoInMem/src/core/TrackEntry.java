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

    public TrackEntry() {
    }

    public TrackEntry(Long trackEntryId, int version, LocalDateTime cretedAt,
                      LocalDateTime modifiedAt, LocalDateTime date, Evidence evidence,
                      Detective detective, TrackAction action, String resson) {
        this.trackEntryId = trackEntryId;
        this.version = version;
        this.cretedAt = cretedAt;
        this.modifiedAt = modifiedAt;
        this.date = date;
        this.evidence = evidence;
        this.detective = detective;
        this.action = action;
        this.resson = resson;
    }

    public Long getTrackEntryId() {
        return trackEntryId;
    }

    public void setTrackEntryId(Long trackEntryId) {
        this.trackEntryId = trackEntryId;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Evidence getEvidence() {
        return evidence;
    }

    public void setEvidence(Evidence evidence) {
        this.evidence = evidence;
    }

    public Detective getDetective() {
        return detective;
    }

    public void setDetective(Detective detective) {
        this.detective = detective;
    }

    public TrackAction getAction() {
        return action;
    }

    public void setAction(TrackAction action) {
        this.action = action;
    }

    public String getResson() {
        return resson;
    }

    public void setResson(String resson) {
        this.resson = resson;
    }

    public void setTrackEntry(TrackEntry trackEntry) {

    }
    @Override
    public String toString() {
        return "TrackEntry{" +
                "trackEntryId=" + trackEntryId +
                ", version=" + version +
                ", cretedAt=" + cretedAt +
                ", modifiedAt=" + modifiedAt +
                ", date=" + date +
                ", evidence=" + evidence +
                ", detective=" + detective +
                ", action=" + action +
                ", resson='" + resson + '\'' +
                '}';
    }
}
