package fis.sprint02.dao.jdbc;

import fis.sprint02.dao.IDAODetective;

import fis.sprint02.model.Detective;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class JDBCDetectiveTest {

    @Test
    void findAll() {
        IDAODetective idaoDetective = new JDBCDetective();
        List<Detective> detectiveList = idaoDetective.findAll();
        System.out.println(detectiveList);
    }

    @Test
    void findById() {
        IDAODetective idaoDetective = new JDBCDetective();
        Optional<Detective> detective = idaoDetective.findById(1L);
//        System.out.println(detective);
        assertEquals("123412",detective.get().getBadgeNumber());
    }
}