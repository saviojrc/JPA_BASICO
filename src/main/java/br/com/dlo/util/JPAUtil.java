package br.com.dlo.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory entityManagerFactory;
	private  static EntityManager entityManager;
	
	private static EntityManagerFactory getEntityManagerFactory() {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("part2-DIO");
			

			return entityManagerFactory;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException(e.getMessage());
		}
	}
	
	
	
	public static EntityManager getEntityManager() {
		try {
			
			entityManager = getEntityManagerFactory().createEntityManager();
			return entityManager;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException(e.getMessage());
		}
	}
}
