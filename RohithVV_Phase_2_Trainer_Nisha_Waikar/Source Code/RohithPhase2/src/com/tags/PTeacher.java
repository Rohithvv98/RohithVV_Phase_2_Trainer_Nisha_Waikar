package com.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import com.dto.Teacher;

public class PTeacher extends SimpleTagSupport{

	private List<Teacher> teacherList;

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}
	
	@Override
	public void doTag() throws IOException{
		JspWriter out = getJspContext().getOut();
		String headings[]= {"ID","Name"};
		
		out.print("<table border='1px' style='text-align:center; margin-left:auto;margin-right:auto;'>");
		out.print("<tr>");
		for (String heading : headings) {
			out.print("<th style=\"background-color: #b9936c;\">" + heading + "</th>");
		}
		out.print("</tr>");
		
		for(Teacher tch:teacherList)
		{	
			out.print("<tr>");
			out.print("<form action='teacher' method='post'>");
			out.print("<td><input type='hidden' name='teacherId_delete' value='" +tch.gettID() + "'/>"+tch.gettID()+"</td>");
			out.print("<td>"+tch.gettName()+"</td>");
			out.print("<td><input type='submit' value='Delete'/></td>");
			out.print("</tr>");
			out.print("</form>");
			
			out.print("<tr bgcolor='grey'>");
			out.print("<form action='UpdateTeacher' method='get'>");
			out.print("<td><input type='text' name='id' value='" +tch.gettID() + "' readonly/></td>");
			out.print("<td><input type='text' name='newName' placeholder='New Teacher Name'></td>");
			out.print("<td><input type='submit' value='Update'/></td>");
			out.print("</tr>");
			out.print("</form>");
			
		}
		out.print("</table>");

		
		
		
	}
}
