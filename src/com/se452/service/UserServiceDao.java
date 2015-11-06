package com.se452.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.se452.model.AppUser;
import com.se452.model.PasswordEncryption;
import com.se452.model.Profile;

public class UserServiceDao implements UserServiceDaoInterface {

	private EntityManager em;

	public UserServiceDao() {
		em = Persistence.createEntityManagerFactory("SE452EclipseLink2").createEntityManager();
	}

	@Override
	public boolean userNameExists(String userName) {
		List result = em.createQuery("select au from AppUser au where au.userName=:userName")
				.setParameter("userName", userName).getResultList();

		if (result != null && result.size() != 0) {
			AppUser user = new AppUser();
			user = (AppUser) result.get(0);
			if (user.getUserName().equals(userName))
				return true;
		}
		return false;
	}

	@Override
	public void addUser(String userName, String userEmail, String userGender, String userPassword, int age)
			throws NoSuchAlgorithmException {
		em.getTransaction().begin();
		AppUser au = new AppUser();
		Profile p = new Profile();
		au.setUserName(userName);
		au.setEmailAddress(userEmail);
		au.setGender(userGender);
		au.setPassword(userPassword);
		au.setAge(age);
		au.setProfile(p);
		em.persist(au);
		em.getTransaction().commit();
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
		em.getTransaction().commit();
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
		em.getTransaction().commit();
	}

	/*
	 * @Override public List<AppUser> getAllUser() { List<AppUser> result =
	 * em.createQuery("select au from AppUser au").getResultList(); return
	 * result; }
	 */

	public void closeConnection() {
		em.close();
	}

}
