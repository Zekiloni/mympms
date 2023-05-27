package com.mympms.v1.service;

import java.util.List;
import java.util.Optional;


public interface BaseServiceInterface<T> {
    T create(T entity);
    void update(T entity);
    void delete(T entity);
    void deleteMany(List<T> entities);
    List<T> getAll();
    Optional<T> getOneById(int entityId);
}
