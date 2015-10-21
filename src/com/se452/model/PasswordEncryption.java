package com.se452.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordEncryption {
	private String OriginalPassword;
	private String salty;
	private String encryptedPassword;
	
	
	

	public void setOriginalPassword(String originalPassword) {
		OriginalPassword = originalPassword;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	
	private String getSecurePassword(String OriginalPassword, String salty)
    {
		
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(salty.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest(OriginalPassword.getBytes());
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

	private  String getSalt() throws NoSuchAlgorithmException
	{
	    return OriginalPassword+"salty";
	}

	public void passwordEncrypt() throws NoSuchAlgorithmException
	{
		salty=getSalt();
	 encryptedPassword = getSecurePassword(OriginalPassword, salty);
	}

}
