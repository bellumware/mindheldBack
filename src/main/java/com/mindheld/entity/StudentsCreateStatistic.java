package com.mindheld.entity;

import javax.persistence.*;

@Entity
@Table(name="students_create_statistic")
public class StudentsCreateStatistic {
	
	@Id
	private String month;
	
	private String quantity;

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	

}
