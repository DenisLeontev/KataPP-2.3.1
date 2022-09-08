package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDao implements MyDao<User> {

    private final EntityManager entityManager;

    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(User user) {
        entityManager.joinTransaction();
        entityManager.persist(user);
    }

    @Override
    public User show(long id) {
        TypedQuery<User> query = entityManager.createQuery("from User where id=:i", User.class);
        query.setParameter("i", id);
        return query.getSingleResult();
    }

    @Override
    public List<User> getList() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public void update(long id, User user) {
        entityManager.joinTransaction();
        User u = show(id);
        u.setName(user.getName());
        u.setFamily(user.getFamily());
        entityManager.persist(u);
    }

    @Override
    public void delete(long id) {
        entityManager.joinTransaction();
        try {
            entityManager.remove(show(id));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Override
    public void delete(User user) {
        entityManager.joinTransaction();
        find(user).forEach(u -> entityManager.remove(u.getId()));
    }

    @Override
    public List<User> find(User user) {
        TypedQuery<User> query = entityManager.createQuery("from User where name=:n and family=:f", User.class);
        query.setParameter("n", user.getName());
        query.setParameter("f", user.getFamily());
        return query.getResultList();
    }
}
