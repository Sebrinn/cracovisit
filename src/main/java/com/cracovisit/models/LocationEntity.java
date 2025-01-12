package com.cracovisit.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Table("location")
public class LocationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column("locationID")
	private Long locationID;
	
	@Column("cordX")
	private float cordX;
	
	@Column("cordY")
	private float cordY;
	
	@Column("address")
	private String address;
	
	public LocationEntity(Long locationID, float cordX, float cordY, String address) {
		super();
		this.locationID = locationID;
		this.cordX = cordX;
		this.cordY = cordY;
		this.address = address;
	}

	public LocationEntity() {
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
