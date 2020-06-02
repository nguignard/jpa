package jpaTraining;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Artist;
import model.Manager;
import model.Media;
import model.MediaId;
import model.MediaType;
import model.SacemRegistration;

public class Application {

    public static void main(String[] args) {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaTraining");
	EntityManager em = emf.createEntityManager();
	EntityTransaction transaction = em.getTransaction();

	MediaId mediaId2 = new MediaId("bbb", MediaType.DVD);
	Media m1 = new Media(mediaId2);
	m1.releaseDate = new Date(Calendar.getInstance().getTimeInMillis());


	try {
	    transaction.begin();
	    Artist artist = new Artist("Bertrand", "Delanoe");

	    SacemRegistration sacem = new SacemRegistration();
	    artist.setSacemRegistration(sacem);

	    Manager manager = new Manager("managerFName", "managerLastName");
	    manager.setBudget(10);

	    manager.addArtist(artist);

	    em.persist(sacem);
	    em.persist(manager);
	    em.persist(artist);

	    transaction.commit();
	} catch (Exception e) {
	    e.printStackTrace();
	    transaction.rollback();
	}
	    
	em.close();
	emf.close();
    }
}
