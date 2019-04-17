package com.jazwa.dao;

import com.jazwa.model.Post;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class PostDaoImpl implements PostDao{
    private static final String PERSISTANCE_NAME = "store";
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory(PERSISTANCE_NAME);
    @Override
    public List<Post> findAll() {
        EntityManager em = FACTORY.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("from posts");
        List<Post> users = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return users;
    }

    @Override
    public boolean create(Post post) {
        EntityManager em = FACTORY.createEntityManager();
        em.getTransaction().begin();
        em.persist(post);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean delete(long id) {
        EntityManager em = FACTORY.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("delete posts where id=:id").setParameter("id", id).executeUpdate();
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean update(Post post) {
        EntityManager em = FACTORY.createEntityManager();
        em.getTransaction().begin();

        em.merge(post);

        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public Optional<Post> get(long id) {
        EntityManager em = FACTORY.createEntityManager();
        em.getTransaction().begin();
        Query query= em.createQuery("from posts where id=:id").setParameter("id", id);

        Optional<Post> post = query.getResultStream().findFirst();
        em.getTransaction().commit();
        em.close();

        return post;
    }

}
