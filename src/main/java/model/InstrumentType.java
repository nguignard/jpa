package model;

public enum InstrumentType {
    STRING("STRING"), WIND("WIND"), PERCUSSION("PERCUSSION");

    // @OneToOne(mappedBy = "instrument")
    String type;

    InstrumentType(String type) {
	this.type = type;
    }

    public String getType() {
	return type;
    }


}
