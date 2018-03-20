package com.demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.demo.model.TopicModel;

@Repository
public class TopicDAOImpl implements TopicDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(TopicDAOImpl.class);

	private SessionFactory sessionFactory;
	
	private static final int limitResultsPerPage = (int) 20;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addTopic(TopicModel t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(t);
		logger.info("Topic saved successfully, Topic Details="+t);
	}
 
	@Override
	public void updateTopic(TopicModel t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(t);
		logger.info("Topic updated successfully, Topic Details="+t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TopicModel> listTopics(Long page) {
		int start = (int) ((page - 1) * limitResultsPerPage);
		Session session = this.sessionFactory.getCurrentSession();
//		List<TopicModel> topicsList = session.createQuery("from TopicModel ORDER BY createDate ASC").list();
		Query query = session.createQuery("from TopicModel ORDER BY createDate DESC");
		query.setFirstResult(start);
		query.setMaxResults(limitResultsPerPage);
		List<TopicModel> topicsList =query.list();
		for(TopicModel t : topicsList){
			logger.info("Topic List::"+t);
		}
		return topicsList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TopicModel> listTopics() {
		Session session = this.sessionFactory.getCurrentSession();
		List<TopicModel> topicsList = session.createQuery("from TopicModel ORDER BY createDate DESC").list();
		for(TopicModel t : topicsList){
			logger.info("Topic List::"+t);
		}
		return topicsList;
	}

	@Override
	public TopicModel getTopicById(int tId) {
		Session session = this.sessionFactory.getCurrentSession();		
		TopicModel t = (TopicModel) session.load(TopicModel.class, new Integer(tId));
		logger.info("Topic loaded successfully, Topic details="+t);
		return t;
	}

	@Override
	public void removeTopic(int tId) {
		Session session = this.sessionFactory.getCurrentSession();
		TopicModel t = (TopicModel) session.load(TopicModel.class, new Integer(tId));
		if(null != t){
			session.delete(t);
		}
		logger.info("Topic deleted successfully, Topic details="+t);
	}
}