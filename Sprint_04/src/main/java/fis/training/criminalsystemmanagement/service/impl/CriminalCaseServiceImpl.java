package fis.training.criminalsystemmanagement.service.impl;

import fis.training.criminalsystemmanagement.dto.CriminalCaseDTO;
import fis.training.criminalsystemmanagement.model.CriminalCase;
import fis.training.criminalsystemmanagement.model.enums.CaseStatus;
import fis.training.criminalsystemmanagement.repository.CriminalCaseRepository;
import fis.training.criminalsystemmanagement.service.CriminalCaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CriminalCaseServiceImpl implements CriminalCaseService {

    CriminalCaseRepository criminalCaseRepository;

    @Autowired
    public CriminalCaseServiceImpl(CriminalCaseRepository criminalCaseRepository) {
        this.criminalCaseRepository = criminalCaseRepository;
    }

    @Override
    public List<CriminalCase> getAllCriminalCases() {
        return criminalCaseRepository.findAll();
    }

    @Override
    public CriminalCase getCriminalCaseById(Long id) {
        return criminalCaseRepository.findById(id).get();
    }

    @Override
    public CriminalCase saveCriminalCase(CriminalCase criminalCase) {
        return criminalCaseRepository.save(criminalCase);
    }

    @Override
    public CriminalCase updateCriminalCase(CriminalCase criminalCase) {
        return criminalCaseRepository.save(criminalCase);
    }

    @Override
    public void deleteCriminalCaseById(Long id) {
        criminalCaseRepository.deleteById(id);
    }

    @Override
    public List<CriminalCase> findAllByStatus(CaseStatus status) {
        return criminalCaseRepository.findByStatus(status);
    }

    @Override
    public List<CriminalCase> findByAssigned_Username(String username) {
        return criminalCaseRepository.findByAssigned_Username(username);
    }
}
