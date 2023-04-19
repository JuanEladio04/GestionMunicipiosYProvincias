package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Municipio;
import model.Provincia;

public class ProvinciaController {
	
	
	/**
	 * 
	 * @param string
	 */
	public static List<Provincia> findById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestionMunicipiosYProvinciasDDBB");
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM provincia order by id = ? desc;", Provincia.class);
		q.setParameter(1, id);
		
		List<Provincia> p = (List<Provincia>) q.getResultList();
		em.close();
		return p;
		
		
	}
	
	
		
}
