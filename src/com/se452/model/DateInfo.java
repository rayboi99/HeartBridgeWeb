package com.se452.model;

import java.util.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@IdClass(DateInfoId.class)
public class DateInfo {
	
	@Id
	private AppUser MatchMakerId;
	@Id
	private AppUser User1Id;
	@Id
	private AppUser User2Id;
	
	@Temporal (TemporalType.TIMESTAMP)
	private java.util.Date dateTime;
	private String location;
	private String description;
	private Status status;
	
	
	public AppUser getMatchMakerId() {
		return MatchMakerId;
	}
	public void setMatchMakerId(AppUser matchMakerId) {
		MatchMakerId = matchMakerId;
	}
	public AppUser getUser1Id() {
		return User1Id;
	}
	public void setUser1Id(AppUser user1Id) {
		User1Id = user1Id;
	}
	public AppUser getUser2Id() {
		return User2Id;
	}
	public void setUser2Id(AppUser user2Id) {
		User2Id = user2Id;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	
	@Override
	public String toString() {
		return "DateInfo [MatchMakerId=" + MatchMakerId + ", User1Id=" + User1Id + ", User2Id=" + User2Id
				+ ", dateTime=" + dateTime + ", location=" + location + ", description=" + description + ", status="
				+ status + "]";
	}
}
