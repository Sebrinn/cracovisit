package com.cracovisit.models;

public class FeedbackModel {
	
	private Long feedbackID;
	private Long userID;
	private Long attractionID;
	private int rating;
	private String comment;
	
	private String author;
	
	public FeedbackModel(Long feedbackID, Long userID, Long attractionID, int rating, String comment) {
		super();
		this.feedbackID = feedbackID;
		this.userID = userID;
		this.attractionID = attractionID;
		this.rating = rating;
		this.comment = comment;
		this.setAuthor("Anonim");
	}

	public FeedbackModel() {
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
	

}
