package com.se452.model;

import com.se452.service.UserService;

public class Maintest {
	
	 public static void main(String[] args) throws Exception {
		  UserService us=new UserService();
		  
	us.addUser("Rey11","rey@gmail.com", "M", "passwordRey",28);
	us.addUser("Rebecca11","Rebecca@gmail.com","F","passwordRebecca",24);
	us.addUser("Emma11", "Emma@gmail.com", "F", "passwordEmma", 25);
	us.addUser("Naga11", "Naga2gail.com","M","passwordNage",26);
	/*
	boolean ifValid=us.verifyExistingUser("Tutue2", "password");
	if(ifValid==true) System.out.print("Valid");
	else  System.out.print("Not Valid");
		 
		 
	us.uppdateExistingUserInformation("Tutue2", "password", "password1");
	  ifValid=us.verifyExistingUser("Tutue2", "password");
			if(ifValid==true) System.out.print("Valid");
			else  System.out.print("Not Valid");
			us.uppdateExistingUserInformation("Tutue2", "email", "xiyu@eclipseLink.com");
			us.uppdateExistingUserInformation("Tutue2", "gender", "M");
			us.uppdateExistingUserInformation("Tutue2", "age", "11");
			*/
			us.commitTransaction();
}
	 
}
