package com.se452.service;

import javax.persistence.EntityManager;

public interface UniversityServiceDaoInterface {
	
	void addUniversity(String universityName);
	void deleteUniversity(String universityName);
	void setEntityManager(EntityManager em);

}
