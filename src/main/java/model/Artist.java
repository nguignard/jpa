package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "artists")
public class Artist extends Person {

    @Column(name = "bandName")
    private String bandName;

//    @ManyToOne()
//    public Manager manager;



    public Artist(String firstName, String lastName, String bandName) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.bandName = bandName;
    }
}
