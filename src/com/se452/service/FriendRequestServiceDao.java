package com.se452.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.se452.model.AppUser;
import com.se452.model.FriendRequest;
import com.se452.model.FriendRequestPK;
import com.se452.model.Status;

public class FriendRequestServiceDao implements FriendRequestServiceDaoInterface{


	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager ;
	
	public FriendRequestServiceDao ()
	{
		 entityManagerFactory = Persistence.createEntityManagerFactory("SE452EclipseLink2");
		 entityManager = entityManagerFactory.createEntityManager();
		 entityManager.getTransaction().begin();
	}
	@Override
	public void sendFriendRequest(int userId, int friendId) {
		
		AppUser user=entityManager.find(AppUser.class, userId);
		AppUser friend=entityManager.find(AppUser.class, friendId);
		FriendRequest frr=new FriendRequest();
		frr.setAu(user);
		frr.setFriend(friend);
		long time = System.currentTimeMillis();
		Timestamp ts=new Timestamp(time);
		String S = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(ts);
		frr.setRequestSendTime(S);
		frr.setRequestStatus(Status.PENDING.toString());
		frr.setRequestUpdateTime(S);
		entityManager.persist(frr);
		
		
		       
		
	}
	@Override
	public void setEntityManager(EntityManager em) {
		this.entityManager=em;
		
	}
	@Override
	public List<FriendRequest> viewFriendReceivedRequest(int userId) {
		List<FriendRequest> result=entityManager.createQuery("select fr from FriendRequest fr where fr.friend.userId=:uid")
		          .setParameter("uid", userId).getResultList();
		return result;
		
	}
	@Override
	public List<FriendRequest> viewFriendSentRequest(int userId) {
		List<FriendRequest> result=entityManager.createQuery("select fr from FriendRequest fr where fr.au.userId=:uid")
		          .setParameter("uid", userId).getResultList();
		return result;
		
	}
	@Override
	public void changeFriendReqestStatus(int uid, int fid,  Status s) {
		
		Query q=entityManager.createQuery("select fr from FriendRequest fr where fr.au.userId=:uid"
				+ " and fr.friend.userId=:fid");
		         q.setParameter("uid", uid);
		         q.setParameter("fid", fid);
		        FriendRequest fr= (FriendRequest) q.getResultList().get(0);
		
		FriendshipServiceDao fs=new FriendshipServiceDao();
		String S="";
		String oldStatus=fr.getRequestStatus();
		if(s.equals("REJECT"))
		{
			fr.setRequestStatus(s.toString());
			long time = System.currentTimeMillis();
			Timestamp ts=new Timestamp(time);
			S = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(ts);
			fr.setRequestStatus(s.toString());
			fr.setRequestUpdateTime(S);
		}
		else if(s.equals("ACCEPT"))
		{
			fr.setRequestStatus(s.toString());
			long time = System.currentTimeMillis();
			Timestamp ts=new Timestamp(time);
			S = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(ts);
			fr.setRequestStatus(s.toString());
			fr.setRequestUpdateTime(S);
			
		}
			
		fs.addFriendship(uid, fid, S);
		
		fs.addFriendship(fid, uid, S);
		entityManager.persist(fr);
	
		}
	
	public void finalCommit()
	{
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
	}

}
