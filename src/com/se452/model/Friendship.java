package com.se452.model;

import java.util.Calendar;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.CascadeType;






@Entity
@Table(name="FRIENDSHIP")
public class Friendship {
	

	 @EmbeddedId
	private  FriendshipPK friendshipPK;
	
	
	@Column(name="Friendship_add_time",nullable=false,length=320)
	private String FrindshipAddTime ;
	
	@MapsId("userId")
	//@Id
	//@ManyToOne
    //@JoinColumn(name="USER_ID", nullable=false)
	private AppUser user;
	
	@MapsId("friendId")
	//@Id
	//@OneToOne
	//@JoinColumn(name="Friend_ID",nullable=false)
	private AppUser friend;
	
	
	public FriendshipPK getFriendshipPK() {
		return friendshipPK;
	}

	public void setFriendshipPK(FriendshipPK friendshipPK) {
		this.friendshipPK = friendshipPK;
	}

	public String getFrindshipAddTime() {
		return FrindshipAddTime;
	}

	public void setFrindshipAddTime(String frindshipAddTime) {
		FrindshipAddTime = frindshipAddTime;
	}

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
