package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import model.Municipio;


public class MunicipioController {
	
	/**
	 * 
	 */
	public static List<Municipio> findByLikeDescription (String description) {
		List<Municipio> municipios = new ArrayList<Municipio>();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestionMunicipiosYProvinciasDDBB");

		EntityManager em = entityManagerFactory.createEntityManager();

	    Query q = em.createNativeQuery("SELECT * FROM municipio where nombre LIKE ?", Municipio.class);
	    q.setParameter(1, "%" + description + "%");

	    municipios.addAll(q.getResultList());
	    
	    em.close();

	    return municipios;
		
	}
	
	/**
	 * 
	 */
	public static Municipio findByDescription (String description) {
		Municipio m = new Municipio ();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestionMunicipiosYProvinciasDDBB");

		EntityManager em = entityManagerFactory.createEntityManager();

	    Query q = em.createNativeQuery("SELECT * FROM municipio where nombre LIKE ?", Municipio.class);
	    q.setParameter(1 ,description);

	    m = (Municipio) q.getSingleResult();
	    
	    em.close();

	    return m;
		
	}
	
	
	/**
	 * 
	 */
	public static void realizeUpdate (Municipio m) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestionMunicipiosYProvinciasDDBB");

		EntityManager em = entityManagerFactory.createEntityManager();		
		
		em.getTransaction().begin();
		em.merge(m);
		em.getTransaction().commit();
		em.close();
	}


}
