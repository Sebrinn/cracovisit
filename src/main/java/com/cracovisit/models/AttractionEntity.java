package com.cracovisit.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Table("attractions")
public class AttractionEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column("attractionID")
	Long attractionID = 0L;
	
	@Column("attractionName")
	String attractionName = "";
	
	@Column("attractionDescription")
	String attractionDescription = "";
	
	@Column("attractionEntryFee")
	float attractionEntryFee = 0;
	
	@Column("attractionLocation")
	int attractionLocation = 0;
	
	@Column("attractionType")
	String attractionType = "";

	public AttractionEntity(String name, String category, float cordX, float cordY, Long attractionID,
			String attractionName, String attractionDescription, float attractionEntryFee, int attractionLocation,
			String attractionType) {
		super();
		this.attractionID = attractionID;
		this.attractionName = attractionName;
		this.attractionDescription = attractionDescription;
		this.attractionEntryFee = attractionEntryFee;
		this.attractionLocation = attractionLocation;
		this.attractionType = attractionType;
	}

	public AttractionEntity() {
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
	
	
	
	
	

	

	

}
