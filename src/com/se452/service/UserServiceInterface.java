package com.se452.service;
import com.se452.model.*;

import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManager;

public interface UserServiceInterface {

	void addUser(String userName, String userEmail, String userGender, String userPassword,int age) throws NoSuchAlgorithmException;
	boolean verifyExistingUser(String userName, String userPassword) throws NoSuchAlgorithmException;
	AppUser deleteUser(String userName);
	AppUser getUser(String userName);
	void uppdateExistingUserInformation(String userName,String para, String value) throws NoSuchAlgorithmException;
	void commitTransaction();
	
}
