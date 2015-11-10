package com.se452.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.se452.model.Gift;
import com.se452.service.GiftService;

/**
 * Servlet implementation class giftServlet
 */
@WebServlet("/giftServlet")
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
		int uid = (int) session.getAttribute("userIdKey");
//		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        GiftService gs = new GiftService();
        List<Gift> giftListSent = gs.reviewGiftUserSend(uid);
        List<Gift> giftListReceived = gs.reviewGiftUserReveived(uid);
        
        String pageFrom = request.getParameter("pageFrom");
		String friendIdSelected = request.getParameter("friendIdSelected");
		if(pageFrom != null && friendIdSelected != null){
			if (pageFrom.equals("ViewFriendshipList")){
				int friendId = Integer.parseInt(friendIdSelected);
				 List<Gift> friendGifttSend = gs.reviewGift(friendId, uid);
				 List<Gift> friendGifttRecevied = gs.reviewGift(uid, friendId);
				 request.setAttribute("giftListSent", friendGifttSend);
				 request.setAttribute("giftListReceived", friendGifttRecevied);
			}

		}
        
		else{
			request.setAttribute("giftListSent", giftListSent);
			request.setAttribute("giftListReceived", giftListReceived);
		}
       
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListGiftsByUser.jsp");
		dispatcher.forward(request, response);
		
		gs.closeConnection();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
