package web.dao;

import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDao implements MyDao<User> {

    private final EntityManager entityManager;

    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(User user) {
        entityManager.joinTransaction();
        entityManager.persist(user);
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
        TypedQuery<User> query = entityManager.createQuery("from User where id=:i", User.class);
        query.setParameter("i", id);
        return query.getSingleResult();
    }

    @Override
    public boolean find(User user) {
        TypedQuery<User> query = entityManager.createQuery("from User where name=:n and family=:f", User.class);
        query.setParameter("n", user.getName());
        query.setParameter("f", user.getFamily());
        return !query.getResultList().isEmpty();
    }

    @Override
    public List<User> getList() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }
}
