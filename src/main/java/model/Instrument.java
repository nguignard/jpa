package model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Instrument")
public class Instrument {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    private String instrumentType;

    @ManyToMany(mappedBy = "instruments")
    private Collection<Artist> artists;

    @OneToMany(mappedBy = "favoriteInstrument")
    private Collection<Artist> favoriteInstrumentsArtists;

    public Instrument() {
	super();
    }

    //
    public Instrument(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Collection<Artist> getArtists() {
	return artists;
    }

    public void setArtists(Collection<Artist> artists) {
	this.artists = artists;
    }

    public Collection<Artist> getFavoriteInstruments() {
	return favoriteInstrumentsArtists;
    }

    public void setFavoriteInstruments(Collection<Artist> favoriteInstruments) {
	this.favoriteInstrumentsArtists = favoriteInstruments;
    }

    public int getId() {
	return id;
    }

    public String getInstrumentType() {
	return instrumentType;
    }

    public void setInstrumentType(String instrumentType) {
	this.instrumentType = instrumentType;
    }

    

}
