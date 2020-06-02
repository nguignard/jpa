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
    public String name;

//    @OneToOne
//    public InstrumentType instrumentType;

    @ManyToMany(mappedBy = "instruments")
    public Collection<Artist> artists;

    @OneToMany(mappedBy = "favoriteInstrument")
    public Collection<Artist> favoriteInstruments;
    

}
