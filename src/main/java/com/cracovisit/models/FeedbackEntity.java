package com.cracovisit.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Table("feedback")
public class FeedbackEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column("feedbackID")
	private Long feedbackID;
	
	@Column("userID")
	private Long userID;
	
	@Column("attractionID")
	private Long attractionID;
	
	@Column("rating")
	private int rating;
	
	@Column("comment")
	private String comment;
	
	public FeedbackEntity(Long feedbackID, Long userID, Long attractionID, int rating, String comment) {
		super();
		this.feedbackID = feedbackID;
		this.userID = userID;
		this.attractionID = attractionID;
		this.rating = rating;
		this.comment = comment;
	}

	public FeedbackEntity() {
		super();
	}

	public Long getFeedbackID() {
		return feedbackID;
	}

	public void setFeedbackID(Long feedbackID) {
		this.feedbackID = feedbackID;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public Long getAttractionID() {
		return attractionID;
	}

	public void setAttractionID(Long attractionID) {
		this.attractionID = attractionID;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "FeedbackModel [feedbackID=" + feedbackID + ", userID=" + userID + ", attractionID=" + attractionID
				+ ", rating=" + rating + ", comment=" + comment + "]";
	}
	

}
