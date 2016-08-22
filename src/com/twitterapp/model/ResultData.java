package com.twitterapp.model;

public class ResultData {

	private String tweetText;
	private boolean isHashTag;
	private String query;
	private String createdDate;
	private String userName;
	private String tweet;
	
	public String getTweetText() {
		return tweetText;
	}
	public void setTweetText(String tweetText) {
		this.tweetText = tweetText;
	}
	public boolean isHashTag() {
		return isHashTag;
	}
	public void setHashTag(boolean isHashTag) {
		this.isHashTag = isHashTag;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTweet() {
		return tweet;
	}
	public void setTweet(String tweet) {
		this.tweet = tweet;
	}
}
