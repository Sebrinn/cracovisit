package com.cracovisit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cracovisit.data.DataAccessInterface;
import com.cracovisit.models.AttractionModel;
import com.cracovisit.models.FeedbackModel;

public class FeedbackService implements FeedbackServiceInterface{

	@Autowired
	private DataAccessInterface<FeedbackModel, Long> feedbackDao;
	
	
	@Override
	public List<FeedbackModel> getFeedbacks() {
		
		return feedbackDao.getAll();
	}

	@Override
	public void init() {
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FeedbackModel getByID(long id) {
		return feedbackDao.getByID(id);
	}

	@Override
	public List<FeedbackModel> searchFeedbacks(Long searchTerm) {
		
		return feedbackDao.search(searchTerm);
	}

	@Override
	public long addFeedback(FeedbackModel e) {
		return feedbackDao.addNew(e);
		
	}

	@Override
	public boolean deleteFeedback(long id) {
		return feedbackDao.deleteByID(id);
	}

	@Override
	public FeedbackModel updateFeedback(FeedbackModel e, long id) {
		
		return feedbackDao.updateByID(e, id);
	}

}
