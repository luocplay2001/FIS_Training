package fis.training.criminalsystemmanagement.repository;

import fis.training.criminalsystemmanagement.model.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvidenceRepository extends JpaRepository<Evidence, Long> {
    List<Evidence> findByCriminalCase_Number(String number);
}
