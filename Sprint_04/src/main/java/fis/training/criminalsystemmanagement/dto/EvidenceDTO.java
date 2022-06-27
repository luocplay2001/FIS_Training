package fis.training.criminalsystemmanagement.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import fis.training.criminalsystemmanagement.model.CriminalCase;
import fis.training.criminalsystemmanagement.model.Storage;
import fis.training.criminalsystemmanagement.model.TrackEntry;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvidenceDTO extends AbstractEntityDTO{
    private String number;

    private String itemName;

    private String notes;

    private Boolean archived;

    private CriminalCase criminalCase;

    private Storage storage;

    private Set<TrackEntry> trackEntries;
}
