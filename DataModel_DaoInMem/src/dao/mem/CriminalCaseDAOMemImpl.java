package dao.mem;

import core.CriminalCase;
import dao.ICriminalCaseDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;  

public class CriminalCaseDAOMemImpl implements ICriminalCaseDAO {
    private List<CriminalCase> criminalCaseList;

    public CriminalCaseDAOMemImpl() {
        criminalCaseList = new ArrayList<>();
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
    public void remove(Long criminalCaseId){
        criminalCaseList.removeIf(c -> criminalCaseId == (c.getCriminalCaseId()));
    }

}
