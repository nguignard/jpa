package model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class MediaId implements Serializable {

    public MediaId() {
	super();
    }

    public String name;
    public Enum<MediaType> mediaType;

    public MediaId(String name, Enum<MediaType> mediaType) {
	this.name = name;
	this.mediaType = mediaType;
    }

}
