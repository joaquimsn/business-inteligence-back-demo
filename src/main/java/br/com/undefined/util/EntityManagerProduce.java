package br.com.undefined.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class EntityManagerProduce {
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	public EntityManagerFactory EntityManagerFactory() {
		try {
			entityManagerFactory = EntityManagerFactory.class.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		
		return entityManagerFactory;
	}
	
	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
	
	public void closeEntityManager(@Disposes EntityManager entityManager) {
		if (entityManager.isOpen()) {
			entityManager.close();
		}
	}
}
