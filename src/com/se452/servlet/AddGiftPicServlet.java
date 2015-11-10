package com.se452.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.se452.service.GiftService;

/**
 * Servlet implementation class AddGiftPicServlet
 */
@WebServlet("/AddGiftPicServlet")
public class AddGiftPicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGiftPicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int giftId  = Integer.parseInt (request.getParameter("giftId"));
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			String picLoc = request.getParameter("giftImage");

			GiftService gs = new GiftService();
			gs.addGift(giftId, name, description);
			
			GiftService gs1 = new GiftService();
			gs1.insertGiftPic(giftId, picLoc);
			gs1.closeConnection();
			
	}
}
