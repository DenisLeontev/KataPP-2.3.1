package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.MyDao;
import web.model.User1;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service
@Transactional
public class UserService implements MyService<User1> {
    private final MyDao<User1> dao;

    public UserService(MyDao<User1> dao) {
        this.dao = dao;
    }

    @Override
    public void create(User1 user) {
        dao.create(user);
    }

    @Override
    public void delete(long id) {
        dao.delete(id);
    }

    @Override
    public void delete(User1 user) {
        dao.delete(user);
    }

    @Override
    public void update(long id, User1 user) {
        dao.update(id, user);
    }

    @Override
    @Transactional(readOnly = true)
    public User1 show(long id) {
        return dao.show(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User1> find(User1 user) {
        return dao.find(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User1> getList() {
        return dao.getList();
    }


    // требуется библиотека javax.annotation
    @PostConstruct
    private void init() {
        System.out.println("Получена зависимость: " + dao);
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Уничтожен компонент UserService");
    }
}
