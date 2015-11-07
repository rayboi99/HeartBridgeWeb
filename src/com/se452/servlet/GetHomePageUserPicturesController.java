package com.se452.servlet;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.se452.model.AppUser;
import com.se452.service.ProfileService;
import com.se452.service.UserServiceDao;

/**
 * Servlet implementation class GetHomePageUserPicturesController
 */
@WebServlet("/GetHomePageUserPicturesController")
public class GetHomePageUserPicturesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHomePageUserPicturesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session=request.getSession(true);
		int[] idlist=new int[6];
		List<byte[]> pl=new ArrayList<>();
		UserServiceDao usd= new UserServiceDao();
		List<AppUser> userList= usd.getAllUser();
		for(int i=0;i<6;i++)
		{
			int id = userList.get(i).getUserId();
			ProfileService ps = new ProfileService();
			byte[] pic = ps.getPicture(id);
			idlist[i]=id;
			pl.add(pic);
			BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream((pl.get(i)))); 
			ServletContext sc=request.getSession().getServletContext(); 
			String s=sc.getRealPath("/HomePageImage");
			File savedFile = new File(s, "Image"+ i);
			try{
			ImageIO.write(bufferedImage, "JPEG", savedFile);}
			catch(Exception e)
			{
				System.out.println("Fail");
			}
			System.out.print("save");
			
		}
			
	session.setAttribute("IdList", idlist);
	session.setAttribute("pictureList", pl);
	usd.closeConnection();

	}

	
}
