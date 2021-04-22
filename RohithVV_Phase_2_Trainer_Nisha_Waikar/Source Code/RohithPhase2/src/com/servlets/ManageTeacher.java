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
import com.dto.Teacher;


/**
 * Servlet implementation class ManageTeacher
 */
public class ManageTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageTeacher() {
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
				List<Teacher> teacherList=boObj.listTeacher();
				session.setAttribute("teacherList", teacherList);
				response.sendRedirect("viewTeacher.jsp");
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
				
				Integer teacherId = Integer.parseInt(request.getParameter("teacherId_delete"));
				boObj.deleteTeacher(teacherId);
				List<Teacher> teacherList=boObj.listTeacher();
				session.setAttribute("teacherList", teacherList);
				response.sendRedirect("viewTeacher.jsp");
			} catch (Bexcep e) {
				session.setAttribute("exception", e.getMessage());
				response.sendRedirect( "teacher");}
			catch(Exception e1) {

				session.setAttribute("exceptionSys", e1.getMessage());
				response.sendRedirect( "teacher");
			}			
		}
		else {
			out.print("<center><h3>Your session has expired.. Navigating you to home page.....</h3></center>");
			response.setHeader("refresh", "5;url='/RohithPhase2'");
		}
		
	}

}
