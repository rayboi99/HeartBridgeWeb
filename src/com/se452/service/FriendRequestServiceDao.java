package com.se452.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.se452.model.AppUser;
import com.se452.model.FriendRequest;
import com.se452.model.FriendRequestPK;
import com.se452.model.Status;

public class FriendRequestServiceDao implements FriendRequestServiceDaoInterface{


	private EntityManager entityManager ;
	@Override
	public void sendFriendRequest(int userId, int friendId) {
		AppUser user=entityManager.find(AppUser.class, userId);
		AppUser friend=entityManager.find(AppUser.class, friendId);
		FriendRequest fr=new FriendRequest();
		fr.setAu(user);
		fr.setFriend(friend);
		long time = System.currentTimeMillis();
		Timestamp ts=new Timestamp(time);
		String S = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(ts);
		fr.setRequestSendTime(S);
		fr.setRequestStatus(Status.PENDING.toString());
		fr.setRequestUpdateTime(S);
		entityManager.persist(fr);
		entityManager.getTransaction().commit();
		entityManager.getTransaction().begin();
	}
	@Override
	public void setEntityManager(EntityManager em) {
		this.entityManager=em;
		
	}
	@Override
	public List<FriendRequest> viewFriendRequest(int userId) {
		List<FriendRequest> result=entityManager.createQuery("select fr from FriendRequest fr where fr.friend.appUserId=:uid")
		          .setParameter("uid", userId).getResultList();
		return result;
		
	}
	@Override
	public void changeFriendReqestStatus(String pk, Status s) {
		
		List<FriendRequest> result=entityManager.createQuery("select fr from FriendRequest fr ").getResultList();
		int i=0;
		FriendshipServiceDao fs=new FriendshipServiceDao();
		boolean found=false;
		int pkHashCode=Integer.parseInt(pk);
		while(i<result.size()&&!found)
		{
			if(result.get(i).getFriendRequestPK().hashCode()!=pkHashCode){
				i++;
			}
			else if(result.get(i).getFriendRequestPK().hashCode()==pkHashCode)
					{
				found=true;
					}
		}
		FriendRequest fr=null;
		if(found==true)
		{
			fr=result.get(i);
		}
		String oldStatus=fr.getRequestStatus();
		if( !oldStatus.equals("REJECT"))
		{
		if(!oldStatus.equals(s)){
			long time = System.currentTimeMillis();
			Timestamp ts=new Timestamp(time);
			String S = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(ts);
			fr.setRequestStatus(s.toString());
			fr.setRequestUpdateTime(S);
			if(s.toString().equals("ACCEPT")){
			fs.setEntityManager(entityManager);
				fs.addFriendship(fr.getFriendRequestPK().getAuId(),fr.getFriendRequestPK().getFriendId(),S);
			}	
		}
	
		entityManager.persist(fr);
		entityManager.getTransaction().commit();
		}
	}
	
	
}
