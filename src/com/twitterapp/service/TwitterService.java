package com.twitterapp.service;

import java.util.List;

import com.twitterapp.model.ResultData;

public interface TwitterService {

	void saveTweetData(List<ResultData> resultDataList);

	List<ResultData> getTweetData(String query);

}