package fis.training.criminalsystemmanagement.dto;

import fis.training.criminalsystemmanagement.model.CriminalCase;
import fis.training.criminalsystemmanagement.model.Detective;
import fis.training.criminalsystemmanagement.model.Evidence;
import fis.training.criminalsystemmanagement.model.enums.CaseStatus;
import fis.training.criminalsystemmanagement.model.enums.CaseType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CriminalCaseDTO extends AbstractEntityDTO{
    private String number;

    private CaseType type;

    private String shortDescription;

    private String detailedDescription;

    private CaseStatus status;

    private String notes;

    private Set<Evidence> evidences;

    private Detective leadInvestigator; // lead

    private Set<Detective> assigned;
}
