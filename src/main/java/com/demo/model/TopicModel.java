package com.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name="TOPIC")
public class TopicModel {

	@Id
	@Column(name="tid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tId;
	
	private String topic;
	
	@Column(updatable=false)
	private String createDate;

	public int getTid() {
		return tId;
	}

	public void setTid(int tId) {
		this.tId = tId;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	

    
	@Override
	public String toString(){
		return "tid="+tId+", topic="+topic+", createDate="+createDate;
	}
}