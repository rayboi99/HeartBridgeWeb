package com.se452.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.se452.model.*;

public class FriendshipService implements FriendshipServiceInterface{

	

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager ;
	
	public FriendshipService (){
			entityManagerFactory = Persistence.createEntityManagerFactory("SE452EclipseLink2");
			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
}
 
	@Override
	public void addFriendship(int userId, int friendId, String acceptTime) {
		Friendship fs=new Friendship();
		AppUser ap=entityManager.find(AppUser.class, userId);
		AppUser friend=entityManager.find(AppUser.class, friendId);
		fs.setUser(ap);
		fs.setFriend(friend);
		fs.setFriendshipAddTime(acceptTime);
		entityManager.persist(fs);
		entityManager.flush();
	}

	@Override
	public void cancelFriendship(String userName, String friendName) {
		

		Query qy = entityManager.createQuery("select fs from Friendship fs where fs.user.app_user_name=:userName"
				+ " and fs.friend.app_user_name=:friendName");
		qy.setParameter("userName", userName);
		qy.setParameter("friendName", friendName);
		Friendship fs1=(Friendship) qy.getResultList().get(0);
		Query qy2 = entityManager.createQuery("select fs from Friendship fs where fs.user.app_user_name=:userName"
				+ " and fs.friend.app_user_name=:friendName");
		qy2.setParameter("userName", friendName);
		qy2.setParameter("friendName", userName);
		Friendship fs2=(Friendship) qy2.getResultList().get(0);
		entityManager.remove(fs1);
		entityManager.remove(fs2);
		
		
		
		
		
	}

	@Override
	public void commitTransaction() {
		
		entityManager.getTransaction().commit();
	    entityManager.close();
	    entityManagerFactory.close();
	}
	

}
