package fis.sprint02.dao.jdbc;

import fis.sprint02.dao.IDAOCriminalCase;
import fis.sprint02.model.CriminalCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JDBCCriminalCaseTest {

    @Test
    void findAll() {
        IDAOCriminalCase idaoCriminalCase = new JDBCCriminalCase();
        List<CriminalCase> criminalCaseList = idaoCriminalCase.findAll();
        assertEquals(1,criminalCaseList.size());
    }
}