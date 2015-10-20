package com.se452.service;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.se452.model.*;

public class MessageService {
	
	private EntityManagerFactory emFactory;
	private EntityManager em ;
	
	public MessageService (){
		emFactory = Persistence.createEntityManagerFactory("SE452EclipseLink2");
		em = emFactory.createEntityManager();
	}

	public void addMessage(Date dateSent, String message, String subject, int userId_From, int userId_To) throws NoSuchAlgorithmException
	{
	    Message msg = new Message();
	    msg.setDate_Sent(dateSent);
	    msg.setMessage(message);
	    msg.setSubject(subject);
	    
	    AppUser userTo = em.find(AppUser.class, userId_To);
	    AppUser userFrom = em.find(AppUser.class, userId_From);
	    
	    msg.setUser_Id_From(userFrom);
	    msg.setUser_Id_To(userTo);
	    
		em.getTransaction().begin();
		em.persist(msg);
		em.flush();
		em.getTransaction().commit();
	}
	
	public List<Message> listMessagesByUserId(int userId_From)
	{
		List<Message> messageList = null;
		
		AppUser userFrom = em.find(AppUser.class, userId_From);
		
	    Query q = em.createQuery("select t from Message t where t.User_Id_From = ?1")
	    		.setParameter(1, userFrom);
	    
	    messageList = q.getResultList();
	   	    
	    return messageList;	
	}
}
