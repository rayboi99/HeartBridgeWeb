package com.se452.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.se452.model.Gift;
import com.se452.service.GiftService;

/**
 * Servlet implementation class giftServlet
 */
public class GiftServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiftServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        GiftService gs = new GiftService();
	//	int id = (int) session.getAttribute("userIdKey");
        List<Gift> giftlistRE = gs.reviewGiftUserReveived(76); 
        request.setAttribute("giftlistRE", giftlistRE);
        List<Gift> giftlistSE = gs.reviewGiftUserSend(76);
        request.setAttribute("giftlistSE", giftlistSE);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
