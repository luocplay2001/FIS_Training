package fis.sprint02.dao.jdbc;

import fis.sprint02.dao.IDAOStorage;
import fis.sprint02.model.Storage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JDBCStorageTest {

    @Test
    void findAll() {
        IDAOStorage idaoStorage = new JDBCStorage();
        List<Storage> storageList = idaoStorage.findAll();
        System.out.println(storageList);
    }
}