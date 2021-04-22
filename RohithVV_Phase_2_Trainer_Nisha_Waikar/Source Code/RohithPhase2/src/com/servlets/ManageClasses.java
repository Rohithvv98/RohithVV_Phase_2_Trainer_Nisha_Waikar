package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exep.Bexcep;
import com.bo.AcademyBOImpl;
import com.dto.Classes;

/**
 * Servlet implementation class ManageClasses
 */
public class ManageClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageClasses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session=request.getSession(false);
		PrintWriter out=response.getWriter();
		AcademyBOImpl boObj=new AcademyBOImpl();
		if(session!=null) {
			try {
				List<Classes> classList=boObj.listClasses();
				session.setAttribute("classList", classList);
				response.sendRedirect("viewClass.jsp");
			} catch (Bexcep e) {
				session.setAttribute("exception", e.getMessage());
				response.sendRedirect( "Dashboard.jsp");}
			catch(Exception e1) {

				session.setAttribute("exceptionSys", e1.getMessage());
				response.sendRedirect( "Dashboard.jsp");
			}
				
			
		}
		else {
			out.print("<center><h3>Your session has expired.. Navigating you to home page.....</h3></center>");
			response.setHeader("refresh", "5;url='/RohithPhase2'");
		}
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session=request.getSession(false);
		PrintWriter out=response.getWriter();
		AcademyBOImpl boObj=new AcademyBOImpl();
		if(session!=null) {
			try {
				Integer classId = Integer.parseInt(request.getParameter("classId_delete"));
				boObj.deleteClass(classId);
				List<Classes> classList=boObj.listClasses();
				session.setAttribute("classList", classList);
				response.sendRedirect("viewClass.jsp");
			}  catch (Bexcep e) {
				session.setAttribute("exception", e.getMessage());
				response.sendRedirect( "classes");}
			catch(Exception e1) {

				session.setAttribute("exceptionSys", e1.getMessage());
				response.sendRedirect( "classes");
			}
				
		}
		else {
			out.print("<center><h3>Your session has expired.. Navigating you to home page.....</h3></center>");
			response.setHeader("refresh", "5;url='/RohithPhase2'");
		}
			}

}
