package com.se452.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;




@Entity
@Table(name="USERUNIVERSITY")
public class UserUniversity {

	public University getUniId() {
		return uniId;
	}
	public void setUniId(University uniId) {
		this.uniId = uniId;
	}
	public AppUser getUserId() {
		return userId;
	}
	public void setUserId(AppUser userId) {
		this.userId = userId;
	}
	@Id
	@JoinColumn(name="University_Id",nullable=false)
	private University uniId;
	@Id
	private AppUser userId;
	
}
