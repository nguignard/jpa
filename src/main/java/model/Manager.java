package model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Manager")
public class Manager extends Person {

    public int budget;
    
    @OneToMany(mappedBy = "manager")
    public Collection<Artist> artists;


}
