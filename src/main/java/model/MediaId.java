package model;

import java.io.Serializable;

import javax.persistence.Embeddable;

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
