package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.MyDao;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserService implements MyService<User> {
    private final MyDao<User> dao;

    public UserService(MyDao<User> dao) {
        this.dao = dao;
    }

    @Override
    public void create(User user) {
        dao.create(user);
    }

    @Override
    public void delete(long id) {
        dao.delete(id);
    }

    @Override
    public void delete(User user) {
        dao.delete(user);
    }

    @Override
    public void update(long id, User user) {
        dao.update(id, user);
    }

    @Override
    @Transactional(readOnly = true)
    public User show(long id) {
        return dao.show(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> find(User user) {
        return dao.find(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getList() {
        return dao.getList();
    }
}
