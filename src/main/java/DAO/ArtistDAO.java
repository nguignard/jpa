package DAO;

import java.util.Collection;

import annotation.JpaHearing;
import model.Artist;

public interface ArtistDAO extends GenericDAO<Artist, Long> {

    @JpaHearing
    public Collection<Artist> findAll(String lastName);

}
