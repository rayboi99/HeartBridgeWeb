package com.se452.service;

import com.se452.model.*;
import java.util.List;

import javax.persistence.EntityManager;

public class UniversityServiceDao implements UniversityServiceDaoInterface {
	private EntityManager em;
	@Override
	public void addUniversity(String unName) {
		University un=new University();
		un.setUniversityName(unName);
		em.persist(un);
		em.getTransaction().commit();
	}

	@Override
	public void deleteUniversity(String university_Name) {
		 List result=em.createQuery("select un from University un where un.universityName=:uniName")
		          .setParameter("uniName", university_Name).getResultList();
		 if(result.size()!=0)
		 {
			 University unObject=(University)result.get(0);
			 em.remove(unObject);
		 }

	}

	@Override
	public void setEntityManager(EntityManager em) {
		this.em=em;
		
	}

}
