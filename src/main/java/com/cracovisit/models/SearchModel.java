package com.cracovisit.models;

public class SearchModel {
	
	String searchTerm;

	public SearchModel(String searchTerm) {
		super();
		this.searchTerm = searchTerm;
	}

	public SearchModel() {
		super();
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	
	

}
