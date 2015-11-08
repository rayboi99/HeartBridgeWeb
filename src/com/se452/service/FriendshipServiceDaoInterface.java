package com.se452.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.se452.model.Friendship;

public interface FriendshipServiceDaoInterface {
	void addFriendship(int userId,int friendId,String acceptTime);
	void cancelFriendship(int userId, int friendId);
	List<Friendship> getFriendShipList(int userId);
	void setEntityManager(EntityManager em);
	boolean checkIfMutualFriend (int userId, int checkId);
	void finalCommit();
}
