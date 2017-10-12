
package com.pwi.data;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.pwi.entity.*;;

public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public <T> Integer add(T object) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(object);
		tx.commit();
		Serializable id = session.getIdentifier(object);
		session.close();
		return (Integer) id;
	}

	@Override
	public <T> List<T> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<T> list = session.createQuery("from Product").list();
		session.close();
		return list;
	}

	@Override
	public <T> void getById(Integer id) {
		Session session = sessionFactory.openSession();
		//T object =  session.load(<T>.class, id);
		
	}

	@Override
	public <T> Integer update(T product) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(product);
		tx.commit();
		Serializable id = session.getIdentifier(product);
		session.close();
		return (Integer) id;
	}

	@Override
	public Integer delete(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Product product = (Product) session.load(Product.class, id);
		session.delete(product);
		tx.commit();
		Serializable ids = session.getIdentifier(product);
		session.close();
		return (Integer) ids;
	}

}
