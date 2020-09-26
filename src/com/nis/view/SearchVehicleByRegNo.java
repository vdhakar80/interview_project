package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.nis.controller.VehiclesController;
import com.nis.dao.DbHelper;

/**
 * Servlet implementation class SearchVehicleByRegNo
 */
@WebServlet("/SearchVehicleByRegNo")
public class SearchVehicleByRegNo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchVehicleByRegNo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		HttpSession ses=request.getSession();
		try{
			String nv="Employee Id:"+ses.getValue("ID").toString()+"&nbsp;&nbsp;&nbsp;"+ses.getValue("NAME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src='/Parking/images/"+ses.getValue("PICTURE")+"' width=50 height=50>";
		
		out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
		out.println("<script src='asset/vehicle.js'></script>");
		out.println("<link rel='stylesheet' href='asset/css/bootstraps.min.css' type='text/css'><html>");

		out.println("<body background='/Parking/images/bg.png'>");

        out.println("<center><h2 style='color:blue;'>Search Vehicle By Reg. No</h2><br>");
        out.println("<table width=30%><tr><td><b><i>Reg. No:</b></i></td><td><input type='text' id='regno' name='regno'></td></tr>");
        out.println("</table><br><input type='button' id='btnsearchbyregno' name='btnsearchbyregno' value='SEARCH' class='btn btn-success'></center></html>");
        out.println("<div id='div1'></div>");
		}catch(Exception e)
		{
			response.sendRedirect("EmployeeLogin");

		}
	}

}
