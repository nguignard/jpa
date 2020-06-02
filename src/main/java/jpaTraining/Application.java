package jpaTraining;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Artist;
import model.Media;
import model.MediaId;
import model.MediaType;

public class Application {

    public static void main(String[] args) {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaTraining");
	EntityManager em = emf.createEntityManager();
	EntityTransaction transaction = em.getTransaction();

	MediaId mediaId2 = new MediaId("aaa", MediaType.CD);
	Media media2 = new Media(mediaId2);

	try {
	    transaction.begin();
	    Artist artist = new Artist("alain", "guisecke", "bandName");
	    em.persist(artist);
	    transaction.commit();

	    transaction.begin();
	    MediaId mediaId = new MediaId("aaa", MediaType.CD);
	    Media media = new Media(mediaId);
	    em.persist(media);
	    transaction.commit();
	    
	    em.find(Media.class, mediaId);
	    System.out.println(em.find(Media.class, mediaId2));

	    transaction.begin();
	    em.remove(media2);
	    transaction.commit();

	} catch (Exception e) {
	    e.getStackTrace();
	    transaction.rollback();
	}
	    
	    
	em.close();
	emf.close();
    }
}
