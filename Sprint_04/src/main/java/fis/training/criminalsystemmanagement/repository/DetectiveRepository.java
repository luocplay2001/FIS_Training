package fis.training.criminalsystemmanagement.repository;

import fis.training.criminalsystemmanagement.model.Detective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetectiveRepository extends JpaRepository<Detective, Long> {
    Detective findByUsername(String username);
}
