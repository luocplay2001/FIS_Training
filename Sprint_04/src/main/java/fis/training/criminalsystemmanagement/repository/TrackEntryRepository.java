package fis.training.criminalsystemmanagement.repository;

import fis.training.criminalsystemmanagement.model.TrackEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackEntryRepository extends JpaRepository<TrackEntry, Long> {
}
