package model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Manager")
public class Manager extends Person {

    public int budget;

    public Manager(String firstName, String lastName) {
	super(firstName, lastName);
    }

    public Manager() {
	super();
    }
    
    @OneToMany(mappedBy = "manager")
    public Collection<Artist> artists;

    public int getBudget() {
	return budget;
    }

    public void setBudget(int budget) {
	this.budget = budget;
    }

    public Collection<Artist> getArtists() {
	return artists;
    }

    public void addArtist(Artist artist) {
	if (artists == null) {
	    this.artists = new ArrayList<Artist>();
	}
	this.artists.add(artist);
    }

}
