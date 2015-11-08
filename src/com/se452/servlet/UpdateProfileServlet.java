package com.se452.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.se452.model.Profile;
import com.se452.service.ProfileService;

/**
 * Servlet implementation class UpdateProfileServlet
 */
@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher("/createDate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url ="/MyProfile.jsp";
		
		if (request.getParameter("update") != null){
			url = "/UpdateProfile.jsp";
		}
		
		if (request.getParameter("save") != null) {
			String aboutMe = request.getParameter("aboutMe");
			String hobby = request.getParameter("hobby");
			String idealPartner = request.getParameter("idealPartner");
			String picLocation = request.getParameter("image");
			HttpSession session = request.getSession();
			int id = (int) session.getAttribute("userIdKey");

			ProfileService profile = new ProfileService();
			profile.updateProfile(id, aboutMe, hobby, idealPartner);
			profile.insertPicture(id, picLocation);
			
			Profile p = profile.getProfile(id);
			request.setAttribute("aboutMe", p.getAboutMe());
			request.setAttribute("hobby", p.getHobby());
			request.setAttribute("idealPartner", p.getIdealPartner());
			
			profile.closeConnection();
		}
		
		if (request.getParameter("cancel") != null) {
			HttpSession session = request.getSession();
			int id = (int) session.getAttribute("userIdKey");
			ProfileService ps = new ProfileService ();
			Profile p =ps.getProfile(id);
			
			request.setAttribute("aboutMe", p.getAboutMe());
			request.setAttribute("hobby", p.getHobby());
			request.setAttribute("idealPartner", p.getIdealPartner());
			
			ps.closeConnection();
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
