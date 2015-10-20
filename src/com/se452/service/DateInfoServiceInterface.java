package com.se452.service;

import java.util.Date;
import java.util.List;

import javax.persistence.Id;

import com.se452.model.AppUser;
import com.se452.model.DateInfo;
import com.se452.model.DateInfoId;
import com.se452.model.Status;


public interface DateInfoServiceInterface {
	
	void createDate (AppUser matchMaker, AppUser user1, AppUser user2, Date dateTime, String location, String description);
	void writeFeedBack ();
	void rejectDate ();
	void viewDateAsUser();
	void updateDate(DateInfoId id, Date dateTime, String location, String description);
	List<DateInfo> ViewDateAsMatchMaker(int user);
}
