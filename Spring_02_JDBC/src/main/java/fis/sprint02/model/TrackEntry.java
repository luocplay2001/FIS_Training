package fis.sprint02.model;

import fis.sprint02.model.enums.TrackAction;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TrackEntry extends AbstractEntity {
    LocalDateTime date;
    Evidence evidence;
    Detective detective;
    TrackAction action;
    String reason;

    public TrackEntry() {
    }

}
