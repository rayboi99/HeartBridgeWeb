package com.se452.model;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class UserGift {
	
	@Id
	@JoinColumn(name="GIFTID",nullable=false)
	private Gift giftId;
	@Id
	//@OneToOne
	//@JoinColumn(name="USERSENTID", table = "AppUser", referencedColumnName = "APPUSERID")
	private AppUser userSend;
	@Id
	//@OneToOne
	//@JoinColumn(name="USERSENTID", table = "AppUser", referencedColumnName = "APPUSERID")
	private AppUser userReceived;
	@Id
	//@OneToOne
	//@JoinColumn(name="USERSENTID", table = "AppUser", referencedColumnName = "APPUSERID")
	//@Temporal(TemporalType.DATE)
	//@Column(name = "DATES")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date modifiedTimestamp;
	
	public Gift getGiftId() {
		return giftId;
	}
	public void setGiftId(Gift giftId) {
		this.giftId = giftId;
	}
	public AppUser getUserSend() {
		return userSend;
	}
	public void setUserSend(AppUser userSend) {
		this.userSend = userSend;
	}
	public AppUser getUserReceived() {
		return userReceived;
	}
	public void setUserReceived(AppUser userReceived) {
		this.userReceived = userReceived;
	}
	
	public java.util.Date getModifiedTimestamp() {
		return modifiedTimestamp;
	}
	public void setModifiedTimestamp(java.util.Date modifiedTimestamp) {
		this.modifiedTimestamp = modifiedTimestamp;
	}
}
