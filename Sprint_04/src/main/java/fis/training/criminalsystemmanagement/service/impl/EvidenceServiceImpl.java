package fis.training.criminalsystemmanagement.service.impl;

import fis.training.criminalsystemmanagement.model.Evidence;
import fis.training.criminalsystemmanagement.repository.EvidenceRepository;
import fis.training.criminalsystemmanagement.service.EvidenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EvidenceServiceImpl implements EvidenceService {

    EvidenceRepository evidenceRepository;

    @Autowired
    public EvidenceServiceImpl(EvidenceRepository evidenceRepository) {
        this.evidenceRepository = evidenceRepository;
    }

    @Override
    public List<Evidence> getAllEvidences() {
        return evidenceRepository.findAll();
    }

    @Override
    public Evidence getEvidenceById(Long id) {
        return evidenceRepository.findById(id).get();
    }

    @Override
    public Evidence saveEvidence(Evidence evidence) {
        return evidenceRepository.save(evidence);
    }

    @Override
    public Evidence updateEvidence(Evidence evidence) {
        return evidenceRepository.save(evidence);
    }

    @Override
    public void deleteEvidenceById(Long id) {
        evidenceRepository.deleteById(id);
    }

    @Override
    public List<Evidence> findByCriminalCase_Number(String number) {
        return evidenceRepository.findByCriminalCase_Number(number);
    }
}
