package com.se452.service;

import java.security.NoSuchAlgorithmException;
import com.se452.model.Gift;
import com.se452.model.UserGift;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.se452.model.AppUser;


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
	public void sendGift(int giftId, int userSend, int userReceived)
			throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		 UserGift usergift = new UserGift();
		 
		 
		 entityManager.persist(usergift);
		 entityManager.flush();
		
	}
	@Override
	public List<Gift> reviewGiftUserSend( int userSent_Id) {
		// TODO Auto-generated method stub
		List<Gift> giftList = null;

		AppUser userSent = new AppUser();
		userSent.setApp_user_id(userSent_Id);
		
		String q = "SELECT i FROM Gift i INNER JOIN UserGift j ON i.giftId = j.giftId WHERE j.userSent_Id = ?1";
		
		Query query = entityManager.createQuery(q); 
	    query.setParameter(1, userSent_Id);
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
		String q = "SELECT i FROM Gift i INNER JOIN i.giftId j WHERE j.userReceived = ?1";
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
	
	
	

}
