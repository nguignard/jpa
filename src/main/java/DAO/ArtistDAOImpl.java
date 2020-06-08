package DAO;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transaction;

import annotation.JpaHearing;
import model.Artist;

public class ArtistDAOImpl implements ArtistDAO {

    @JpaHearing
    @Override
    public Artist findById(Long id) {
	// TODO Auto-generated method stub
	return null;
    }

    @JpaHearing
    @Override
    public void update(Artist entity) {
	// TODO Auto-generated method stub

    }

    @JpaHearing
    @Override
    public void delete(Artist entity) {
	// TODO Auto-generated method stub

    }

    @JpaHearing
    @Override
    public void deleteByKey(Long id) {
	// TODO Auto-generated method stub

    }

    @JpaHearing
    @Override
    public void create(Artist entity) {
	// TODO Auto-generated method stub

    }

    @JpaHearing
    @Override
    public Artist findOne(Artist t) {
	Artist artist = null;
	EntityManager em = null;
	Transaction tx = null;

	try {
	    em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	    em.find(Artist.class, t);

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {

	}
	return artist;
    }

    @Override
    @JpaHearing
    public Collection<Artist> findAll(String lastName) {
	EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

	// EntityTransaction transaction = em.getTransaction();
	// transaction.begin();

	String q = " FROM  Artist";
	Query query = em.createQuery(q);
	// query.setParameter("favoriteInstrumentsArtists", violon);

	List<Artist> artists = query.getResultList();
	System.out.println("artists.size() " + artists.size());

//	String sqlString = "SELECT * from Artist";
//	Collection<Artist> artists = em.createNativeQuery(sqlString, Collection<Artist.class>);

	return artists;
    }

    @Override
    @JpaHearing
    public Collection<Artist> findAll() {
	// TODO Auto-generated method stub
	return null;
    }


}
