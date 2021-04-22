package com.tags;


import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import com.dto.Student;

public class PStudent extends SimpleTagSupport{
	
	private List<Student> studentList;

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	@Override
	public void doTag() throws IOException {

		JspWriter out = getJspContext().getOut();
		String headings[]= {"ID","Name","Class ID"};
		
		out.print("<table border='1px' style='text-align:center; margin-left:auto;margin-right:auto;'>");		out.print("<tr>");
		for (String heading : headings) {
			out.print("<th style=\"background-color: #b9936c;\">" + heading + "</th>");
		}
		out.print("</tr>");
		
		for(Student std:studentList)
		{	
			out.print("<tr>");
			out.print("<form action='student' method='post'>");
			out.print("<td><input type='hidden' name='studentId_delete' value='" +std.getStID() + "'/>"+std.getStID()+"</td>");
			out.print("<td>"+std.getStName()+"</td>");
			out.print("<td>"+std.getClassID()+"</td>");
			out.print("<td><input type='submit' value='Delete'/></td>");
			out.print("</tr>");
			out.print("</form>");
			
			out.print("<tr bgcolor='grey'>");
			out.print("<form action='UpdateStudent' method='get'>");
			out.print("<td><input type='text' name='id' value='" +std.getStID() + "' readonly/></td>");
			out.print("<td><input type='text' name='newName' placeholder='New Name'></td>");;
			out.print("<td><input type='text' name='newClassId' placeholder='New Class ID'></td>");
			out.print("<td><input type='submit' value='Update'/></td>");
			out.print("</tr>");
			out.print("</form>");
		}
		
		out.print("</table>");
		
	}

}
