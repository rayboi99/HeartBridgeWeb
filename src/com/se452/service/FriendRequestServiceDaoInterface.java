package com.se452.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.se452.model.FriendRequest;
import com.se452.model.FriendRequestPK;
import com.se452.model.Status;

public interface FriendRequestServiceDaoInterface {
	void sendFriendRequest(int userId, int friendId);
	void setEntityManager(EntityManager em);
	void changeFriendReqestStatus(String pkHashcode,Status s);
	List<FriendRequest> viewFriendRequest(int userId);
	//void cancelFriendRequest(String userName, String friendName,String timeSent);
	void finalCommit();
	List<FriendRequest> viewFriendSentRequest(int userId);
}
