package com.mindheld.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;


/**
 * The persistent class for the NEWS database table.
 * 
 */
@Entity
@Table(name="NEWS")
@NamedQuery(name="New.findAll", query="SELECT n FROM New n")
public class New implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
//	@SequenceGenerator(name = "NEWS_GENERATOR", sequenceName = "NEWS_SEQ", allocationSize=1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NEWS_GENERATOR")
	@GeneratedValue
	@Column(name="NEWS_ID")
	private long newsId;

	@Column(name="COLOR")
	private String color;

	@Column(name="NEW_BODY")
	private String newBody;

	@Column(name="NEW_TITLE")
	private String newTitle;
	

	@Column(name = "NEW_DATE")
	private Timestamp newDate;

	public New() {
	}

	public long getNewsId() {
		return this.newsId;
	}

	public void setNewsId(long newsId) {
		this.newsId = newsId;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNewBody() {
		return this.newBody;
	}

	public void setNewBody(String newBody) {
		this.newBody = newBody;
	}

	public String getNewTitle() {
		return this.newTitle;
	}

	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}

	public Timestamp getNewDate() {
		return newDate;
	}

	public void setNewDate(Timestamp newDate) {
		this.newDate = newDate;
	}
	

}