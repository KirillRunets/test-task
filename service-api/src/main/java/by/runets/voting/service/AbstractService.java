package by.runets.voting.service;

import by.runets.voting.exception.ResourceNotFoundException;

import java.util.List;

public interface AbstractService <T, K> {
    T find(K id);

    List<T> findAll();

    void save(T entity);

    void delete(K id) throws ResourceNotFoundException;
}
