package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Media implements Serializable {

    @EmbeddedId
    public MediaId mediaId;

    public Date releaseDate;

    @ManyToOne()
    public Artist artist;

    public Media() {
    }

    public Media(MediaId mediaId) {
	this.mediaId = mediaId;
    }
}
