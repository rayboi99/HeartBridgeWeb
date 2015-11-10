package com.se452.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.se452.service.UserServiceDao;

/**
 * Servlet implementation class UpdateAccountController
 */
@WebServlet("/UpdateAccountController")
public class UpdateAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAccountController() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		int uid=Integer.parseInt(session.getAttribute("userIdKey").toString());
		
		UserServiceDao usd=new UserServiceDao();
		int age=usd.getUser(uid).getAge();
		String email=usd.getUser(uid).getEmailAddress();
		String gender=usd.getUser(uid).getGender();
		session.setAttribute("email", email);
		session.setAttribute("gender", gender);
		session.setAttribute("age", age);
		session.setAttribute("IfSetPassword", true);
		usd.finalCommit();
		response.sendRedirect("UpdateAccount.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		int uid=Integer.parseInt(session.getAttribute("userIdKey").toString());
		String oldPassword = request.getParameter("oldPassword");
		String newPassword =request.getParameter("newPassword");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String age= request.getParameter("age");
		UserServiceDao usd=new UserServiceDao();
		usd.updateAccountNotSpecialItems(uid, email, gender, age);
		//usd.closeConnection();
		boolean passwordResetBoolean=false;
		try {
			
			passwordResetBoolean=usd.updateAccountPassword(uid, oldPassword, newPassword);
			usd.finalCommit();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("email", email);
		session.setAttribute("gender", gender);
		session.setAttribute("age", age);
		
		session.setAttribute("IfSetPassword", passwordResetBoolean);
		if(passwordResetBoolean==true)
		{
			
		}
		else{
		response.sendRedirect("UpdateAccount.jsp");}
		
		
	}

}
