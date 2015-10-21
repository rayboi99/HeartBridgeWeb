package com.se452.model;



import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;




//import com.se452.model.DateInfor;
import com.se452.model.Friendship;
import com.se452.model.FriendRequest;
//import com.se452.model.MatchRequest;
//import com.se452.model.Message;
//import com.se452.model.Profile;
//import com.se452.model.UMUURequest;
import com.se452.model.UserUniversity;
//import com.se452.model.UserGift;






@Entity
@Table(name="APPUSER")
@SequenceGenerator(name="User_seq", initialValue=1,allocationSize=1)
public class AppUser{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="User_seq")
	@Column(name="USERID",nullable=false)
	private int appUserId;
	@Column(name="USERNAME",nullable=false,unique=true,length=30)
	private String appUserName;
	@Column(name="USEREMAILADDRESS",nullable=false,length=320)
	private String emailAddress;
	@Column(name="age",nullable=false)
	private int age;
	/*@Embedded
	private Profile profile;*/
	@Column(name="PASSWORD",nullable=false,length=40)
	private String password;
	@Column(name="GENDER",length=10)
	private String gender;
	//@OneToMany(cascade=CascadeType.ALL, mappedBy="au")
	//private List<FriendRequest> friendrequest;
	
	/*@OneToMany(cascade=CascadeType.ALL, mappedBy="matchMaker")
	private List<UMUURequest> umuuRequest;
	*/
	//@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	//private List<Friendship> friendship;
	//@OneToMany(cascade=CascadeType.ALL, mappedBy="userSend")
	/*private List<UserGift> usergift ;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="userId")*/
   // private List<UserUniversity> userUniversity;
	//@OneToMany(cascade=CascadeType.ALL, mappedBy="User_Id_To")
   /* private List<Message> userMessages;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="MatchMaker_Id")
	private List<MatchRequest> matchRequest;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="MatchMakerId")
	private List<DateInfor> dateInfor;
	
	
	public List<DateInfor> getDate() {
		return dateInfor;
	}
	public void setDate(List<DateInfor> dateInfor) {
		this.dateInfor = dateInfor;
	}*/
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	/*public List<Friendship> getFriendship() {
		return friendship;
	}
	public void setFriendship(List<Friendship> friendship) {
		this.friendship = friendship;
	}
	
	public List<UserUniversity> getUserUniversity() {
		return userUniversity;
	}
	public void setUserUniversity(List<UserUniversity> userUniversity) {
		this.userUniversity = userUniversity;
	}
	
	public List<FriendRequest> getFriendrequest() {
		return friendrequest;
	}
	public void setFriendrequest(List<FriendRequest> friendrequest) {
		this.friendrequest = friendrequest;
	}*/
	public int getApp_user_id() {
		return appUserId;
	}
	public void setApp_user_id(int app_user_id) {
		appUserId = app_user_id;
	}
	
	public String getApp_user_name() {
		return appUserName;
	}
	
	public void setApp_user_name(String app_user_name) {
		appUserName = app_user_name;
	}
	
	public String getEmail_Address() {
		return emailAddress;
	}
	public void setEmail_Address(String email_Address) {
		emailAddress = email_Address;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) throws NoSuchAlgorithmException {
		
	PasswordEncryption pe=new PasswordEncryption ();
	pe.setOriginalPassword(password);
	pe.passwordEncrypt();
	this.password=pe.getEncryptedPassword();
		
	}

	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	

}
