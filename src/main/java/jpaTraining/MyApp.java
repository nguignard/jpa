package jpaTraining;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import model.Artist;
import model.Instrument;
import model.InstrumentType;
import model.Manager;
import model.Media;
import model.MediaId;
import model.MediaType;
import model.SacemRegistration;

public class MyApp {

//	 @Autowired
//	    @Qualifier("pianist")
//	    private IMusician musicien;
//
//	    public void run() {
//		musicien.playing();
//	    }

public void run() {
	
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaTraining");
	EntityManager em = emf.createEntityManager();
	EntityTransaction transaction = em.getTransaction();

	MediaId mediaId2 = new MediaId("bbb", MediaType.DVD);
	Media m1 = new Media(mediaId2);
	m1.setReleaseDate(new Date(Calendar.getInstance().getTimeInMillis()));
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
//
//	    em = emf.createEntityManager();
//	    String q = "SELECT a FROM  Artist a where a.favoriteInstrument=:favoriteInstrumentsArtists";
//	    Query query = em.createQuery(q);
//	    query.setParameter("favoriteInstrumentsArtists", violon);
//	    
//	    List<Artist> artists = query.getResultList();
//	    System.out.println("artists.size() " + artists.size());

	    em = emf.createEntityManager();
	    CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Artist> query = cb.createQuery(Artist.class);
	    Root<Artist> a = query.from(Artist.class);

	    Join<Artist, Instrument> artInst = a.join("favoriteInstrument");
	    ParameterExpression<InstrumentType> param = cb.parameter(InstrumentType.class);
	    // query.select(a).where(cb.equal(artInst.get("instrument"), param));

	    //
	    Query q = em.createQuery(query);
	    List<Artist> artists = q.getResultList();
	    System.out.println("artists.size() " + artists.size());

	    // -----------------
//	    EntityManager entityManager = emf.createEntityManager();
//	    JPQLQuery jpaQuery = new JPAQuery(entityManager);

	    // List<Person> persons =
	    // query.from(person).where(person.firstName.eq("Kent")).list(person);

	    //

	} catch (Exception e) {
	    e.printStackTrace();
	    transaction.rollback();
	}
	    
	em.close();
	emf.close();
    }

}
