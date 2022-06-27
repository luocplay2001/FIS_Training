package fis.training.criminalsystemmanagement.core;

import fis.training.criminalsystemmanagement.model.CriminalCase;
import fis.training.criminalsystemmanagement.model.Detective;
import fis.training.criminalsystemmanagement.model.Evidence;

public class SetEntity {
    public static void setCriminalCase(CriminalCase c, CriminalCase criminalCaseRequest) {
        c.setNumber(criminalCaseRequest.getNumber());
        c.setVersion(criminalCaseRequest.getVersion());
        c.setCreatedAt(criminalCaseRequest.getCreatedAt());
        c.setModifiedAt(criminalCaseRequest.getModifiedAt());
        c.setShortDescription(criminalCaseRequest.getShortDescription());
        c.setDetailedDescription(criminalCaseRequest.getDetailedDescription());
        c.setType(criminalCaseRequest.getType());
        c.setStatus(criminalCaseRequest.getStatus());
        c.setNotes(criminalCaseRequest.getNotes());
        c.setLeadInvestigator(criminalCaseRequest.getLeadInvestigator());
        c.setEvidences(criminalCaseRequest.getEvidences());
        c.setAssigned(criminalCaseRequest.getAssigned());
    }

    public static void setDetective(Detective d, Detective detectiveRequest) {
        d.setVersion(detectiveRequest.getVersion());
        d.setCreatedAt(detectiveRequest.getCreatedAt());
        d.setModifiedAt(detectiveRequest.getModifiedAt());
        d.setUsername(detectiveRequest.getUsername());
        d.setFirstName(detectiveRequest.getFirstName());
        d.setLastName(detectiveRequest.getLastName());
        d.setBadgeNumber(detectiveRequest.getBadgeNumber());
        d.setPassword(detectiveRequest.getPassword());
        d.setHiringDate(detectiveRequest.getHiringDate());
        d.setRank(detectiveRequest.getRank());
        d.setStatus(detectiveRequest.getStatus());
        d.setArmed(detectiveRequest.getArmed());
        d.setCriminalCases(detectiveRequest.getCriminalCases());
        d.setTrackEntries(detectiveRequest.getTrackEntries());
    }

    public static void setEvidence(Evidence e, Evidence evidenceRequest) {
        e.setVersion(evidenceRequest.getVersion());
        e.setCreatedAt(evidenceRequest.getCreatedAt());
        e.setModifiedAt(evidenceRequest.getModifiedAt());
        e.setNumber(evidenceRequest.getNumber());
        e.setNotes(evidenceRequest.getNotes());
        e.setItemName(evidenceRequest.getItemName());
        e.setArchived(evidenceRequest.getArchived());
        e.setCriminalCase(evidenceRequest.getCriminalCase());
        e.setStorage(evidenceRequest.getStorage());
        e.setTrackEntries(evidenceRequest.getTrackEntries());
    }
}
