package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Media implements Serializable {

    @EmbeddedId
    private MediaId mediaId;

    private Date releaseDate;

    @ManyToOne()
    private Artist artist;

    public Media() {
    }

    public Media(MediaId mediaId) {
	this.mediaId = mediaId;
	this.releaseDate = new Date(Calendar.getInstance().getTimeInMillis());
    }

    public Date getReleaseDate() {
	return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
	this.releaseDate = releaseDate;
    }
}
