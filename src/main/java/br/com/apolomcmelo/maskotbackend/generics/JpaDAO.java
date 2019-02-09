package br.com.apolomcmelo.maskotbackend.generics;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

public class JpaDAO<PK, T> {
	
	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public T getById(PK pk) {
		return (T) entityManager.find(getTypeClass(), pk);
	}

	public void insert(T entity) {
		entityManager.persist(entity);
	}

	public void update(T entity) {
		entityManager.merge(entity);
	}

	public void delete(T entity) {
		entityManager.remove(entity);
	}

	@SuppressWarnings("unchecked")
	public List<T> list() {
		return entityManager.createQuery(("FROM " + getTypeClass().getName())).getResultList();
	}
	
	public void insertAll(List<T> list){
		try {
			entityManager.getTransaction().begin();

			if (list != null) {
				list.forEach(entityManager::merge);
			}
			
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
	}

	private Class<?> getTypeClass() {
		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[1];
		return clazz;
	}
}