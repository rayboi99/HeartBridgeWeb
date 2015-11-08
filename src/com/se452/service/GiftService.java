package com.se452.service;

import java.security.NoSuchAlgorithmException;

import com.se452.model.AppUser;
import com.se452.model.Gift;
import com.se452.model.UserGift;
import com.se452.service.GiftServiceInterface;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;




public class GiftService implements GiftServiceInterface {
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public GiftService(){
		entityManagerFactory = Persistence.createEntityManagerFactory("SE452EclipseLink2");
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
	}
	@Override
	public void addGift( String giftName, String giftDescription, byte[] giftPicture) {
		// TODO Auto-generated method stub
		Gift gift = new Gift();
		gift.setGiftName(giftName);
		gift.setGiftDescription(giftDescription);
		gift.setGiftPicture(giftPicture);
		entityManager.persist(gift);
		entityManager.flush();
		entityManager.getTransaction().commit();

	}

	@Override
	public void sendGift(int gift_Id, int user_Send, int user_Received, Date modifiedTimestamp)
			throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		 UserGift usergift = new UserGift();
		 Gift giftId = entityManager.find(Gift.class, gift_Id);
		 AppUser userSend = entityManager.find(AppUser.class, user_Send);
		 AppUser userReceived = entityManager.find(AppUser.class, user_Received);
		 usergift.setGiftId(giftId);
		 usergift.setUserSend(userSend);
		 usergift.setUserReceived(userReceived);
		 usergift.setModifiedTimestamp(modifiedTimestamp);
		 entityManager.persist(usergift);
		 entityManager.flush();
		 entityManager.getTransaction().commit();

		
	}
	@Override
	public List<Gift> reviewGiftUserSend( int userSent_Id) {
		// TODO Auto-generated method stub
		List<Gift> giftList = null;

		AppUser userSentId = entityManager.find(AppUser.class, userSent_Id);
		
		String q = "SELECT i FROM Gift i INNER JOIN i.usergift ug WHERE ug.userSend = ?1";
		
		Query query = entityManager.createQuery(q); 
	    query.setParameter(1, userSentId);
	    giftList = query.getResultList();
	    return giftList;
		
	}

	@Override
	public  List<Gift> reviewGiftUserReveived( int userReceived_Id) {
		// TODO Auto-generated method stub
		List<Gift> giftList = null;

		AppUser userReceived = entityManager.find(AppUser.class, userReceived_Id);
		
		//String q = "SELECT g FROM Gift g";
		//String q = "SELECT NEW com.se452.UserGift.UserGiftInfo(i.giftId, i.giftName) FROM Gift AS i";
		//String q = "SELECT NEW com.se452.UserGift.UserGiftInfo(i.giftId, i.giftName, j.userSend) FROM Gift AS i INNER JOIN UserGift AS j ON i.giftId = j.giftId WHERE j.userReceived = ?1";
		//String q = "SELECT NEW com.se452.UserGift.UserGiftInfo(i.giftId, i.giftName, j.userSend) FROM Gift AS i, UserGift AS j ";
		//TypedQuery<UserGiftInfo> query = entityManager.createQuery(q, UserGiftInfo.class); 
	    //query.setParameter(1, userReceived);
		String q = "SELECT i FROM Gift i INNER JOIN i.usergift ug WHERE ug.userReceived = ?1";
		Query query = entityManager.createQuery(q); 
		query.setParameter(1, userReceived);
		giftList = query.getResultList();
	    return giftList;
		
	}

	@Override
	public void deleteGIftUserReceived(int giftId, int userReceived_Id) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void commitTransaction() {
		// TODO Auto-generated method stub
		entityManager.getTransaction().commit();
	    entityManager.close();
	    entityManagerFactory.close();
		
	}
	
	public void closeConnection(){
		entityManager.close();
	    entityManagerFactory.close();
	}
		
	
	

}
