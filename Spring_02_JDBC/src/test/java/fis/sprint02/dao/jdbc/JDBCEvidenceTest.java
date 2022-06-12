package fis.sprint02.dao.jdbc;

import fis.sprint02.dao.IDAOEvidence;
import fis.sprint02.model.Evidence;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JDBCEvidenceTest {

    @Test
    void findAll() {
        IDAOEvidence idaoEvidence = new JDBCEvidence();
        List<Evidence> evidenceList = idaoEvidence.findAll();
        System.out.println(evidenceList);
    }
}