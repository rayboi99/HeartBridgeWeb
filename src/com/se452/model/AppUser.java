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
@SequenceGenerator(name = "User_seq", initialValue = 1, allocationSize = 1)
public class AppUser {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "User_seq")
	@Column(nullable = false)
	private int userId;

	@Column(nullable = false, unique = true, length = 30)
	private String userName;

	@Column( nullable = false, length = 320)
	private String emailAddress;

	@Column(nullable = false)
	private int age;

	@Column(nullable = false, length = 40)
	private String password;

	@Column(length = 10)
	private String gender;

	@Embedded
	private Profile profile;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "MatchMakerId")
	private List<DateInfo> dateInfo;

	// @OneToMany(cascade=CascadeType.ALL, mappedBy="au")
	// private List<FriendRequest> friendrequest;
	/*
	 * @OneToMany(cascade=CascadeType.ALL, mappedBy="matchMaker") private
	 * List<UMUURequest> umuuRequest;
	 */
	// @OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	// private List<Friendship> friendship;
	// @OneToMany(cascade=CascadeType.ALL, mappedBy="userSend")
	/*
	 * private List<UserGift> usergift ;
	 * 
	 * @OneToMany(cascade=CascadeType.ALL, mappedBy="userId")
	 */
	// private List<UserUniversity> userUniversity;
	// @OneToMany(cascade=CascadeType.ALL, mappedBy="User_Id_To")
	/*
	 * private List<Message> userMessages;
	 * 
	 * @OneToMany(cascade=CascadeType.ALL, mappedBy="MatchMaker_Id") private
	 * List<MatchRequest> matchRequest;
	 */

	/*
	 * public List<Friendship> getFriendship() { return friendship; } public
	 * void setFriendship(List<Friendship> friendship) { this.friendship =
	 * friendship; }
	 * 
	 * public List<UserUniversity> getUserUniversity() { return userUniversity;
	 * } public void setUserUniversity(List<UserUniversity> userUniversity) {
	 * this.userUniversity = userUniversity; }
	 * 
	 * public List<FriendRequest> getFriendrequest() { return friendrequest; }
	 * public void setFriendrequest(List<FriendRequest> friendrequest) {
	 * this.friendrequest = friendrequest; }
	 */

	public void setPassword(String password) throws NoSuchAlgorithmException {
		PasswordEncryption pe = new PasswordEncryption();
		pe.setOriginalPassword(password);
		pe.passwordEncrypt();
		this.password = pe.getEncryptedPassword();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<DateInfo> getDateInfo() {
		return dateInfo;
	}

	public void setDateInfo(List<DateInfo> dateInfo) {
		this.dateInfo = dateInfo;
	}

	public String getPassword() {
		return password;
	}
}
