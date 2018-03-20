package com.demo.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.TopicModel;
import com.demo.dao.TopicDAO;

import com.demo.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {
	
	private TopicDAO topicDAO;

	
	public void setTopicDAO(TopicDAO topicDAO)
	{
			this.topicDAO = topicDAO;
	}
	
	@Override
	@Transactional
	public void addTopic(TopicModel t)
	{
		t.setCreateDate(getToday());
		this.topicDAO.addTopic(t);
	}
	
	@Override
	@Transactional
	public void updateTopic(TopicModel t)
	{
		this.topicDAO.updateTopic(t);
	}
	
	@Override
	@Transactional
	public List<TopicModel> listTopics(Long page) {
		return this.topicDAO.listTopics(page);
	}
	
	@Override
	@Transactional
	public List<TopicModel> listTopics() {
		return this.topicDAO.listTopics();
	}
	
	@Override
	@Transactional
	public TopicModel getTopicById(int tId) {
		return this.topicDAO.getTopicById(tId);
	}
	
	@Override
	@Transactional
	public void removeTopic(int tId) {
		this.topicDAO.removeTopic(tId);
	}
	
	public String getToday(){
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime(); 
		String reportDate = df.format(today);
		return reportDate;
	}
}
