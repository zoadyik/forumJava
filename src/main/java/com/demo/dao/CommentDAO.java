package com.demo.dao;

import java.util.List;

import com.demo.model.CommentModel;

public interface CommentDAO {
	public void addComment(CommentModel c);

	public void updateComment(CommentModel p);

	// public List<CommentModel> listComments();
	public CommentModel getCommentById(int cId);

	public void removeComment(int cId);

	public List<CommentModel> listComments(int tId);
}
