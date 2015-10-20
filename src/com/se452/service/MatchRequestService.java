package com.se452.service;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.se452.model.*;

public class MatchRequestService {

	private EntityManagerFactory emFactory;
	private EntityManager em ;
	
	public MatchRequestService (){
		emFactory = Persistence.createEntityManagerFactory("SE452EclipseLink2");
		em = emFactory.createEntityManager();
	}

	public void addMatchRequest(int match_Maker_Id, int userId1, int userId2, Date requestTime, Date requestAcceptTime, String requestStatus, String requestType) throws NoSuchAlgorithmException
	{
	    MatchRequest matchRequest = new MatchRequest();
	    
	    AppUser appUser_MatchMaker = new AppUser();
	    AppUser appUser_User1 = new AppUser();
	    AppUser appUser_User2 = new AppUser();
	    
	    appUser_MatchMaker.setAppUserId(match_Maker_Id);
	    appUser_User1.setAppUserId(userId1); 
	    appUser_User2.setAppUserId(userId2);
	    
	    matchRequest.setMatchMaker_Id(appUser_MatchMaker);
	    matchRequest.setUser1_Id(appUser_User1);
	    matchRequest.setUser2_Id(appUser_User2);
	    matchRequest.setRequest_Time(requestTime);
	    matchRequest.setRequest_Accept_Time(requestAcceptTime);
	    matchRequest.setRequest_Status(requestStatus);
	    matchRequest.setRequest_Type(requestType);
	    
	    em.getTransaction().begin();
	    em.persist(matchRequest);
	    em.flush();
	    em.getTransaction().commit();
	}
	
	public List<MatchRequest> listMatchRequestsbyMatchMakerId(int match_Maker_Id)
	{
		List<MatchRequest> matchRequestList = null;
		
	    Query q = em.createQuery("select t from MatchRequest t where t.MatchMaker_Id_UserId = ?1")
	    		.setParameter(1, match_Maker_Id);
	    
	    matchRequestList = q.getResultList();
	   	    
	    return matchRequestList;	
	}
	
	public List<MatchRequest> listMatchRequestsbyUserId(int userId)
	{
		List<MatchRequest> matchRequestList = null;
		
	    Query q = em.createQuery("select t from MatchRequest t where (t.User1_Id_UserId = ?1 OR User2_Id_UserId = ?1)")
	    		.setParameter(1, userId);
	    
	    matchRequestList = q.getResultList();
	    
	    return matchRequestList;	
	}
	
	public void updateMatchRequestStatus(int match_Maker_Id, int userId1, int userId2, String request_Status)
	{
	    em.getTransaction().begin();
	    MatchRequest matchRequest = new MatchRequest();
	    
	    AppUser appUser_MatchMaker = new AppUser();
	    AppUser appUser_User1 = new AppUser();
	    AppUser appUser_User2 = new AppUser();
	    
	    appUser_MatchMaker.setApp_user_id(match_Maker_Id);
	    appUser_User1.setApp_user_id(userId1); 
	    appUser_User2.setApp_user_id(userId2);
	    
	    matchRequest.setMatchMaker_Id(appUser_MatchMaker);
	    matchRequest.setUser1_Id(appUser_User1);
	    matchRequest.setUser2_Id(appUser_User2);
	    
	    matchRequest.setRequest_Status(request_Status);
	    em.merge(matchRequest);
	    em.getTransaction().commit();
	}
	
}
