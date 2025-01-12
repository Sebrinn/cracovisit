package com.cracovisit.models;

public class AttractionModel {
	
	Long attractionID = 0L;
	String attractionName = "";
	String attractionDescription = "";
	float attractionEntryFee = 0;
	int attractionLocation = 0;
	String attractionType = "";
	String attractionImagePath = "";
	
	public AttractionModel(Long attractionID, String attractionName, String attractionDescription,
			float attractionEntryFee, int attractionLocation, String attractionType, String attractionImagePath) {
		super();
		this.attractionID = attractionID;
		this.attractionName = attractionName;
		this.attractionDescription = attractionDescription;
		this.attractionEntryFee = attractionEntryFee;
		this.attractionLocation = attractionLocation;
		this.attractionType = attractionType;
		this.attractionImagePath = attractionImagePath;
	}

	public AttractionModel() {
		super();
	}

	public Long getAttractionID() {
		return attractionID;
	}

	public void setAttractionID(Long attractionID) {
		this.attractionID = attractionID;
	}

	public String getAttractionName() {
		return attractionName;
	}

	public void setAttractionName(String attractionName) {
		this.attractionName = attractionName;
	}

	public String getAttractionDescription() {
		return attractionDescription;
	}

	public void setAttractionDescription(String attractionDescription) {
		this.attractionDescription = attractionDescription;
	}

	public float getAttractionEntryFee() {
		return attractionEntryFee;
	}

	public void setAttractionEntryFee(float attractionEntryFee) {
		this.attractionEntryFee = attractionEntryFee;
	}

	public int getAttractionLocation() {
		return attractionLocation;
	}

	public void setAttractionLocation(int attractionLocation) {
		this.attractionLocation = attractionLocation;
	}

	public String getAttractionType() {
		return attractionType;
	}

	public void setAttractionType(String attractionType) {
		this.attractionType = attractionType;
	}

	
	
	
	public String getAttractionImagePath() {
		return attractionImagePath;
	}

	public void setAttractionImagePath(String attractionImagePath) {
		this.attractionImagePath = attractionImagePath;
	}

	@Override
	public String toString() {
		return "AttractionModel [attractionID=" + attractionID + ", attractionName=" + attractionName
				+ ", attractionDescription=" + attractionDescription + ", attractionEntryFee=" + attractionEntryFee
				+ ", attractionLocation=" + attractionLocation + ", attractionType=" + attractionType + "]";
	}
	
	
	

	
	

}
