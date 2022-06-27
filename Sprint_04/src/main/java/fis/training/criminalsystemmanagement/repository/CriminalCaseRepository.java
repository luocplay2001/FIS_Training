package fis.training.criminalsystemmanagement.repository;

import fis.training.criminalsystemmanagement.model.CriminalCase;
import fis.training.criminalsystemmanagement.model.enums.CaseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriminalCaseRepository extends JpaRepository<CriminalCase, Long> {

    List<CriminalCase> findByStatus(CaseStatus status);
    List<CriminalCase> findByAssigned_Username (String username);
}
