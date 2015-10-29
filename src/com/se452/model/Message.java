package com.se452.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.io.Serializable;
import java.util.*;

@Entity 
@IdClass(MessageId.class)
public class Message implements Serializable{

	@Id
	@Temporal(TemporalType.TIMESTAMP)
	private Date Date_Sent;
	@Id private AppUser User_Id_To;
	@Id private AppUser User_Id_From;
	private String Subject;
	private String Message;
	
	public AppUser getUser_Id_To() {
		return User_Id_To;
	}
	public void setUser_Id_To(AppUser user_Id_To) {
		User_Id_To = user_Id_To;
	}
	public AppUser getUser_Id_From() {
		return User_Id_From;
	}
	public void setUser_Id_From(AppUser user_Id_From) {
		User_Id_From = user_Id_From;
	}
	public Date getDate_Sent() {
		return Date_Sent;
	}
	public void setDate_Sent(Date date_Sent) {
		Date_Sent = date_Sent;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	
}
