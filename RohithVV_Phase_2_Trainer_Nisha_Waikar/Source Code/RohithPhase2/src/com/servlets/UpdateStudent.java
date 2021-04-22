package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bo.AcademyBOImpl;
import com.dto.Student;
import com.exep.Bexcep;


public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdateStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session=request.getSession(false);
		PrintWriter out=response.getWriter();
		AcademyBOImpl obj=new AcademyBOImpl();
		Student student=new Student();
		if(session!=null) {
			try {
				student.setStName(request.getParameter("newName"));
				student.setStID(Integer.parseInt(request.getParameter("id")));
				if(!request.getParameter("newClassId").isEmpty()) {
				student.setClassID(Integer.parseInt(request.getParameter("newClassId")));}
				else {student.setClassID(0);}
				obj.updStudent(student);
				List<Student> studentList=obj.listStudents();
				session.setAttribute("studentList", studentList);
				response.sendRedirect("viewStudent.jsp");
			} catch (Bexcep e) {
				session.setAttribute("exception", e.getMessage());
				response.sendRedirect( "student");}
			catch(Exception e1) {

				session.setAttribute("exceptionSys", e1.getMessage());
				response.sendRedirect( "student");
			}			
		}
		else {
			out.print("<center><h3>Your session has expired.. Navigating you to home page.....</h3></center>");
			response.setHeader("refresh", "5;url='/RohithPhase2'");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session=request.getSession(false);
		PrintWriter out=response.getWriter();
		AcademyBOImpl obj=new AcademyBOImpl();
		Student student=new Student();
		if(session!=null) {
			try {
				student.setStName(request.getParameter("studentName"));
				obj.addStudent(student);
				List<Student> studentList=obj.listStudents();
				session.setAttribute("studentList", studentList);
				response.sendRedirect("viewStudent.jsp");
			}catch (Bexcep e) {
				session.setAttribute("exception", e.getMessage());
				response.sendRedirect( "student");}
			catch(Exception e1) {

				session.setAttribute("exceptionSys", e1.getMessage());
				response.sendRedirect( "student");
			}			
		}
		else {
			out.print("<center><h3>Your session has expired.. Navigating you to home page.....</h3></center>");
			response.setHeader("refresh", "5;url='/SchoolManagmentSystem'");
		}
			
	}
}