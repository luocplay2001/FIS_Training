package fis.training.criminalsystemmanagement.service;

import fis.training.criminalsystemmanagement.dto.CriminalCaseDTO;
import fis.training.criminalsystemmanagement.model.CriminalCase;
import fis.training.criminalsystemmanagement.model.enums.CaseStatus;

import java.util.List;

public interface CriminalCaseService {

    List<CriminalCase> getAllCriminalCases();

    CriminalCase getCriminalCaseById(Long id);

    CriminalCase saveCriminalCase(CriminalCase criminalCase);

    CriminalCase updateCriminalCase(CriminalCase criminalCase);

    void deleteCriminalCaseById(Long id);

    List<CriminalCase> findAllByStatus(CaseStatus status);
    List<CriminalCase> findByAssigned_Username (String username);
}
