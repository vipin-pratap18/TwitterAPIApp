package com.twitterapp.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import com.twitterapp.main.TwitterObjectFactory;
import com.twitterapp.model.ResultData;
import com.twitterapp.service.TwitterService;

import twitter4j.HashtagEntity;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class TwitterTask extends TimerTask{
	
	private String queryString;
	private TwitterService twitterService;
	
	public TwitterTask(String queryString, TwitterService twitterService){
		this.queryString = queryString;
		this.twitterService = twitterService;
	}
	
	@Override
	public void run() {
		System.out.println("Twitter task started at: " + new Date());
        startTask();
        System.out.println("Timer task finished at: " + new Date());
	}
	
	
	private void startTask(){
		Twitter twitter = TwitterObjectFactory.getInstance();
		List<ResultData> resultTweetData = new ArrayList<>();
		ResultData resultData = null;
		try {
            Query query = new Query(queryString);
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                	resultData = new ResultData();
                	resultData.setQuery(query.toString());
                	resultData.setTweetText(tweet.getText());
                	resultData.setTweet(tweet.toString());
                	resultData.setUserName(tweet.getUser().getScreenName());
                	resultData.setCreatedDate((tweet.getCreatedAt() != null) ? tweet.getCreatedAt().toString() : null);
                    HashtagEntity[] hte = tweet.getHashtagEntities();
                    for(HashtagEntity ht : hte){
                    	if(query.equals(ht.getText()))
                    	resultData.setHashTag(true);
                    }
                    
                    resultTweetData.add(resultData);
                    
                 System.out.println(resultData.getQuery());
           		 System.out.println(resultData.getCreatedDate());
           		 System.out.println(resultData.getTweet());
           		 System.out.println(resultData.getTweetText());
           		 System.out.println(resultData.getUserName());
           		 System.out.println(resultData.isHashTag());
                }
            } while ((query = result.nextQuery()) != null);
            
            twitterService.saveTweetData(resultTweetData);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
	}
	
	
}
