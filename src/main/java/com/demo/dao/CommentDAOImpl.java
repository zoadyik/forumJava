package com.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.demo.model.CommentModel;

public class CommentDAOImpl implements CommentDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(CommentDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addComment(CommentModel c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
		logger.info("Comment saved successfully, Comment Details="+c);
	}

	@Override
	public void updateComment(CommentModel p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Comment updated successfully, Comment Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CommentModel> listComments(int tId) {
		Session session = this.sessionFactory.getCurrentSession();
		List<CommentModel> commentsList = session.createQuery("select c from CommentModel c INNER JOIN c.topic WHERE c.tId ="+String.valueOf(tId)).list();
		for(CommentModel c : commentsList){
			logger.info("Comment List::"+c);
		}
		return commentsList;
	}

	@Override
	public CommentModel getCommentById(int cId) {
		Session session = this.sessionFactory.getCurrentSession();		
		CommentModel c = (CommentModel) session.load(CommentModel.class, new Integer(cId));
		logger.info("Comment loaded successfully, Comment details="+c);
		return c;
	}

	@Override
	public void removeComment(int cId) {
		Session session = this.sessionFactory.getCurrentSession();
		CommentModel c = (CommentModel) session.load(CommentModel.class, new Integer(cId));
		if(null != c){
			session.delete(c);
		}
		logger.info("Comment deleted successfully, Comment details="+c);
	}
}
