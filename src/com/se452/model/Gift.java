
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.eclipse.persistence.internal.jpa.parsing.TemporalLiteralNode.TemporalType;

@Entity
@Table
@SequenceGenerator(name = "Gift_seq", initialValue = 1, allocationSize = 1)
public class Gift {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Gift_seq")
	private int giftId;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "giftId")
	private List<UserGift> usergift;
	@Column(name = "Gift_Description")
	private String giftDescription;
	@Lob
	@Column(name = "PICTURE")
	private byte[] giftPicture;

	@Column(name = "Gift_Name", unique = true, length = 30)
	private String giftName;

	public String getGiftName() {
		return giftName;
	}

	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}

	public int getGiftId() {
		return giftId;
	}

	public void setGiftId(int giftId) {
		this.giftId = giftId;
	}

	public String getGiftDescription() {
		return giftDescription;
	}

	public void setGiftDescription(String giftDescription) {
		this.giftDescription = giftDescription;
	}

	public byte[] getGiftPicture() {
		return giftPicture;
	}

	public void setGiftPicture(byte[] giftPicture) {
		this.giftPicture = giftPicture;
	}

}
