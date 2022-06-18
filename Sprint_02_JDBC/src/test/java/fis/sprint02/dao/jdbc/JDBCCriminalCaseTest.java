package fis.sprint02.dao.jdbc;

import fis.sprint02.dao.IDAOCriminalCase;
import fis.sprint02.model.CriminalCase;
import fis.sprint02.model.Detective;
import fis.sprint02.model.enums.CaseStatus;
import fis.sprint02.model.enums.CaseType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class JDBCCriminalCaseTest {

    @Test
    void findAll() {
        IDAOCriminalCase idaoCriminalCase = new JDBCCriminalCase();
        List<CriminalCase> criminalCaseList = idaoCriminalCase.findAll();
        System.out.println(criminalCaseList.get(2).getModifiedAt());
        assertEquals(3,criminalCaseList.size());
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

    @Test
    void save() {
        IDAOCriminalCase idaoCriminalCase = new JDBCCriminalCase();
        CriminalCase c = new CriminalCase();
        c.setId(3L);
        c.setVersion(1);
        c.setCreatedAt(LocalDateTime.now());
        c.setModifiedAt(LocalDateTime.now());
        c.setNumber("1263621");
        c.setType(CaseType.FELONY);
        c.setShortDescription("12214");
        c.setDetailedDescription("1237172");
        c.setStatus(CaseStatus.SUBMITTED);
        c.setNotes("tuan anh bk dot");
        Detective d = new Detective();
        d.setId(1L);
        c.setLeadInvestigator(d);
        idaoCriminalCase.save(c);

    }

    @Test
    void update() {
    }
}