package jpaTraining;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Artist;

public class Application {

    public static void main(String[] args) {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaTraining");
	EntityManager em = emf.createEntityManager();
	EntityTransaction transaction = em.getTransaction();
	transaction.begin();

	try {
	    Artist artist = new Artist("alain", "guisecke", "bandName");
	    em.persist(artist);
	    transaction.commit();

	} catch (Exception e) {
	    transaction.rollback();
	}
	    
	    
	    
	em.close();
	emf.close();
    }
}
