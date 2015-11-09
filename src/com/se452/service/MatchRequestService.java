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

	public void addMatchRequest(int match_Maker_Id, int userId1, int userId2, Date requestTime, Date requestAcceptTime, String requestStatus, String requestType, String user1_Request_Status, String user2_Request_Status) throws NoSuchAlgorithmException
	{
	    MatchRequest matchRequest = new MatchRequest();
	    
	    AppUser appUser_MatchMaker = em.find(AppUser.class, match_Maker_Id);
	    AppUser appUser_User1 = em.find(AppUser.class, userId1);
	    AppUser appUser_User2 = em.find(AppUser.class, userId2);
	   
	    matchRequest.setMatchMaker_Id(appUser_MatchMaker);
	    matchRequest.setUser1_Id(appUser_User1);
	    matchRequest.setUser2_Id(appUser_User2);
	    matchRequest.setRequest_Time(requestTime);
	    matchRequest.setRequest_Accept_Time(requestAcceptTime);
	    matchRequest.setRequest_Status(requestStatus);
	    matchRequest.setRequest_Type(requestType);
	    
	    matchRequest.setUser1_Request_Status(user1_Request_Status);
	    matchRequest.setUser2_Request_Status(user2_Request_Status);
	    
	    em.getTransaction().begin();
	    em.persist(matchRequest);
	    em.flush();
	    em.getTransaction().commit();
	}
	
	public List<MatchRequest> listMatchRequestsbyMatchMakerId(int match_Maker_Id)
	{
		List<MatchRequest> matchRequestList = null;
		
		AppUser appUser_MatchMaker = em.find(AppUser.class, match_Maker_Id);
		
	    Query q = em.createQuery("select t from MatchRequest t where t.MatchMaker_Id = ?1")
	    		.setParameter(1, appUser_MatchMaker);
	    
	    matchRequestList = q.getResultList();
	   	    
	    return matchRequestList;	
	}
	
	public List<MatchRequest> listMatchRequestsbyUserId(int userId)
	{
		List<MatchRequest> matchRequestList = null;
		
		AppUser appUser_User = em.find(AppUser.class, userId);
		
	    Query q = em.createQuery("select t from MatchRequest t where (t.User1_Id = ?1 OR t.User2_Id = ?1)")
	    		.setParameter(1, appUser_User);
	    
	    matchRequestList = q.getResultList();
	    
	    return matchRequestList;	
	}
	
	public void updateMatchRequestStatus(int match_Maker_Id, int userId1, int userId2, Status user1_Request_Status, Status user2_Request_Status)
	{
	    em.getTransaction().begin();
	    
	    MatchRequestId matchRequestId = new MatchRequestId();
	    matchRequestId.setMatchMaker_Id(match_Maker_Id);
	    matchRequestId.setUser1_Id(userId1);
	    matchRequestId.setUser2_Id(userId2);

        MatchRequest matchRequest = em.find(MatchRequest.class, matchRequestId);
	    
	    Status request_Status = Status.PENDING;
	    if (user1_Request_Status == Status.ACCEPT && user2_Request_Status == Status.ACCEPT)
	    	request_Status = Status.COMPLETE;
	    else if (user1_Request_Status == Status.REJECT || user2_Request_Status == Status.REJECT)
	    	request_Status = Status.REJECT;
	    else
	    	request_Status = Status.PENDING;
	    
	    matchRequest.setRequest_Status(request_Status.toString());
	    matchRequest.setUser1_Request_Status(user1_Request_Status.toString());
	    matchRequest.setUser2_Request_Status(user2_Request_Status.toString());
	    
	    em.merge(matchRequest);
	    em.getTransaction().commit();
	}
	
}
