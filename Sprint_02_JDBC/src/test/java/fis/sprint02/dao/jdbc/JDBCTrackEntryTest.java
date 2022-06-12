package fis.sprint02.dao.jdbc;

import fis.sprint02.dao.IDAOCriminalCase;
import fis.sprint02.dao.IDAOTrackEntry;
import fis.sprint02.model.CriminalCase;
import fis.sprint02.model.TrackEntry;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class JDBCTrackEntryTest {

    @Test
    void findAll() {
        IDAOTrackEntry idaoTrackEntry = new JDBCTrackEntry();
        List<TrackEntry> trackEntryList = idaoTrackEntry.findAll();
        System.out.println(trackEntryList);
    }

    @Test
    void findById() {
        IDAOTrackEntry idaoTrackEntry = new JDBCTrackEntry();
        Optional<TrackEntry> trackEntry = idaoTrackEntry.findById(1L);
        assertEquals("resson",trackEntry.get().getResson());
    }
}