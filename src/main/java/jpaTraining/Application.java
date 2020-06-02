package jpaTraining;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Artist;
import model.Instrument;
import model.InstrumentType;
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
	Artist artistPersisted = null;

	try {
	    transaction.begin();
	    Artist artistV = new Artist("firstNameV", "nameV");
	    Artist artistF = new Artist("firstNameF", "nameF");
	    

	    SacemRegistration sacem = new SacemRegistration();
	    artistV.setSacemRegistration(sacem);

	    Manager manager = new Manager("managerFirstName", "managerLastName");
	    manager.addArtist(artistV);

	    Instrument violon = new Instrument("violon");
	    violon.setInstrumentType(InstrumentType.STRING.toString());
	    Instrument flute = new Instrument("flute");
	    flute.setInstrumentType(InstrumentType.WIND.toString());
	    
	    artistV.setFavoriteInstrument(violon);
	    artistF.setFavoriteInstrument(flute);
	    
	    em.persist(sacem);
	    em.persist(manager);
	    em.persist(violon);
	    em.persist(flute);
	    em.persist(artistV);
	    em.persist(artistF);
	    transaction.commit();
	    em.close();

	    em = emf.createEntityManager();
	    String q = "SELECT a FROM  Artist a where a.favoriteInstrument=:favoriteInstrumentsArtists";
	    Query query = em.createQuery(q);
	    query.setParameter("favoriteInstrumentsArtists", violon);
	    
	    List<Artist> artists = query.getResultList();
	    System.out.println("artists.size() " + artists.size());

	} catch (Exception e) {
	    e.printStackTrace();
	    transaction.rollback();
	}
	    
	em.close();
	emf.close();
    }
}
