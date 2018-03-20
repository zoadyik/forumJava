package com.demo.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.CommentDAO;
import com.demo.model.CommentModel;

public class CommentServiceImpl implements CommentService {
	
	private CommentDAO commentDAO;
	
	public void setCommentDAO(CommentDAO commentDAO){
		this.commentDAO = commentDAO;
	}
	
	@Override
	@Transactional
	public void addComment(CommentModel c, int tId){
		c.setTid(tId);
		c.setCreateDate(getToday());
		this.commentDAO.addComment(c);
	}
	
	@Override
	@Transactional
	public void updateComment(CommentModel c, int tId){
		c.setTid(tId);
		this.commentDAO.updateComment(c);
	}
	
	@Override
	@Transactional
	public List<CommentModel> listComments(int tId){
		return this.commentDAO.listComments(tId);
	}
	
	@Override
	@Transactional
	public CommentModel getCommentById(int cId){
		return this.commentDAO.getCommentById(cId);
	}
	
	@Override
	@Transactional
	public void removeComment(int cId){
		this.commentDAO.removeComment(cId);
	}
	
	public String getToday(){
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime(); 
		String reportDate = df.format(today);
		return reportDate;
	}
	

}
