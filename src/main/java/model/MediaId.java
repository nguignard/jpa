package model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Embeddable
public class MediaId implements Serializable {

    private static final long serialVersionUID = 1L;
    public String name;
    public MediaType mediaType;

    public MediaId() {
    }

    public MediaId(String name, MediaType mediaType) {
	this.name = name;
	this.mediaType = mediaType;
    }

}
