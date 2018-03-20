package com.demo.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="COMMENT")
public class CommentModel {
	
	@Id
	@Column(name="cid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cId;
	
	private String comment;
	
	@Column(updatable=false)
	private String createDate;
	
	@ManyToOne
	@JoinColumn(name="tid", insertable=false, updatable=false)
	private TopicModel topic;
	
	private int tId;
	
	public int getCid() {
		return cId;
	}

	public void setCid(int cId) {
		this.cId = cId;
	}
	
	public int getTid() {
		return tId;
	}

	public void setTid(int tId) {
		this.tId = tId;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	@Override
	public String toString(){
		return "cid="+cId+", comment="+comment+", createDate="+createDate+", tid="+tId;
	}
	
	

}
