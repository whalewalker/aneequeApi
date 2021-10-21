package com.example.authapi.data.repository;

import java.util.List;
import java.util.Optional;

public class BankRepository<T extends Storable> implements Database<T>{
    @Override
    public void save(T t) {

    }

    @Override
    public boolean contains(T t) {
        return false;
    }

    @Override
    public void delete(T t) {

    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Optional<T> findById(String StorableId) {
        return Optional.empty();
    }

    @Override
    public Optional<T> findByName(String StorableId) {
        return Optional.empty();
    }

    @Override
    public Optional<T> findByAccountNumber(String storableAccountNumber) {
        return Optional.empty();
    }
}
