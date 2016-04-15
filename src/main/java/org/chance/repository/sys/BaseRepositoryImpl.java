package org.chance.repository.sys;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by wqg on 2016/3/27.
 */

@Repository(value = "baseRepository")
public class BaseRepositoryImpl implements BaseRepository{

//    @Autowired(required = false)
//    private SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Session getSession() {
//        return sessionFactory.getCurrentSession();
        return null;
    }

    @Override
    public List queryBySql(String sql) {
//        List<Object[]> list = getSession().createSQLQuery(sql).list();
        List<Object[]> list = entityManager.createNativeQuery(sql).getResultList();
        return list;
    }

    @Override
    public int excuteBySql(String sql) {
        int result;
        //SQLQuery query = this.getSession().createSQLQuery(sql);
        Query query = entityManager.createNativeQuery(sql);
        result = query.executeUpdate();
        return result;
    }
}
