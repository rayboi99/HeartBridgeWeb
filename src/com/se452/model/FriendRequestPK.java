package com.se452.model;

import javax.persistence.Embeddable;

@Embeddable
public class FriendRequestPK {
	private Integer  auId;
	private Integer friendId;
//	private String requestSendTime;
	
	public FriendRequestPK()
	{
		
	}
	/* public String getRequestSendTime() {
		return requestSendTime;
	}

	public void setRequestSendTime(String requestSendTime) {
		this.requestSendTime = requestSendTime;
	}
*/
	public Integer getAuId() {
		return auId;
	}

	public void setAuId(Integer auId) {
		this.auId = auId;
	}

	public Integer getFriendId() {
		return friendId;
	}

	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
	}

	
	@Override
	    public boolean equals(Object obj) {
		if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
	       
	        	FriendRequestPK frpk = (FriendRequestPK) obj;
	 
	            if(frpk.auId==(auId)&&
	            		frpk.friendId==friendId
	            		){
	                return true;
	            }
	 
	        
	 
	            else return false;
	     
	    }
	 
	    @Override
	    public int hashCode() {
	        return auId.hashCode()+friendId.hashCode();
	    }
	    
	

	
}
