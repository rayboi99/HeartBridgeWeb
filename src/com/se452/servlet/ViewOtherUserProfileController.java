package com.se452.servlet;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.se452.model.AppUser;
import com.se452.model.Profile;
import com.se452.service.ProfileService;
import com.se452.service.UserServiceDao;

/**
 * Servlet implementation class ViewOtherUserProfileController
 */
@WebServlet("/ViewOtherUserProfileController")
public class ViewOtherUserProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOtherUserProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String number = request.getParameter("button");
		UserServiceDao usd= new UserServiceDao();
		List<AppUser> userList= usd.getAllUser();
		AppUser au=userList.get(Integer.parseInt(number));
		String aboutMe = au.getProfile().getAboutMe();
		String hobby = au.getProfile().getHobby();
		String idealPartner = au.getProfile().getIdealPartner();
		String userName=au.getUserName();
		
		int id = au.getUserId();
		session.setAttribute("userChooseId", id);
		session.setAttribute("aboutMe", aboutMe);
		session.setAttribute("hobby", hobby);
		session.setAttribute("idealPartner",idealPartner);
		session.setAttribute("userName", userName);
		
		
		usd.finalCommit();
		
	
		response.sendRedirect("ViewOtherUserProfile.jsp");
	}

}
