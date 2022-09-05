package web.service;

import org.springframework.stereotype.Service;

import java.util.List;

public interface MyService<T> {
    void add(T t);
    T remove(int id);
    T remove(T t);
    T update(int id, T t);
    T get(int id);
    boolean find(T t);
    List<T> getList();
}
