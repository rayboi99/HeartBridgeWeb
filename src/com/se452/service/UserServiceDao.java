package com.se452.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.se452.model.AppUser;
import com.se452.model.PasswordEncryption;
import com.se452.model.Profile;

public class UserServiceDao implements UserServiceDaoInterface {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager em;

	public UserServiceDao() {
		entityManagerFactory = Persistence.createEntityManagerFactory("SE452EclipseLink2");
		 em = entityManagerFactory.createEntityManager();
		 em.getTransaction().begin();
	}

	@Override
	public boolean userNameExists(String userName) {
		List result = em.createQuery("select au from AppUser au where au.userName=:userName")
				.setParameter("userName", userName).getResultList();

		if (result != null && result.size() != 0) {
			AppUser user = new AppUser();
			user = (AppUser) result.get(0);
			if (user.getUserName().equals(userName))
				{
				return true;}
		}
		
		return false;
	}

	@Override
	public void addUser(String userName, String userEmail, String userGender, String userPassword, int age)
			throws NoSuchAlgorithmException {
		AppUser au = new AppUser();
		Profile p = new Profile();
		au.setUserName(userName);
		au.setEmailAddress(userEmail);
		au.setGender(userGender);
		au.setPassword(userPassword);
		au.setAge(age);
		au.setProfile(p);
		em.persist(au);
		
	}

	@Override
	public boolean verifyExistingUser(String userName, String userPassword) throws NoSuchAlgorithmException {
		boolean ifValid = false;
		List result = em.createQuery("select au.password from AppUser au where au.userName=:userName")
				.setParameter("userName", userName).getResultList();
		if (result != null && result.size() != 0) {
			String passwordDB = result.get(0).toString();
			PasswordEncryption pe = new PasswordEncryption();
			pe.setOriginalPassword(userPassword);
			pe.passwordEncrypt();
			String passwordEncrypted = pe.getEncryptedPassword();
			if (passwordEncrypted.equals(passwordDB)) {
				ifValid = true;
			

			} else {
				ifValid = false;
				

			}
		}
		return ifValid;
	}

	@Override
	public void deleteUser(String userName) {
		List result = em.createQuery("select au from AppUser au where au.userName=:userName")
				.setParameter("userName", userName).getResultList();
		AppUser testUser = (AppUser) result.get(0);
		em.remove(testUser);
		
	}

	@Override
	public AppUser getUser(int id) {
		Query query = em.createQuery("select u from AppUser u where u.userId =:userId");
		query.setParameter("userId", id);
		AppUser user = (AppUser) query.getSingleResult();
		
		return user;
	}
	
	@Override
	public AppUser getUser(String userName) {
		List result = em.createQuery("select au from AppUser au where au.userName=:userName")
				.setParameter("userName", userName).getResultList();
		AppUser testUser = (AppUser) result.get(0);
	
		return testUser;
	}

	@Override
	public void uppdateExistingUserInformation(String userName, String para, String value)
			throws NoSuchAlgorithmException {
		List result = em.createQuery("select au from AppUser au where au.userName=:userName")
				.setParameter("userName", userName).getResultList();
		AppUser testUser = (AppUser) result.get(0);
		if (para.toUpperCase().equals("PASSWORD")) {
			testUser.setPassword(value);
		} else if (para.toUpperCase().equals("GENDER")) {
			testUser.setGender(value);
		} else if (para.toUpperCase().equals("EMAIL")) {
			testUser.setEmailAddress(value);
		} else if (para.toUpperCase().equals("AGE")) {
			testUser.setAge(Integer.parseInt(value));
		}
	
	}

	/*
	 * @Override public List<AppUser> getAllUser() { List<AppUser> result =
	 * em.createQuery("select au from AppUser au").getResultList(); return
	 * result; }
	 */
	@Override
	public List<AppUser> getAllUser() {
		List<AppUser> result = em.createQuery("select au from AppUser au").getResultList();
		return result;
	}
	

	@Override
	public void updateAccountNotSpecialItems(int userId, String email, String gender, String age) {
		Query query = em.createQuery("select u from AppUser u where u.userId =:userId");
		query.setParameter("userId", userId);
		AppUser user = (AppUser) query.getSingleResult();
			user.setEmailAddress(email);
			user.setGender(gender);
			user.setAge(Integer.parseInt(age));
			em.persist(user);
		
		
			
	}

	@Override
	public boolean updateAccountPassword(int userId,String oldPass, String newPass) throws NoSuchAlgorithmException {
		Query query = em.createQuery("select u from AppUser u where u.userId =:userId");
		query.setParameter("userId", userId);
		AppUser user = (AppUser) query.getSingleResult();
		String passWordInDB =user.getPassword();
		PasswordEncryption pe = new PasswordEncryption();
		pe.setOriginalPassword(oldPass);
		pe.passwordEncrypt();
		String userTypedOldPaaword= pe.getEncryptedPassword();
		if(userTypedOldPaaword.equals(passWordInDB))
		{
			user.setPassword(newPass);
			em.persist(user);
		
			return true;
		}
	
		
		return false;
		
	}
	public void finalCommit()
	{
		em.getTransaction().commit();
		em.close();
		entityManagerFactory.close();
	}
}
