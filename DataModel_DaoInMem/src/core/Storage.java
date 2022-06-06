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

    public Storage() {
    }

    public Storage(Long storageId, int version, LocalDateTime cretedAt
            , LocalDateTime modifiedAt, String name,
                   String location, Set<Evidence> evidenceSet) {
        this.storageId = storageId;
        this.version = version;
        this.cretedAt = cretedAt;
        this.modifiedAt = modifiedAt;
        this.name = name;
        this.location = location;
        this.evidenceSet = evidenceSet;
    }

    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Evidence> getEvidenceSet() {
        return evidenceSet;
    }

    public void setEvidenceSet(Set<Evidence> evidenceSet) {
        this.evidenceSet = evidenceSet;
    }

    public void setStorage(Storage storage) {

    }
    @Override
    public String toString() {
        return "Storage{" +
                "storageId=" + storageId +
                ", version=" + version +
                ", cretedAt=" + cretedAt +
                ", modifiedAt=" + modifiedAt +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", evidenceSet=" + evidenceSet +
                '}';
    }
}
