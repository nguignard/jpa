package DAO;

import java.util.Collection;

import model.Artist;

public interface ArtistDAO extends GenericDAO<Artist, Long> {

    public Collection<Artist> findAll(String lastName);

}
