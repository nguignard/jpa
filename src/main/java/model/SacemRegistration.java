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
@Table(name = "SacemRegistrations")
public class SacemRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "code", unique = true)
    public String code;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date date;

    @OneToOne
    public Artist artist;

}
