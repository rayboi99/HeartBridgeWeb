package com.se452.model;

import javax.persistence.Embeddable;

@Embeddable
public class FriendshipPK {

	private Integer userId;
	private Integer friendId;
	public FriendshipPK()
	{
		
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
       
        	FriendshipPK fspk = (FriendshipPK) obj;
 
            if(fspk.userId==(userId)&&
            		fspk.friendId==friendId
            		){
                return true;
            }
 
        
 
            else return false;
     
    }
 
    @Override
    public int hashCode() {
        return userId.hashCode()+friendId.hashCode();
    }
    

}
