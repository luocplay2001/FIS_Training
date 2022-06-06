package dao.mem;

import core.Detective;
import dao.IDetectiveDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DetectiveDAOMemImpl implements IDetectiveDAO {
    private List<Detective> detectiveList = new ArrayList<>();

    public DetectiveDAOMemImpl() {

    }

    private static DetectiveDAOMemImpl instance = new DetectiveDAOMemImpl();

    public static DetectiveDAOMemImpl getInstance(){
        return instance;
    }

    @Override
    public Detective addDetective(Detective detective){
        detectiveList.add(detective);
        return detective;
    }

    @Override
    public Detective findDetectiveById(Long detectiveId) {
        Optional<Detective> opt = detectiveList.stream()
                .filter(d -> d.getDetectiveId() == detectiveId ? true : false).findFirst();
        if(opt.isPresent())
            return opt.get();
        return null;
    }

    @Override
    public List<Detective> findAll() {
        return this.detectiveList;
    }

    @Override
    public Detective update(Detective detective) {
        for(Detective d: this.detectiveList){
            if(detective.getDetectiveId() == d.getDetectiveId()) {
                d.setDetective(detective);
                return d;
            }
        }
        return null;
    }

    @Override
    public void remove(Long detectiveId){
         detectiveList.removeIf(d -> detectiveId == (d.getDetectiveId()));
    }

}
