package fis.sprint02.dao.jdbc;

import fis.sprint02.dao.IDAOCriminalCase;
import fis.sprint02.model.CriminalCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class JDBCCriminalCaseTest {

    @Test
    void findAll() {
        IDAOCriminalCase idaoCriminalCase = new JDBCCriminalCase();
        List<CriminalCase> criminalCaseList = idaoCriminalCase.findAll();
        System.out.println(criminalCaseList);
        assertEquals(2,criminalCaseList.size());
    }

    @Test
    void findById() {
        IDAOCriminalCase idaoCriminalCase = new JDBCCriminalCase();
        Optional<CriminalCase> criminalCase = idaoCriminalCase.findById(1L);
        assertEquals("2147214",criminalCase.get().getNumber());
    }

    @Test
    void delete() {
        IDAOCriminalCase idaoCriminalCase = new JDBCCriminalCase();
        CriminalCase c = new CriminalCase();
        c.setId(3l);
        c.setNumber("22142342");
        CriminalCase criminalCase = idaoCriminalCase.delete(c);
        assertEquals("22142342",criminalCase.getNumber());
    }
}