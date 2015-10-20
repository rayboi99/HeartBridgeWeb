package com.se452.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity 
@IdClass(MatchRequestId.class)
public class MatchRequest {

	@Id private AppUser MatchMaker_Id;
	@Id private AppUser User1_Id;
	@Id private AppUser User2_Id;
	private Date Request_Time;
	private Date Request_Accept_Time;
	private String Request_Status;
	private String Request_Type;
	private String User1_Request_Status;	
	private String User2_Request_Status;	
	
	public AppUser getMatchMaker_Id() {
		return MatchMaker_Id;
	}
	public void setMatchMaker_Id(AppUser matchMaker_Id) {
		MatchMaker_Id = matchMaker_Id;
	}
	public AppUser getUser1_Id() {
		return User1_Id;
	}
	public void setUser1_Id(AppUser user1_Id) {
		User1_Id = user1_Id;
	}
	public AppUser getUser2_Id() {
		return User2_Id;
	}
	public void setUser2_Id(AppUser user2_Id) {
		User2_Id = user2_Id;
	}
	public Date getRequest_Time() {
		return Request_Time;
	}
	public void setRequest_Time(Date request_Time) {
		Request_Time = request_Time;
	}
	public Date getRequest_Accept_Time() {
		return Request_Accept_Time;
	}
	public void setRequest_Accept_Time(Date request_Accept_Time) {
		Request_Accept_Time = request_Accept_Time;
	}
	public String getRequest_Status() {
		return Request_Status;
	}
	public void setRequest_Status(String request_Status) {
		Request_Status = request_Status;
	}
	public String getRequest_Type() {
		return Request_Type;
	}
	public void setRequest_Type(String request_Type) {
		Request_Type = request_Type;
	}
	public String getUser1_Request_Status() {
		return User1_Request_Status;
	}
	public void setUser1_Request_Status(String user1_Request_Status) {
		User1_Request_Status = user1_Request_Status;
	}
	public String getUser2_Request_Status() {
		return User2_Request_Status;
	}
	public void setUser2_Request_Status(String user2_Request_Status) {
		User2_Request_Status = user2_Request_Status;
	}
}
