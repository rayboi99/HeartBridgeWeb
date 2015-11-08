package com.se452.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.se452.model.AppUser;
import com.se452.model.Profile;

public class ProfileService implements ProfileInterface {
	EntityManager em;

	public ProfileService() {
		em = Persistence.createEntityManagerFactory("SE452EclipseLink2").createEntityManager();
	}

	@Override
	public void insertPicture(int userId, String picLocation) throws IOException {
		em.getTransaction().begin();
		if (picLocation != null && !picLocation.equals("")) {

			File image = new File(picLocation);
			FileInputStream input = null;
			try {
				input = new FileInputStream(image);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			byte[] bytes = getBytes(input);
			AppUser user = em.find(AppUser.class, userId);
			user.getProfile().setPicture(bytes);
		}
		em.getTransaction().commit();
	}

	private byte[] getBytes(InputStream is) throws IOException {
		int len;
		int size = 1024;
		byte[] buf;

		if (is instanceof ByteArrayInputStream) {
			size = is.available();
			buf = new byte[size];
			len = is.read(buf, 0, size);
		} else {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			buf = new byte[size];
			while ((len = is.read(buf, 0, size)) != -1)
				bos.write(buf, 0, len);
			buf = bos.toByteArray();
		}
		return buf;
	}

	@Override
	public void deletePicture(int userId) {
		em.getTransaction().begin();
		AppUser user = em.find(AppUser.class, userId);
		user.getProfile().setPicture(new byte[0]);
		em.getTransaction().commit();
	}

	@Override
	public void updateProfile(int userId, String aboutMe, String hobby, String idealPartner) {
		em.getTransaction().begin();
		AppUser user = em.find(AppUser.class, userId);
		
		if (aboutMe != null && !aboutMe.equals("")){
		user.getProfile().setAboutMe(aboutMe);
		}
		if (hobby != null && !hobby.equals("")){
		user.getProfile().setHobby(hobby);
		}
		if (idealPartner != null && !idealPartner.equals("")){
		user.getProfile().setIdealPartner(idealPartner);
		}
		em.getTransaction().commit();
	}

	@Override
	public Profile getProfile(int userId) {
		Query sql = em.createQuery("select u.profile from AppUser u where u.userId =?1");
		sql.setParameter(1, userId);
		Profile profile = (Profile) sql.getSingleResult();
		return profile;
	}

	@Override
	public byte[] getPicture(int userId) {
		AppUser user = em.find(AppUser.class, userId);
		return user.getProfile().getPicture();
	}

	public void closeConnection() {
		em.close();
	}
}
