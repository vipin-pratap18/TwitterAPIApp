package com.twitterapp.main;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterObjectFactory {
	
	private static Twitter twitter;
	private static String consumerKey = "";
	private static String consumerSecret = "";
	private static String accessToken = "";
	private static String accessTokenSecret = "";

	private TwitterObjectFactory(){
		
	}
	
	public static Twitter getInstance(){
		if(twitter == null){
			synchronized (TwitterObjectFactory.class) {
				if(twitter == null){

					ConfigurationBuilder cb = new ConfigurationBuilder();
			        cb.setDebugEnabled(true)
			            .setOAuthConsumerKey(consumerKey)
			            .setOAuthConsumerSecret(consumerSecret)
			            .setOAuthAccessToken(accessToken)
			            .setOAuthAccessTokenSecret(accessTokenSecret);
			        TwitterFactory twitterFactory = new TwitterFactory(cb.build());
			        //Instantiate a new Twitter instance
			        twitter = twitterFactory.getInstance();
				}
			}
		}
		return twitter;
	}
}
