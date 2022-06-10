package fis.sprint02.model;

import fis.sprint02.model.enums.TrackAction;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TrackEntry extends AbstractEntity {
    private LocalDateTime date;
    private Evidence evidence;
    private Detective detective;
    private TrackAction action;
    private String resson;

    public TrackEntry() {
    }

}
