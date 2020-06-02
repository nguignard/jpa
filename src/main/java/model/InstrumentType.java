package model;

import javax.persistence.OneToOne;

public enum InstrumentType {
    STRING("STRING"), WIND("WIND"), PERCUSSION("PERCUSSION");

    @OneToOne(mappedBy = "instrumentType")
    String type;

    InstrumentType(String type) {
	this.type = type;
    }

    public String getType() {
	return type;
    }


}
