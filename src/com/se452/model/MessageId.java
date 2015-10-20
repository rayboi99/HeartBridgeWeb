package com.se452.model;

import java.io.Serializable;
import java.util.Date;

public class MessageId implements Serializable{

	private static final long serialVersionUID = 1L;
	private Date Date_Sent;
	private Integer User_Id_To;
	private Integer User_Id_From;
	
	public MessageId() {
		
	}
	
	public Date getDate_Sent() {
		return Date_Sent;
	}
	public void setDate_Sent(Date date_Sent) {
		Date_Sent = date_Sent;
	}
	public Integer getUser_Id_To() {
		return User_Id_To;
	}
	public void setUser_Id_To(Integer user_Id_To) {
		User_Id_To = user_Id_To;
	}
	public Integer getUser_Id_From() {
		return User_Id_From;
	}
	public void setUser_Id_From(Integer user_Id_From) {
		User_Id_From = user_Id_From;
	}

	public int hashCode()
	{
		return User_Id_To.hashCode() + User_Id_From.hashCode() + Date_Sent.hashCode();
	}
	
	public boolean equals(Object obj)
	{
		if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        MessageId temp = (MessageId) obj;
        
        if ((temp.User_Id_To == User_Id_To)
        		&& (temp.User_Id_From == User_Id_From)
        		&& (temp.Date_Sent == Date_Sent))
        	return true;
        else
        	return false;
        
	}
}