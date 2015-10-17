package com.se452.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;


public class UserServiceDao implements UserServiceDaoInterface {

	private EntityManager em;
	@Override
	public boolean CheckIfUserNameExist(String userName) {
		List result = em.createQuery("select au from AppUser au where au.appUserName=:userName")
		          .setParameter("userName", userName).getResultList();
		
		if(result.size()!=0)
			{
			AppUser user=new AppUser();
			user=(AppUser)result.get(0);
			if(user.getApp_user_name().equals(userName))
				return true;
			}
		else if (result.size()==0)return false; 
		return false;
	}

	@Override
	public void addUser(String userName, String userEmail, String userGender,
			String userPassword, int age) throws NoSuchAlgorithmException {
		AppUser au=new AppUser();
	    au.setApp_user_name(userName);
	    au.setEmail_Address(userEmail);
	    au.setGender(userGender);
	    au.setPassword(userPassword);
	    au.setAge(age);
	    em.persist(au);
		
	}

	@Override
	public boolean verifyExistingUser(String userName, String userPassword)
			throws NoSuchAlgorithmException {
boolean ifValid=false;
		
	    List result=em.createQuery("select au.password from AppUser au where au.appUserName=:userName")
		          .setParameter("userName", userName).getResultList();
	    if(result!=null&&result.size()!=0)
	    {
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
		
		}}
		return ifValid;	
	}

	@Override
	public AppUser deleteUser(String userName) {
		List result = em.createQuery("select au from AppUser au where au.appUserName=:userName")
		          .setParameter("userName", userName).getResultList();
		AppUser testUser=(AppUser) result.get(0);
		em.remove(testUser);
	   // entityManager.flush();
		//entityManager.getTransaction().commit();
	    return testUser;
	}

	@Override
	public AppUser getUser(String userName) {
		List result = em.createQuery("select au from AppUser au where au.appUserName=:userName")
		          .setParameter("userName", userName).getResultList();
		AppUser testUser=(AppUser) result.get(0);
		return testUser;
	}

	@Override
	public void uppdateExistingUserInformation(String userName, String para,
			String value) throws NoSuchAlgorithmException {
		 List result = em.createQuery("select au from AppUser au where au.appUserName=:userName")
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
			em.persist(testUser);
		
	}

	@Override
	public void setEntityManager(EntityManager em) {
		this.em=em;
	}

}
