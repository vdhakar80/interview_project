package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.controller.AdminController;
import com.nis.model.Admin;

/**
 * Servlet implementation class CheckAdminLogin
 */
@WebServlet("/CheckAdminLogin")
public class CheckAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<html>");
		try{
		int adminid=Integer.parseInt(request.getParameter("id"));
		String password=request.getParameter("password");
		Admin A=AdminController.checkAdmin(adminid, password);
		if(A!=null)
		{
			HttpSession ses=request.getSession();
			ses.putValue("ADMINID", A.getAdminid());
			ses.putValue("ADMINNAME", A.getAdminname());
			ses.putValue("ADMINPICTURE", A.getPicture());
			ses.putValue("LTIME", new Date());
			response.sendRedirect("AdminHome");
			
		}else
		{
			out.println("<font color='red'>Invalid id or password</font>");
		}
		}catch(Exception e)
		{
			out.println("<font color='red'>Invalid id or password</font>");

			System.out.println("Error:ChechAdminLogin"+e);
		}
		out.println("</html>");
		out.flush();
		
	}

}
