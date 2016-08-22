package com.twitterapp.DAO;

import java.util.List;

import com.twitterapp.model.ResultData;

public interface TwitterDAO {

	void saveTweetData(ResultData resultData);

	List<ResultData> getTweetData(String query);

}