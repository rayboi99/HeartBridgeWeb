package com.se452.service;

import java.util.List;

import com.se452.model.*;

public interface UniversityServiceInterface {
	
	void addUniversityForUser(String userName);
	void deleteUniversityForUser(String userName,String universityName);
	void commitTransaction();

}
