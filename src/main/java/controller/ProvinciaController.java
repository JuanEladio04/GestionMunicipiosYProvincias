package controller;

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
	 * @return
	 */
	public static List<Provincia> findAll() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestionMunicipiosYProvinciasDDBB");

		EntityManager em = entityManagerFactory.createEntityManager();
		
		TypedQuery<Provincia> query = em.createNamedQuery("Provincia.findAll", Provincia.class);
		List<Provincia> results = query.getResultList();

		em.close();
		return results;
	}
	
	
	/**
	 * 
	 * @param string
	 */
	public static Provincia findByName(String description) {
		Provincia p = new Provincia ();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestionMunicipiosYProvinciasDDBB");

		EntityManager em = entityManagerFactory.createEntityManager();

	    Query q = em.createNativeQuery("SELECT * FROM municipio where nombre LIKE ?", Provincia.class);
	    q.setParameter(1, description);

	    p = (Provincia) q.getSingleResult();
	    
	    em.close();

	    return p;
		
	}
	
	
		
}
