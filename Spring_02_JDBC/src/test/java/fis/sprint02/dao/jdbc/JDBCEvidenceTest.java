package fis.sprint02.dao.jdbc;

import fis.sprint02.dao.IDAOEvidence;
import fis.sprint02.model.Evidence;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class JDBCEvidenceTest {

    @Test
    void findAll() {
        IDAOEvidence idaoEvidence = new JDBCEvidence();
        List<Evidence> evidenceList = idaoEvidence.findAll();
        System.out.println(evidenceList);
    }

    @Test
    void findById() {
        IDAOEvidence idaoEvidence = new JDBCEvidence();
        Optional<Evidence> evidence = idaoEvidence.findById(1L);
//        System.out.println(evidence);
        assertEquals("213412",evidence.get().getNumber());
    }
}