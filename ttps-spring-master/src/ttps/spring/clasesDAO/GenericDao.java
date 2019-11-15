package clasesDAO;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import interfacesDAO.GenericDAOInterface;

public class GenericDao<T> implements GenericDAOInterface<T> {
	protected Class<T> persistentClass;
	
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public void GenericDAOHibernateJPA(Class<T> clase) {
		 persistentClass = clase;
		  }
	
	@Override
	public T update(T entity) {
		 EntityManager entityManager = Persistence.createEntityManagerFactory("Java").createEntityManager();
		 EntityTransaction transaction = entityManager.getTransaction();
		 transaction.begin();
		 T entidad = entityManager.merge(entity);
		 transaction.commit();
		 entityManager.close();
		 return entidad;
	}

	@Override
	public void delete(T entity) {
		 EntityManager entityManager = Persistence.createEntityManagerFactory("Java").createEntityManager();
		 EntityTransaction transaction = null;
		 try {
		 transaction = entityManager.getTransaction();
		 transaction.begin();
		 entityManager.remove(entityManager.merge(entity));
		 transaction.commit();
		 }
		 catch (RuntimeException e) {
		 if ( transaction != null && transaction.isActive() ) transaction.rollback();
		 throw e; // escribir en un log o mostrar un mensaje
		 }
		 finally {
		 entityManager.close();
		 }
		}
		

	@Override
	public T delete(Serializable id) {
		T entity = ((EntityManager) Persistence.createEntityManagerFactory("Java")).find(this.getPersistentClass(), id);
				 if (entity != null) {
				 this.delete(entity);
				 }
				 return entity;
	}

	@Override
	public boolean exist(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T persist(T entity) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("Java").createEntityManager();
		EntityTransaction transaction = null;
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(entity);
			transaction.commit();
		}
		catch (RuntimeException e) {
			 if ( transaction != null && transaction.isActive() ) transaction.rollback();
			 throw e; // escribir en un log o mostrar un mensaje
		}
		 finally {
			 entityManager.close();
			 }
		return entity;
	}

	@Override
	public T search(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

}
