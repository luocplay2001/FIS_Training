package fis.training.criminalsystemmanagement.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import fis.training.criminalsystemmanagement.model.CriminalCase;
import fis.training.criminalsystemmanagement.model.TrackEntry;
import fis.training.criminalsystemmanagement.model.enums.EmploymentStatus;
import fis.training.criminalsystemmanagement.model.enums.Rank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetectiveDTO extends AbstractEntityDTO{
    private String username;

    private String firstName;

    private String lastName;

    private String password;

    private String badgeNumber;

    private LocalDateTime hiringDate;

    private Rank rank;

    private Boolean armed;

    private EmploymentStatus status;

    private Set<CriminalCase> criminalCases;

    private Set<TrackEntry> trackEntries;
}
