package com.se452.model;

import java.io.Serializable;

public class MatchRequestId implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer MatchMaker_Id;
	private Integer User1_Id;
	private Integer User2_Id;
	
	public MatchRequestId () {	
	}
	
	public Integer getMatchMaker_Id() {
		return MatchMaker_Id;
	}
	public void setMatchMaker_Id(Integer matchMaker_Id) {
		MatchMaker_Id = matchMaker_Id;
	}
	
	public Integer getUser1_Id() {
		return User1_Id;
	}
	public void setUser1_Id(Integer user1_Id) {
		User1_Id = user1_Id;
	}
	
	public Integer getUser2_Id() {
		return User2_Id;
	}
	public void setUser2_Id(Integer user2_Id) {
		User2_Id = user2_Id;
	}
	
	@Override
	public int hashCode()
	{
		return MatchMaker_Id.hashCode() + User1_Id.hashCode() + User2_Id.hashCode();
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        MatchRequestId temp = (MatchRequestId) obj;
        
        if ((temp.MatchMaker_Id == MatchMaker_Id)
        		&& (temp.User1_Id == User1_Id)
        		&& (temp.User2_Id == User2_Id))
        	return true;
        else
        	return false;
        
	}
}