package dao;

import core.CriminalCase;

public interface ICriminalCaseDAO {
    CriminalCase addCriminalCase(CriminalCase criminalCase);

    CriminalCase findCriminalCaseById(Long criminalCaseId);

    void remove(Long criminalCaseId);
}
