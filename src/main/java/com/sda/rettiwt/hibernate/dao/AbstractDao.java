package com.sda.rettiwt.hibernate.dao;

import com.sda.rettiwt.hibernate.config.HibernateUtils;
import com.sda.rettiwt.hibernate.entity.BaseEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T extends BaseEntity> {

    protected abstract Class<T> getClazz();

    public Optional<T> add(final T entity) {
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            return Optional.of(entity);
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public Optional<T> get(final Long id) {
        Session session = HibernateUtils.getSession();
        try {
            T entity = session.get(getClazz(), id);
            return Optional.of(entity);
        } catch (HibernateException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public Optional<List<T>> getAll() {
        Session session = HibernateUtils.getSession();
        try {
            List<T> entities = session.createQuery("FROM " + getClazz().getSimpleName()).list();
            return Optional.of(entities);
        } catch (HibernateException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public boolean remove(final T entity) {
        if (entity == null) {
            return false;
        }
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            session.remove(entity);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    public Optional<T> update(final T entity) {
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
            return Optional.of(entity);
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return Optional.empty();
        }
    }

}
