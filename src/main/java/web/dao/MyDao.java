package web.dao;

import web.model.User;

import java.util.List;

public interface MyDao<T> {
    void create(T t);
    T show(long id);
    List<T> getList();
    void update(long id, T t);
    void delete(long id);
    void delete(T t);
    List<User> find(T t);
}
