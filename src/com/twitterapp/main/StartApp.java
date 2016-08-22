package com.twitterapp.main;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.twitterapp.model.ResultData;
import com.twitterapp.service.TwitterAppService;
import com.twitterapp.service.TwitterService;
import com.twitterapp.task.TwitterTask;


public class StartApp {

	public static void main(String[] args){

		TwitterService twitterService = new TwitterAppService();
		String query = "TSC16";
		TimerTask twitterTask = new TwitterTask(query, twitterService);
		twitterTask.run();
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(twitterTask, 0, 60*60*1000);

		
		//Retrieving the data from database
		/*List<ResultData> resultList = twitterService.getTweetData(query);
		for(ResultData result : resultList){
			System.out.println(result.getQuery());
			System.out.println(result.getCreatedDate());
			System.out.println(result.getTweet());
			System.out.println(result.getTweetText());
			System.out.println(result.getUserName());
			System.out.println(result.isHashTag());
		}*/
	}

}
