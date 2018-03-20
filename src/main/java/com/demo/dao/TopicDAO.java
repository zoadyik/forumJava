package com.demo.dao;

import java.util.List;

import com.demo.model.TopicModel;

public interface TopicDAO {

	public void addTopic(TopicModel t);
	public void updateTopic(TopicModel t);
	public List<TopicModel> listTopics(Long page);
	public List<TopicModel> listTopics();
	public TopicModel getTopicById(int tId);
	public void removeTopic(int tId);
}