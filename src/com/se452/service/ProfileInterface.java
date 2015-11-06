package com.se452.service;

import java.io.IOException;

import com.se452.model.Profile;

public interface ProfileInterface {
	void insertPicture(int userId, String picLocation) throws IOException;
	void deletePicture(int userId);
	void updateProfile(int userId, String aboutMe, String hobby, String idealPartner);
	byte[] getPicture (int userId);
	Profile getProfile (int userId);
}
