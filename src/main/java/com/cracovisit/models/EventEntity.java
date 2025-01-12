package com.cracovisit.models;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Table("event")
public class EventEntity {
	
	@Id
	@Column("eventID")
	private Long eventID;
	
	@Column("date")
	private Date date;
	
	@Column("organizer")
	private String organizer;
	
	@Column("ticketsAvailable")
	private int ticketsAvailable;
	
	
	public EventEntity() {
		super();
	}
	
	public EventEntity(Long eventID, Date date, String organizer, int ticketsAvailable) {
		super();
		this.eventID = eventID;
		this.date = date;
		this.organizer = organizer;
		this.ticketsAvailable = ticketsAvailable;
	}
	
	public Long getEventID() {
		return eventID;
	}
	public void setEventID(Long eventID) {
		this.eventID = eventID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getOrganizer() {
		return organizer;
	}
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	public int getTicketsAvailable() {
		return ticketsAvailable;
	}
	public void setTicketsAvailable(int ticketsAvailable) {
		this.ticketsAvailable = ticketsAvailable;
	}

	@Override
	public String toString() {
		return "EventModel [eventID=" + eventID + ", date=" + date + ", organizer=" + organizer + ", ticketsAvailable="
				+ ticketsAvailable + "]";
	}
	
}
