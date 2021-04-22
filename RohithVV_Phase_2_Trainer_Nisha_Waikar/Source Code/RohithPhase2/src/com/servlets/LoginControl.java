package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bo.AcademyBOImpl;
import com.exep.Bexcep;


public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginControl() {

    }

	
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		PrintWriter out=response.getWriter();
		RequestDispatcher rd = null;
		
		AcademyBOImpl obj=new AcademyBOImpl();
		try {
			if(obj.userLogin(username, password)) {
				HttpSession session=request.getSession();
				session.setAttribute("username", username);
				session.setMaxInactiveInterval(60);
				response.sendRedirect("Dashboard.jsp");

			}
		} catch (Bexcep e) {
			rd=request.getRequestDispatcher("login.jsp");
		rd.include(request, response);	
		out.print("<center><span style='color:red'>"+e.getMessage()+"</span></center>");
		}
		
	}

}
