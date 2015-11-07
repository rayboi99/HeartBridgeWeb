package com.se452.servlet;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.se452.model.AppUser;
import com.se452.model.FriendRequest;
import com.se452.model.Friendship;
import com.se452.model.FriendshipPK;

public class FriendshipServiceDao implements FriendshipServiceDaoInterface {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager ;
	
	public FriendshipServiceDao ()
	{
		 entityManagerFactory = Persistence.createEntityManagerFactory("SE452EclipseLink2");
		 entityManager = entityManagerFactory.createEntityManager();
		 entityManager.getTransaction().begin();
	}
	@Override
	public void addFriendship(int userId, int friendId, String acceptTime) {
		Friendship fs1=new Friendship();
		Friendship fs2=new Friendship();
		AppUser ap=entityManager.find(AppUser.class, userId);
		AppUser friend=entityManager.find(AppUser.class, friendId);
		fs1.setUser(ap);
		fs1.setFriend(friend);
		fs1.setFriendshipAddTime(acceptTime);
		fs2.setUser(friend);
		fs2.setFriend(ap);
		fs2.setFriendshipAddTime(acceptTime);
		entityManager.persist(fs1);
		entityManager.persist(fs2);

		
	}

	
	@Override
	public void setEntityManager(EntityManager em) {
		entityManager=em;
		
	}


	@Override
	public List<Friendship> getFriendShipList(int userId) {
		List<Friendship> result=entityManager.createQuery("select fs from Friendship fs where fs.user.appUserId=:uid")
		          .setParameter("uid", userId).getResultList();
		return result;
	}


	@Override
	public void cancelFriendship(int userId, int friendId) {
	
		FriendshipPK fspk=new FriendshipPK();
		fspk.setUserId(userId);
		fspk.setFriendId(friendId);
		Friendship fs=entityManager.find(Friendship.class, fspk);
		entityManager.remove(fs);
		FriendshipPK fspk2=new FriendshipPK();
		fspk2.setUserId(friendId);
		fspk2.setFriendId(userId);
		Friendship fs2=entityManager.find(Friendship.class, fspk2);
		entityManager.remove(fs2);
		
		
	}
	public void finalCommit()
	{
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
	}
}
