package com.se452.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.se452.model.*;

public interface FriendRequestServiceInterface {
	void sendFriendRequest(String userName, String friendName);
	void changeFriendReqestStatus(String userName, String friendName,String timeSent,Status s);
	List<FriendRequest> viewFriendRequest(String userName);
	void cancelFriendRequest(String userName, String friendName,String timeSent);
	void commitTransaction();
	


}
