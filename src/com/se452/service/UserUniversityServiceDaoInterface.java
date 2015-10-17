package com.se452.service;

import java.util.List;

import javax.persistence.EntityManager;

public interface UserUniversityServiceDaoInterface {

	void addUserUniversity(int userID,String universityName);
	void deleteUserUniversity(int userID,int universityId);
	List<University> showUserUniversityList(int userId);
	void setEntityManager(EntityManager em);
}
