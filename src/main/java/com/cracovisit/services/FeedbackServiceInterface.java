package com.cracovisit.services;

import java.util.List;

import com.cracovisit.models.AttractionModel;
import com.cracovisit.models.FeedbackModel;

public interface FeedbackServiceInterface {

	public FeedbackModel getByID(long id);
	public List<FeedbackModel> getFeedbacks();
	public List<FeedbackModel> searchFeedbacks(Long long1);
	public long addFeedback(FeedbackModel e);
	public boolean deleteFeedback(long id);
	public FeedbackModel updateFeedback(FeedbackModel e, long id);
	
	public void init();
	public void destroy();
	
}
