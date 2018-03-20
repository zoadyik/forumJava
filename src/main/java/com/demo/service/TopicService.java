package com.demo.service;
import java.util.List;

import com.demo.model.TopicModel;


public interface  TopicService {
	public void addTopic(TopicModel t);
	public void updateTopic(TopicModel t);
	public List<TopicModel> listTopics(Long page);
	public TopicModel getTopicById(int tId);
	public void removeTopic(int tId);
	public List<TopicModel> listTopics();

}
