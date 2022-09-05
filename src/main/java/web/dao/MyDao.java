package web.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface MyDao<T> {
    void add(T t);
    T remove(int id);
    T remove(T t);
    T update(int id, T t);
    T get(int id);
    boolean find(T t);
    List<T> getList();
}
