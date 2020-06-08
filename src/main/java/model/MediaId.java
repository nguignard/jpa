package model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class MediaId implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private MediaType mediaType;

    public MediaId() {
    }

    public MediaId(String name, MediaType mediaType) {
	this.name = name;
	this.mediaType = mediaType;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("MediaId [name=");
	builder.append(name);
	builder.append(", mediaType=");
	builder.append(mediaType);
	builder.append("]");
	return builder.toString();
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((mediaType == null) ? 0 : mediaType.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	MediaId other = (MediaId) obj;
	if (mediaType != other.mediaType)
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
    }

}
