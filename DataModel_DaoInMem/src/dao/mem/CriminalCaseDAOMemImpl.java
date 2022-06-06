package dao.mem;

import core.CriminalCase;
import dao.ICriminalCaseDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;  

public class CriminalCaseDAOMemImpl implements ICriminalCaseDAO {
    private List<CriminalCase> criminalCaseList = new ArrayList<>();

    public CriminalCaseDAOMemImpl() {

    }

    private static CriminalCaseDAOMemImpl instance = new CriminalCaseDAOMemImpl();

    public static CriminalCaseDAOMemImpl getInstance(){
        return instance;
    }

    @Override
    public CriminalCase addCriminalCase(CriminalCase criminalCase){
        criminalCaseList.add(criminalCase);
        return criminalCase;
    }

    @Override
    public CriminalCase findCriminalCaseById(Long criminalCaseId) {
        Optional<CriminalCase> opt = criminalCaseList.stream()
                .filter(c -> c.getCriminalCaseId() == criminalCaseId ? true : false).findFirst();
        if(opt.isPresent())
            return opt.get();
        return null;
    }

    @Override
    public List<CriminalCase> findAll() {
        return this.criminalCaseList;
    }

    @Override
    public CriminalCase update(CriminalCase criminalCase) {
        for(CriminalCase c: this.criminalCaseList){
            if(criminalCase.getCriminalCaseId() == c.getCriminalCaseId()) {
                c.setCriminal(criminalCase);
                return c;
            }
        }
        return null;
    }

    @Override
    public void remove(Long criminalCaseId){
         criminalCaseList.removeIf(c -> criminalCaseId == (c.getCriminalCaseId()));
    }

}
