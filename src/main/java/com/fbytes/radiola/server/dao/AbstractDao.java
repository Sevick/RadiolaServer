package com.fbytes.radiola.server.dao;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.fbytes.radiola.server.model.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<PK extends Serializable, T> {
	
	private final Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public AbstractDao(){
		this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}

	public void persist(T entity) {
		getSession().persist(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}

	public void deleteByKey(PK key) {
		getSession().delete(getByKey(key));
	}

	public List<T> getList(){
		Criteria criteria = createEntityCriteria();
		return (java.util.List<T>) criteria.list();
	}


	
	protected Criteria createEntityCriteria(){
		return getSession().createCriteria(persistentClass).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
	}

}
