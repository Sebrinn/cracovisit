package com.cracovisit.models;

import java.sql.Time;

public class MonumentModel {
	
	private Long monumentID;
	private String history;
	private Time openingTime;
	private String architecturalStyle;
	private String epoch;
	private Time closingTime;
	
	
	public MonumentModel(Long monumentID, String history, Time openingTime, String architecturalStyle, String epoch,
			Time closingTime) {
		super();
		this.monumentID = monumentID;
		this.history = history;
		this.openingTime = openingTime;
		this.architecturalStyle = architecturalStyle;
		this.epoch = epoch;
		this.closingTime = closingTime;
	}


	public MonumentModel() {
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
