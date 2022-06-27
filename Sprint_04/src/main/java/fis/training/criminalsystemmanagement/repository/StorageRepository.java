package fis.training.criminalsystemmanagement.repository;

import fis.training.criminalsystemmanagement.model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {
}
