package core;

import java.time.LocalDateTime;
import java.util.Set;

public class CriminalCase {
    private Long criminalCaseId;
    private int version;
    private LocalDateTime cretedAt;
    private LocalDateTime modifiedAt;
    private String number;
    private CaseType type;
    private String shortDescription;
    private String detailedDescription;
    private CaseStatus status;
    private String notes;
    private Set<Evidence> evidenceSet;
    private Detective leadInvestigator; // lead
    private Set<Detective> assigned;// cac thanh vien phu

}
