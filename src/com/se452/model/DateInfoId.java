package com.se452.model;


public class DateInfoId {
	
	private int MatchMakerId;
	private int User1Id;
	private int User2Id;
	
	public void setMatchMakerId(int matchMakerId) {
		MatchMakerId = matchMakerId;
	}
	public void setUser1Id(int user1Id) {
		User1Id = user1Id;
	}
	public void setUser2Id(int user2Id) {
		User2Id = user2Id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + MatchMakerId;
		result = prime * result + User1Id;
		result = prime * result + User2Id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DateInfoId other = (DateInfoId) obj;
		if (MatchMakerId != other.MatchMakerId)
			return false;
		if (User1Id != other.User1Id)
			return false;
		if (User2Id != other.User2Id)
			return false;
		return true;
	}
}
