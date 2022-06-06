package dao.mem;

import core.Storage;
import dao.IStorageDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StorageDAOMemImpl implements IStorageDAO {
    private List<Storage> storageList = new ArrayList<>();

    public StorageDAOMemImpl() {

    }

    private static StorageDAOMemImpl instance = new StorageDAOMemImpl();

    public static StorageDAOMemImpl getInstance(){
        return instance;
    }

    @Override
    public Storage addStorage(Storage storage){
        storageList.add(storage);
        return storage;
    }

    @Override
    public Storage findStorageById(Long storageId) {
        Optional<Storage> opt = storageList.stream()
                .filter(s -> s.getStorageId() == storageId ? true : false).findFirst();
        if(opt.isPresent())
            return opt.get();
        return null;
    }

    @Override
    public List<Storage> findAll() {
        return this.storageList;
    }

    @Override
    public Storage update(Storage storage) {
        for(Storage s: this.storageList){
            if(storage.getStorageId() == s.getStorageId()) {
                s.setStorage(storage);
                return s;
            }
        }
        return null;
    }

    @Override
    public void remove(Long storageId){
         storageList.removeIf(s -> storageId == (s.getStorageId()));
    }

}
