package com.se452.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.Lob;

@Embeddable
public class Profile {
	
	@Lob
	@Column(name="PICTURE")
	private byte[] picture;
	@Column(name="HOBBY")
	private String hobby;
	@Column(name="ABOUTME")
	private String aboutMe;
	@Column(name="IDEALPARTNER")
	private String idealPartner;
	
	
	public Profile(byte[] picture, String hobby, String aboutMe, String idealPartner) {
		super();
		this.picture = picture;
		this.hobby = hobby;
		this.aboutMe = aboutMe;
		this.idealPartner = idealPartner;
	}
	
	public Profile() {
		super();
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getIdealPartner() {
		return idealPartner;
	}

	public void setIdealPartner(String idealPartner) {
		this.idealPartner = idealPartner;
	}

}
