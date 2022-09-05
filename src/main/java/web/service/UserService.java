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
        System.out.println("ЭКЗЕМПЛЯР СЕРВИСА");
        this.dao = dao;
    }

    @Override
    public void add(User user) {
        dao.add(user);
    }

    @Override
    public User remove(int id) {
        return null;
    }

    @Override
    public User remove(User user) {
        return null;
    }

    @Override
    public User update(int id, User user) {
        return null;
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public boolean find(User user) {
        return dao.find(user);
    }

    @Override
    public List<User> getList() {
        return dao.getList();
    }
}
