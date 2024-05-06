package org.example.soa;

import java.util.List;

public interface CrudRepository<T>{
    T getById(String ID);
    List<T> getAll();
    boolean create(T student);
    boolean update(T student);
    boolean deleteById(String ID);
}
