package fis.sprint02.dao.jdbc;

import fis.sprint02.dao.IDAOCriminalCase;
import fis.sprint02.dao.IDAOStorage;
import fis.sprint02.model.CriminalCase;
import fis.sprint02.model.Storage;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class JDBCStorageTest {

    @Test
    void findAll() {
        IDAOStorage idaoStorage = new JDBCStorage();
        List<Storage> storageList = idaoStorage.findAll();
        System.out.println(storageList);
    }

    @Test
    void findById() {
        IDAOStorage idaoStorage = new JDBCStorage();
        Optional<Storage> storage = idaoStorage.findById(1L);
        assertEquals("kho 1",storage.get().getName());
    }
}