package com.se452.service;
import javax.persistence.Entity;

import com.se452.model.Gift;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;


public interface GiftServiceInterface {
		//review the gifts I sent
		List<Gift> reviewGiftUserSend( int userSent_Id );
		//review the gifts I received
		List<Gift> reviewGiftUserReveived( int userReceived_Id);
		//delete the gifts I received
		void deleteGIftUserReceived(int giftId, int userReceived_Id);
		//send gift to friend
		void sendGift(int gift_Id, int user_Send, int user_Received, Date modifiedTimestamp) throws NoSuchAlgorithmException;
		void commitTransaction();
		void insertGiftPic(int giftId, String picLocation) throws IOException;
		void addGift(int id, String giftName, String giftDescription);
		
		List<Gift> reviewGift(int userReceived_Id, int userSent_Id);

}
