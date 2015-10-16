package com.se452.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity 
public class DateInfor {
	
	@Id 
	private AppUser MatchMakerId;
	@Id
	@JoinColumn (name = "user1_Id")
	private AppUser User1Id;
	@Id
	@JoinColumn (name = "user2_Id")
	private AppUser User2Id;

	private String location;
	
	@Id
	private String requestSendTime;
	private String description;
	private Status status;
	
	
	public AppUser getMatchMaker_Id() {
		return MatchMakerId;
	}
	public void setMatchMaker_Id(AppUser matchMaker_Id) {
		MatchMakerId = matchMaker_Id;
	}
	public AppUser getUser1_Id() {
		return User1Id;
	}
	public void setUser1_Id(AppUser user1_Id) {
		User1Id = user1_Id;
	}
	public AppUser getUser2_Id() {
		return User2Id;
	}
	public void setUser2_Id(AppUser user2_Id) {
		User2Id = user2_Id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public AppUser getMatchMakerId() {
		return MatchMakerId;
	}
	public void setMatchMakerId(AppUser matchMakerId) {
		MatchMakerId = matchMakerId;
	}
	public String getRequestSendTime() {
		return requestSendTime;
	}
	public void setRequestSendTime(String requestSendTime) {
		this.requestSendTime = requestSendTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
