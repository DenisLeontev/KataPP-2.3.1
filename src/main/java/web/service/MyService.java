package web.service;

import web.model.User1;

import java.util.List;

public interface MyService<T> {
    void create(T t);
    T show(long id);
    List<T> getList();
    void update(long id, T t);
    void delete(long id);
    void delete(T t);
    List<User1> find(T t);
}
