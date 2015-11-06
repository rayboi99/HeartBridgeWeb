package com.se452.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;

import com.se452.model.AppUser;

public interface UserServiceDaoInterface {

	boolean userNameExists(String userName); 
	void addUser(String userName, String userEmail, String userGender, String userPassword,int age) throws NoSuchAlgorithmException;
	boolean verifyExistingUser(String userName, String userPassword) throws NoSuchAlgorithmException;
	void deleteUser(String userName);
	AppUser getUser(String userName);
	void uppdateExistingUserInformation(String userName,String para, String value) throws NoSuchAlgorithmException;
	//void setEntityManager(EntityManager em);
	//List<AppUser> getAllUser();
}
