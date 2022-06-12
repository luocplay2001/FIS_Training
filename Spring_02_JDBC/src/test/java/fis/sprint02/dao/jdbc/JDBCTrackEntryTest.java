package fis.sprint02.dao.jdbc;

import fis.sprint02.dao.IDAOTrackEntry;
import fis.sprint02.model.TrackEntry;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JDBCTrackEntryTest {

    @Test
    void findAll() {
        IDAOTrackEntry idaoTrackEntry = new JDBCTrackEntry();
        List<TrackEntry> trackEntryList = idaoTrackEntry.findAll();
        System.out.println(trackEntryList);
    }
}