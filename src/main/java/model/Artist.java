package model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "artist")
public class Artist extends Person {



    @Column(name = "bandName")
    private String bandName;

    @OneToOne()
    public SacemRegistration sacemRegistration;

    @ManyToOne()
    public Manager manager;

    @OneToMany(mappedBy = "artist")
    public Collection<Media> medias;

    @ManyToOne()
    public Instrument favoriteInstrument;

    @ManyToMany
    @JoinColumn(name = "artist_instrument", referencedColumnName = "artists", columnDefinition = "")
    public Collection<Instrument> instruments;


    public Artist(String firstName, String lastName) {
	super(firstName, lastName);
    }

    public String getBandName() {
	return bandName;
    }

    public void setBandName(String bandName) {
	this.bandName = bandName;
    }

    public SacemRegistration getSacemRegistration() {
	return sacemRegistration;
    }

    public void setSacemRegistration(SacemRegistration sacemRegistration) {
	this.sacemRegistration = sacemRegistration;
    }

    public Manager getManager() {
	return manager;
    }

    public void setManager(Manager manager) {
	this.manager = manager;
    }

    public Collection<Media> getMedias() {
	return medias;
    }

    public void setMedias(Collection<Media> medias) {
	this.medias = medias;
    }

    public Instrument getFavoriteInstrument() {
	return favoriteInstrument;
    }

    public void setFavoriteInstrument(Instrument favoriteInstrument) {
	this.favoriteInstrument = favoriteInstrument;
    }

    public Collection<Instrument> getInstruments() {
	return instruments;
    }

    public void setInstruments(Collection<Instrument> instruments) {
	this.instruments = instruments;
    }

}
