package com.se452.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="University")
@SequenceGenerator(name="University_seq", initialValue=1,allocationSize=1)
public class University {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="University_seq")
	private int universityId;
	@Column(name="University_Name",unique=true,length=30)
	private String universityName;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="uniId")
	private List<UserUniversity> uuni;
	
	public List<UserUniversity> getUuni() {
		return uuni;
	}
	public void setUuni(List<UserUniversity> uuni) {
		this.uuni = uuni;
	}
	public int getUniversityId() {
		return universityId;
	}
	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
}
