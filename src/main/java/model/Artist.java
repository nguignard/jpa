package model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "artist")
public class Artist extends Person {

    @Column(name = "bandName")
    private String bandName;

    @OneToOne
    public SacemRegistration sacemRegistration;

    @ManyToOne()
    public Manager manager;

    @OneToMany(mappedBy = "artist")
    public Collection<Media> medias;

//    @Column(name = "favorite_Instruments")
//    public Instrument favoriteInstruments;

//    @OneToMany(mappedBy = "artist")
//    public Collection<Instrument> playableInstruments;


    public Artist(String firstName, String lastName, String bandName) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.bandName = bandName;
    }
}
