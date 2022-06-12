package fis.sprint02.dao;

import java.util.List;
import java.util.Optional;

public interface IDAO<T> {
    //CREATE
    T save(T t);

    //READ | RETRIEVE
    Optional<T> findById(Long id);
    List<T> findAll();

    //UPDATE
    void update(T t);

    //DELETE
    T delete(T t);
}
