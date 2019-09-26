package com.mindheld.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the LOG_APPLICATION database table.
 * 
 */
@Entity
@Table(name = "LOG_APPLICATION")
@NamedQuery(name = "LogApplication.findAll", query = "SELECT l FROM LogApplication l")
public class LogApplication implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
//	@SequenceGenerator(name = "LOG_APPLICATION_LOGID_GENERATOR", sequenceName = "LOG_SEQ", allocationSize=1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOG_APPLICATION_LOGID_GENERATOR")
	@GeneratedValue
	@Column(name = "LOG_ID")
	private long logId;

	@Column(name = "\"ACTION\"", length = 100)
	private String action;

	@Column(name = "LOG_DATE")
	private Timestamp logDate;

	@Column(name = "USER_NAME", length = 20)
	private String userName;

	public LogApplication() {
	}

	public long getLogId() {
		return this.logId;
	}

	public void setLogId(long logId) {
		this.logId = logId;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Timestamp getLogDate() {
		return logDate;
	}

	public void setLogDate(Timestamp logDate) {
		this.logDate = logDate;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}