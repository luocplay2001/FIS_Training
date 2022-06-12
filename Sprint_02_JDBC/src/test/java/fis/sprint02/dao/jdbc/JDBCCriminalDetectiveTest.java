package fis.sprint02.dao.jdbc;

import fis.sprint02.dao.IDAOCriminalCase;
import fis.sprint02.dao.IDAOCriminalDetective;
import fis.sprint02.model.CriminalCase;
import fis.sprint02.model.CriminalDetective;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class JDBCCriminalDetectiveTest {

    @Test
    void findAll() {
        IDAOCriminalDetective idaoCriminalDetective = new JDBCCriminalDetective();
        List<CriminalDetective> criminalDetectiveList = idaoCriminalDetective.findAll();
        assertEquals(5,criminalDetectiveList.size());
    }

    @Test
    void findById() {
        IDAOCriminalDetective idaoCriminalDetective = new JDBCCriminalDetective();
        Optional<CriminalDetective> criminalDetective = idaoCriminalDetective.findById(1L);
//        System.out.println(criminalDetective);
        assertEquals("2147214",criminalDetective.get().getCriminalCase().getNumber());
    }
}