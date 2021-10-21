package com.example.authapi.data.repository;

import java.util.List;
import java.util.Optional;

public interface Database<T> {
    void save(T t);

    boolean contains(T t);

    void delete(T t);

    List<T> findAll();

    int size();

    Optional<T> findById(String StorableId);

    Optional<T> findByName(String StorableId);

    Optional<T> findByAccountNumber(String storableAccountNumber);
}
