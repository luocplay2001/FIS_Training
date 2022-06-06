package dao.mem;

import core.Evidence;
import dao.IEvidenceDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EvidenceDAOMemImpl implements IEvidenceDAO {
    private List<Evidence> evidenceList = new ArrayList<>();

    public EvidenceDAOMemImpl() {

    }

    private static EvidenceDAOMemImpl instance = new EvidenceDAOMemImpl();

    public static EvidenceDAOMemImpl getInstance(){
        return instance;
    }

    @Override
    public Evidence addEvidence(Evidence evidence){
        evidenceList.add(evidence);
        return evidence;
    }

    @Override
    public Evidence findEvidenceById(Long evidenceId) {
        Optional<Evidence> opt = evidenceList.stream()
                .filter(e -> e.getEvidenceId() == evidenceId ? true : false).findFirst();
        if(opt.isPresent())
            return opt.get();
        return null;
    }

    @Override
    public List<Evidence> findAll() {
        return this.evidenceList;
    }

    @Override
    public Evidence update(Evidence evidence) {
        for(Evidence e: this.evidenceList){
            if(evidence.getEvidenceId() == e.getEvidenceId()) {
                e.setEvidence(evidence);
                return e;
            }
        }
        return null;
    }

    @Override
    public void remove(Long evidenceId){
         evidenceList.removeIf(e -> evidenceId == (e.getEvidenceId()));
    }

}
