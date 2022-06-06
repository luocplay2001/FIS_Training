package dao;

import core.CriminalCase;

import java.util.List;

public interface ICriminalCaseDAO {
    CriminalCase addCriminalCase(CriminalCase criminalCase);

    CriminalCase findCriminalCaseById(Long criminalCaseId);

    List<CriminalCase> findAll();

    CriminalCase update(CriminalCase criminalCase);

    void remove(Long criminalCaseId);
}
