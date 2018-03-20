package com.demo.service;

import java.util.List;

import com.demo.model.CommentModel;

public interface CommentService {
	
	public void addComment(CommentModel c, int tId);
	public void updateComment(CommentModel c, int tId);
	public List<CommentModel> listComments(int tId);
	public CommentModel getCommentById(int cId);
	public void removeComment(int cId);
}
