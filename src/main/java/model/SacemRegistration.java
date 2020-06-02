package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SacemRegistration")
public class SacemRegistration {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "code", unique = true)
    public String code;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date date;

    @OneToOne()
    public Artist artist;

    public SacemRegistration() {
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public Date getDate() {
	return date;
    }

    public void setDate(Date date) {
	this.date = date;
    }

    public Artist getArtist() {
	return artist;
    }

    public void setArtist(Artist artist) {
	this.artist = artist;
    }

}
