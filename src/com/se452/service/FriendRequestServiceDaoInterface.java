package com.se452.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.se452.model.FriendRequest;
import com.se452.model.FriendRequestPK;
import com.se452.model.Status;

public interface FriendRequestServiceDaoInterface {
	void sendFriendRequest(int userId, int friendId);
	void setEntityManager(EntityManager em);
		List<FriendRequest> viewFriendReceivedRequest(int userId);
	void cancelFriendRequest(int  userId, int friendId);
	void finalCommit();
	List<FriendRequest> viewFriendSentRequest(int userId);
	void changeFriendReqestStatus(int uid, int fid, Status s);
}
