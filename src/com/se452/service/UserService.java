package com.se452.service;

import java.security.NoSuchAlgorithmException;

import com.se452.model.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class UserService implements UserServiceInterface{
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager ;
	
	public UserService (){
			entityManagerFactory = Persistence.createEntityManagerFactory("SE452EclipseLink2");
			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
}
 
	

	public void addUser(String userName, String userEmail, String userGender, String userPassword,int age) throws NoSuchAlgorithmException
	{
	
	    AppUser au=new AppUser();
	    au.setApp_user_name(userName);
	    au.setEmail_Address(userEmail);
	    au.setGender(userGender);
	    au.setPassword(userPassword);
	    au.setAge(age);
	    entityManager.persist(au);
	    entityManager.flush();
	  
	   
	}
	
	public boolean verifyExistingUser(String userName, String userPassword) throws NoSuchAlgorithmException

	{
		boolean ifValid=true;
		
	    List result=entityManager.createQuery("select au.password from AppUser au where au.appUserName=:userName")
		          .setParameter("userName", userName).getResultList();
		String passwordDB=result.get(0).toString();
		PasswordEncryption pe=new PasswordEncryption ();
		pe.setOriginalPassword(userPassword);
		pe.passwordEncrypt();
		String passwordEncrypted=pe.getEncryptedPassword();
		if(passwordEncrypted.equals(passwordDB))
			{ifValid=true;
			}
		else {
			ifValid=false;
		}
		return ifValid;	
		
	}
	
	public AppUser deleteUser(String userName)
	{
		
		List result = entityManager.createQuery("select au from AppUser au where au.appUserName=:userName")
		          .setParameter("userName", userName).getResultList();
		AppUser testUser=(AppUser) result.get(0);
		entityManager.remove(testUser);
	    entityManager.flush();
	    return testUser;
	}
	@Override
	public void uppdateExistingUserInformation(String userName,String para, String value) throws NoSuchAlgorithmException
	{
		
	    List result = entityManager.createQuery("select au from AppUser au where au.appUserName=:userName")
		          .setParameter("userName", userName).getResultList();
	    AppUser testUser=(AppUser) result.get(0);
	    if(para.toUpperCase().equals("PASSWORD"))
	    {
	    	testUser.setPassword(value);
	    }
	    else if(para.toUpperCase().equals("GENDER"))
	    {
	    	testUser.setGender(value);
	    } 
	    else if(para.toUpperCase().equals("EMAIL"))
	    {
	    	testUser.setEmail_Address(value);
	    }
	    else if(para.toUpperCase().equals("AGE"))
	    {
	    	testUser.setAge(Integer.parseInt(value));
	    }
	    entityManager.persist(testUser);
	    entityManager.flush();
	}
	
	@Override
	public void commitTransaction() {
		
		entityManager.getTransaction().commit();
	    entityManager.close();
	    entityManagerFactory.close();
	}



	@Override
	public AppUser getUser(String userName) {
		List result = entityManager.createQuery("select au from AppUser au where au.appUserName=:userName")
		          .setParameter("userName", userName).getResultList();
		AppUser testUser=(AppUser) result.get(0);
		return testUser;
	}
	
}
