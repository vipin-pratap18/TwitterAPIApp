package com.twitterapp.service;

import java.util.List;

import com.twitterapp.DAO.TwitterAppDAO;
import com.twitterapp.DAO.TwitterDAO;
import com.twitterapp.model.ResultData;



public class TwitterAppService implements TwitterService {
	
	private TwitterDAO twitterDAO;

	public TwitterAppService(){
		twitterDAO = new TwitterAppDAO();
	}
	
	
	@Override
	public void saveTweetData(List<ResultData> resultDataList){
		for(ResultData data : resultDataList){
			twitterDAO.saveTweetData(data);
		}
	}
	
	
	
	@Override
	public List<ResultData> getTweetData(String query){
		return twitterDAO.getTweetData(query);
	}

}
