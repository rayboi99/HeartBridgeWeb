package com.se452.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.CascadeType;

@Entity
public class Friendship {
	
	@Column(name="Friendship_add_time",nullable=false,length=320)
	private String FrindshipAddTime ;
	
	@Id
	//@ManyToOne
    //@JoinColumn(name="USER_ID", nullable=false)
	private AppUser user;
	
	@Id
	//@OneToOne
	//@JoinColumn(name="Friend_ID",nullable=false)
	private AppUser friend;
	
	
	public String getFriendshipAddTime() {
		return FrindshipAddTime;
	}

	public void setFriendshipAddTime(String FrindshipAddTime) {
		this.FrindshipAddTime = FrindshipAddTime;
	}

	
	


	public AppUser getUser() {
		return user;
	}
	public void setUser(AppUser user) {
		this.user = user;
	}
	public AppUser getFriend() {
		return friend;
	}
	public void setFriend(AppUser friend) {
		this.friend = friend;
	}
	

	
	

	
	
}
