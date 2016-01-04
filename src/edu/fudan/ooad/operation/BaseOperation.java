package edu.fudan.ooad.operation;

import edu.fudan.ooad.entity.IEntity;
import edu.fudan.ooad.provider.HibernateManager;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Kaiyuan on 2016/1/4.
 */
@SuppressWarnings("unchecked")
public class BaseOperation {

    public static <T extends IEntity> void insert(T entity) {
        Session session = null;
        try {
            session = HibernateManager.getSession();
            System.out.println(session.save(entity));
        } finally {
            HibernateManager.closeSession(session);
        }
    }

    public static <T> void delete(T entity) {
        Session session = null;
        try {
            session = HibernateManager.getSession();
            session.delete(entity);
        } finally {
            HibernateManager.closeSession(session);
        }
    }

    public static <T> void update(T entity) {
        Session session = null;
        try {
            session = HibernateManager.getSession();
            session.update(entity);
        } finally {
            HibernateManager.closeSession(session);
        }
    }

    public static <T> List<T> queryAll(Class<T> clazz) {
        Session session = null;
        try {
            session = HibernateManager.getSession();
            Query query = session.createQuery("from " + clazz.getSimpleName());
            return query.list();
        } finally {
            HibernateManager.closeSession(session);
        }
    }
}