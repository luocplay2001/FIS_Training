package fis.training.criminalsystemmanagement.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
public abstract class AbstractEntityDTO {

    private Long id;

    private int version;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
}
