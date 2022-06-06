package dao;

import core.Detective;

import java.util.List;

public interface IDetectiveDAO {
    Detective addDetective(Detective detective);

    Detective findDetectiveById(Long detectiveId);

    List<Detective> findAll();

    Detective update(Detective detective);

    void remove(Long detectiveId);
}
