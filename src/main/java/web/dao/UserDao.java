package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User1;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDao implements MyDao<User1> {

    private final EntityManager entityManager;

    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(User1 user) {
        entityManager.joinTransaction();
        entityManager.persist(user);
    }

    @Override
    public User1 show(long id) {
        TypedQuery<User1> query = entityManager.createQuery("from User where id=:i", User1.class);
        query.setParameter("i", id);
        return query.getSingleResult();
    }

    @Override
    public List<User1> getList() {
        TypedQuery<User1> query = entityManager.createQuery("from User", User1.class);
        return query.getResultList();
    }

    @Override
    public void update(long id, User1 user) {
        entityManager.joinTransaction();
        User1 u = show(id);
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
    public void delete(User1 user) {
        entityManager.joinTransaction();
        find(user).forEach(u -> entityManager.remove(u.getId()));
    }

    @Override
    public List<User1> find(User1 user) {
        TypedQuery<User1> query = entityManager.createQuery("from User where name=:n and family=:f", User1.class);
        query.setParameter("n", user.getName());
        query.setParameter("f", user.getFamily());
        return query.getResultList();
    }
}
