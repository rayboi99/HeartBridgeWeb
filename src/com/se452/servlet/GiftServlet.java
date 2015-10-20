package com.se452.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.se452.model.*;
import com.se452.service.*;;

/**
 * Servlet implementation class giftServlet
 */
@WebServlet("/ListGiftServlet")
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
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("hello");
        GiftService gs = new GiftService();
       // gs.addGift("sticker", "passion", null);
       // gs.addGift("love letter", "letter", null);
        List<Gift> giftlist = gs.reviewGiftUserReveived(76); 
    	
		out.println("<html>");
		out.println("<body>");

			out.println("</br></br>");
			out.println("Gift: " + giftlist + "</br>");
		
			out.println("</br></br>");	
		
		out.println("</body>");
		out.println("</html>");
	
               
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
