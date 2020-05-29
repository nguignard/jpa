package model;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "Managers")
public class Manager extends Person {


//    @OneToMany(mappedBy = "manager")
//    public Collection<Artist> artists;
    


}
