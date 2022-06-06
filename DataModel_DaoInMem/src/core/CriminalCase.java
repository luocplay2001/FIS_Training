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

    public CriminalCase() {
    }

    public CriminalCase(Long criminalCaseId, int version, LocalDateTime cretedAt,
                        LocalDateTime modifiedAt, String number, CaseType type,
                        String shortDescription, String detailedDescription, CaseStatus status,
                        String notes, Set<Evidence> evidenceSet, Detective leadInvestigator,
                        Set<Detective> assigned) {
        this.criminalCaseId = criminalCaseId;
        this.version = version;
        this.cretedAt = cretedAt;
        this.modifiedAt = modifiedAt;
        this.number = number;
        this.type = type;
        this.shortDescription = shortDescription;
        this.detailedDescription = detailedDescription;
        this.status = status;
        this.notes = notes;
        this.evidenceSet = evidenceSet;
        this.leadInvestigator = leadInvestigator;
        this.assigned = assigned;
    }

    public Long getCriminalCaseId() {
        return criminalCaseId;
    }

    public void setCriminalCaseId(Long criminalCaseId) {
        this.criminalCaseId = criminalCaseId;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CaseType getType() {
        return type;
    }

    public void setType(CaseType type) {
        this.type = type;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public void setDetailedDescription(String detailedDescription) {
        this.detailedDescription = detailedDescription;
    }

    public CaseStatus getStatus() {
        return status;
    }

    public void setStatus(CaseStatus status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Set<Evidence> getEvidenceSet() {
        return evidenceSet;
    }

    public void setEvidenceSet(Set<Evidence> evidenceSet) {
        this.evidenceSet = evidenceSet;
    }

    public Detective getLeadInvestigator() {
        return leadInvestigator;
    }

    public void setLeadInvestigator(Detective leadInvestigator) {
        this.leadInvestigator = leadInvestigator;
    }

    public Set<Detective> getAssigned() {
        return assigned;
    }

    public void setAssigned(Set<Detective> assigned) {
        this.assigned = assigned;
    }

    public void setCriminal(CriminalCase criminalCase) {
        setAssigned(criminalCase.getAssigned());
        setCretedAt(criminalCase.getCretedAt());
        setEvidenceSet(criminalCase.getEvidenceSet());
        setNotes(criminalCase.getNotes());
        setDetailedDescription(criminalCase.getDetailedDescription());
        setLeadInvestigator(criminalCase.getLeadInvestigator());
        setModifiedAt(criminalCase.getModifiedAt());
        setNumber(criminalCase.getNumber());
        setShortDescription(criminalCase.getShortDescription());
        setStatus(criminalCase.getStatus());
        setType(criminalCase.getType());
        setVersion(criminalCase.getVersion());
    }

    @Override
    public String toString() {
        return "CriminalCase{" +
                "criminalCaseId=" + criminalCaseId +
                ", version=" + version +
                ", cretedAt=" + cretedAt +
                ", modifiedAt=" + modifiedAt +
                ", number='" + number + '\'' +
                ", type=" + type +
                ", shortDescription='" + shortDescription + '\'' +
                ", detailedDescription='" + detailedDescription + '\'' +
                ", status=" + status +
                ", notes='" + notes + '\'' +
                ", evidenceSet=" + evidenceSet +
                ", leadInvestigator=" + leadInvestigator +
                ", assigned=" + assigned +
                '}';
    }
}
