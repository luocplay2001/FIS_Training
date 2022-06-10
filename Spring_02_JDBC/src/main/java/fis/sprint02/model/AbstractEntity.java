package fis.sprint02.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class AbstractEntity {
    private long id;
    private int version;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public AbstractEntity() {
    }

    public AbstractEntity(long id, int version, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.version = version;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
