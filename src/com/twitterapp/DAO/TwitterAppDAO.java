package com.twitterapp.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.twitterapp.model.ResultData;

public class TwitterAppDAO implements TwitterDAO {
	
	//Used to hold the tweet data in the memory instead of data base
	private Map<String, List<ResultData>> hashTagData = new HashMap<>();
	private Map<String, List<ResultData>> textData = new HashMap<>();
	
	
	@Override
	public void saveTweetData(ResultData resultData){
		//Should be query to database to save the data
		if(resultData.isHashTag()){
			if(hashTagData.containsKey(resultData.getQuery())){
				List<ResultData> datalist = hashTagData.get(resultData.getQuery());
				datalist.add(resultData);
			}else{
				List<ResultData> datalist = new ArrayList<>();
				datalist.add(resultData);
				hashTagData.put(resultData.getQuery(), datalist);
			}
		}else{
			if(textData.containsKey(resultData.getQuery())){
				List<ResultData> datalist = textData.get(resultData.getQuery());
				datalist.add(resultData);
			}else{
				List<ResultData> datalist = new ArrayList<>();
				datalist.add(resultData);
				textData.put(resultData.getQuery(), datalist);
			}
		}
		
	}
	
	
	
	@Override
	public List<ResultData> getTweetData(String query){
		//Should be query to database to get the data
		List<ResultData> resultData = null;
		if(hashTagData.get(query) != null){
			resultData = hashTagData.get(query);
		}else{
			resultData = textData.get(query);
		}
			
		return resultData;
	}

}
