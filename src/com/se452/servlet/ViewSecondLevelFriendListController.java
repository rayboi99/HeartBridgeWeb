package com.se452.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.se452.model.Friendship;
import com.se452.service.FriendshipServiceDao;

/**
 * Servlet implementation class ViewSecondLevelFriendListController
 */
@WebServlet("/ViewSecondLevelFriendListController")
public class ViewSecondLevelFriendListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewSecondLevelFriendListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		
		int uid=Integer.parseInt(session.getAttribute("userIdKey").toString());
		int selectFriendID= Integer.parseInt(request.getParameter("ffflist"));
		FriendshipServiceDao fssd=new FriendshipServiceDao();
		
		List<Friendship> fsl=fssd.getFriendShipList(selectFriendID);
		List<Friendship> mutualFSL=new ArrayList<>();
		List<Friendship> notMutualFSL = new ArrayList<>();
		for(int i=0;i<fsl.size();i++)
		{
			boolean ifMutual=fssd.checkIfMutualFriend(uid,fsl.get(i).getFriend().getUserId());
			if(ifMutual)
			{
				mutualFSL.add(fsl.get(i));
			}
			else if(fsl.get(i).getFriend().getUserId()!=uid)
			{
				notMutualFSL.add(fsl.get(i));
			}
		}
		fssd.finalCommit();
		session.setAttribute("FriendshipList", fsl);
		session.setAttribute("MFriendshipList", mutualFSL);
		session.setAttribute("NMFriendshipList", notMutualFSL);
		response.sendRedirect("ViewSecondLevelFriendshipList.jsp");
	}

}
