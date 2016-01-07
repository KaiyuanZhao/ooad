package edu.fudan.ooad.operation;

import com.sun.istack.internal.Nullable;
import edu.fudan.ooad.entity.IEntity;
import edu.fudan.ooad.provider.HibernateManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.Collections;
import java.util.List;

/**
 * Created by Kaiyuan on 2016/1/4.
 */
@SuppressWarnings("unchecked")
public class DatabaseOperation {

    public static <T extends IEntity> void insert(T entity) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateManager.getSession();
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null)
                transaction.rollback();
        } finally {
            HibernateManager.closeSession(session);
        }
    }

    public static <T extends IEntity> void delete(T entity) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateManager.getSession();
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null)
                transaction.rollback();
        } finally {
            HibernateManager.closeSession(session);
        }
    }

    public static <T extends IEntity> void delete(Class<T> clazz) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateManager.getSession();
            transaction = session.beginTransaction();
            session.createQuery("delete " + clazz.getSimpleName()).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null)
                transaction.rollback();
        } finally {
            HibernateManager.closeSession(session);
        }
    }

    public static <T extends IEntity> void update(T entity) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateManager.getSession();
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null)
                transaction.rollback();
        } finally {
            HibernateManager.closeSession(session);
        }
    }

    @Nullable
    public static <T extends IEntity> T queryById(Class<T> clazz, String id) {
        Session session = null;
        try {
            session = HibernateManager.getSession();
            return (T) session.createCriteria(clazz)
                    .add(Restrictions.idEq(id))
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateManager.closeSession(session);
        }
    }

    public static <T extends IEntity> List<T> queryHQL(String hql) {
        Session session = null;
        try {
            session = HibernateManager.getSession();
            Query query = session.createQuery(hql);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            HibernateManager.closeSession(session);
        }
    }

    public static <T extends IEntity> List<T> queryHQL(Class<T> clazz, String hql) {
        Session session = null;
        try {
            session = HibernateManager.getSession();
            String queryString = "from " + clazz.getSimpleName() + " " + hql;
            Query query = session.createQuery(queryString);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            HibernateManager.closeSession(session);
        }
    }

    public static <T extends IEntity> List<T> querySQL(String sql) {
        Session session = null;
        try {
            session = HibernateManager.getSession();
            Query query = session.createSQLQuery(sql);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            HibernateManager.closeSession(session);
        }
    }

    public static <T extends IEntity> List<T> queryAll(Class<T> clazz) {
        Session session = null;
        try {
            session = HibernateManager.getSession();
            return session.createCriteria(clazz)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            HibernateManager.closeSession(session);
        }
    }
}
