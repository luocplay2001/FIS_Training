package fis.training.criminalsystemmanagement.service;


import fis.training.criminalsystemmanagement.model.Evidence;

import java.util.List;

public interface EvidenceService {


    List<Evidence> getAllEvidences();

    Evidence getEvidenceById(Long id);

    Evidence saveEvidence(Evidence evidence);

    Evidence updateEvidence(Evidence evidence);

    void deleteEvidenceById(Long id);

    List<Evidence> findByCriminalCase_Number(String number);
}
