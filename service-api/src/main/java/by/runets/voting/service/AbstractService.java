package by.runets.voting.service;

import java.util.List;

public interface AbstractService <T, K> {
    T find(K id);

    List<T> findAll();

    void save(T entity);

    void delete(K id);
}
