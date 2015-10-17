package com.se452.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.se452.appUser.AppUser;

public class UserUniversityServiceDao implements UserUniversityServiceDaoInterface {
	private EntityManager em;
	@Override
	public void addUserUniversity(int userID, String university_Name) {
		 List result=em.createQuery("select un from University un where un.universityName=:uniName")
		          .setParameter("uniName", university_Name).getResultList();
		 if(result.size()==0)
		 {
			UniversityServiceDao usd=new UniversityServiceDao();
			usd.setEntityManager(em);
			usd.addUniversity(university_Name);
			em.getTransaction().begin();
		 }
		 result=em.createQuery("select un from University un where un.universityName=:uniName")
		          .setParameter("uniName", university_Name).getResultList();
			 University unObject=(University)result.get(0);
		 UserUniversity userUni=new UserUniversity();
		 AppUser appUser=em.find(AppUser.class,userID);
		 userUni.setUserId(appUser);
		 userUni.setUniId(unObject); 
		 em.persist(userUni);
		 em.getTransaction().commit();
		 }
		
		 

	
	@Override
	public void deleteUserUniversity(int userID, int universityId) {
		Query qr=em.createQuery("select uu from UserUniversity uu where uu.userId.appUserId=:uid and"
				+ " uu.uniId.universityId=:unid");
		qr.setParameter("uid", userID);
		qr.setParameter("unid", universityId);
		 List result=qr.getResultList();
		 if(result.size()!=0)
		 {
			 UserUniversity uu=(UserUniversity)result.get(0);
			 em.remove(uu);
			 em.getTransaction().commit();
		 }
	}

	//SELECT p FROM Teacher t JOIN t.phones p WHERE t.firstName = :firstName");
	 
	@Override
	public List<University> showUserUniversityList(int userId) {
		Query qr=em.createQuery("select u from University u inner Join UserUniversity uu"
				+ " where uu.userId.appUserId=:uid and u.universityId=uu.uniId.universityId");
		qr.setParameter("uid", userId);
		 List <University>result=(List<University>)qr.getResultList();
		return result;
	}

	@Override
	public void setEntityManager(EntityManager em) {
		this.em=em;
		
	}

}
