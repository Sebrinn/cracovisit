package com.cracovisit.models;

import java.sql.Time;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Table("monument")
public class MonumentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column("monumentID")
	private Long monumentID;
	
	@Column("history")
	private String history;
	
	@Column("openingTime")
	private Time openingTime;
	
	@Column("architecturalStyle")
	private String architecturalStyle;
	
	@Column("epoch")
	private String epoch;
	
	@Column("closingTime")
	private Time closingTime;
	
	
	public MonumentEntity(Long monumentID, String history, Time openingTime, String architecturalStyle, String epoch,
			Time closingTime) {
		super();
		this.monumentID = monumentID;
		this.history = history;
		this.openingTime = openingTime;
		this.architecturalStyle = architecturalStyle;
		this.epoch = epoch;
		this.closingTime = closingTime;
	}


	public MonumentEntity() {
		super();
	}


	public Long getMonumentID() {
		return monumentID;
	}


	public void setMonumentID(Long monumentID) {
		this.monumentID = monumentID;
	}


	public String getHistory() {
		return history;
	}


	public void setHistory(String history) {
		this.history = history;
	}


	public Time getOpeningTime() {
		return openingTime;
	}


	public void setOpeningTime(Time openingTime) {
		this.openingTime = openingTime;
	}


	public String getArchitecturalStyle() {
		return architecturalStyle;
	}


	public void setArchitecturalStyle(String architecturalStyle) {
		this.architecturalStyle = architecturalStyle;
	}


	public String getEpoch() {
		return epoch;
	}


	public void setEpoch(String epoch) {
		this.epoch = epoch;
	}


	public Time getClosingTime() {
		return closingTime;
	}


	public void setClosingTime(Time closingTime) {
		this.closingTime = closingTime;
	}


	@Override
	public String toString() {
		return "MonumentModel [monumentID=" + monumentID + ", history=" + history + ", openingTime=" + openingTime
				+ ", architecturalStyle=" + architecturalStyle + ", epoch=" + epoch + ", closingTime=" + closingTime
				+ "]";
	}

}
