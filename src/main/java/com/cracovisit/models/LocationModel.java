package com.cracovisit.models;

public class LocationModel {
	
	private Long locationID;
	private float cordX;
	private float cordY;
	private String address;
	
	public LocationModel(Long locationID, float cordX, float cordY, String address) {
		super();
		this.locationID = locationID;
		this.cordX = cordX;
		this.cordY = cordY;
		this.setAddress(address);
	}

	public LocationModel() {
		super();
	}

	public Long getlocationID() {
		return locationID;
	}

	public void setlocationID(Long locationID) {
		this.locationID = locationID;
	}

	public float getCordX() {
		return cordX;
	}

	public void setCordX(float cordX) {
		this.cordX = cordX;
	}

	public float getCordY() {
		return cordY;
	}

	public void setCordY(float cordY) {
		this.cordY = cordY;
	}

	@Override
	public String toString() {
		return "LocationModel [locationID=" + locationID + ", cordX=" + cordX + ", cordY=" + cordY + "]";
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	

}
