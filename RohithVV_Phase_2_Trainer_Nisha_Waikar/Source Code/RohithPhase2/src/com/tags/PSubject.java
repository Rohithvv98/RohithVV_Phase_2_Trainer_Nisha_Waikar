package com.tags;


import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.dto.Subject;

public class PSubject extends SimpleTagSupport {
	
	private List<Subject> sublist;

	public void setSublist(List<Subject> sublist) {
		this.sublist = sublist;
	}

	@Override
	public void doTag() throws IOException {
		JspWriter out = getJspContext().getOut();
		String headings[]= {"ID","Name","Class ID","Teacher ID"};
		
		out.print("<table border='1px' style='text-align:center; margin-left:auto;margin-right:auto;'>");
		out.print("<tr>");
		for (String heading : headings) {
			out.print("<th style=\"background-color: #b9936c;\">" + heading + "</th>");
		}
		out.print("</tr>");
		
		for(Subject sub:sublist)
		{	
			out.print("<tr>");
			out.print("<form action='subject' method='post'>");
			out.print("<td><input type='hidden' name='subjectId_delete' value='" + sub.getSubID() + "'/>"+sub.getSubID()+"</td>");
			out.print("<td>"+sub.getSubName()+"</td>");
			out.print("<td>"+sub.getClassID()+"</td>");
			out.print("<td>"+sub.gettID()+"</td>");
			out.print("<td><input type='submit' value='Delete'/></td>");
			out.print("</tr>");
			out.print("</form>");
			
			out.print("<tr bgcolor='grey'>");
			out.print("<form action='UpdateSubject' method='get'>");
			out.print("<td><input type='text' name='id' value='" +sub.getSubID() + "' readonly/></td>");
			out.print("<td><input type='text' name='newName' placeholder='New Sub Name'></td>");
			out.print("<td><input type='number' name='newClassId' placeholder='New Class ID'></td>");
			out.print("<td><input type='number' name='newTeacherId' placeholder='New Teacher ID'></td>");
			out.print("<td><input type='submit' value='Update'/></td>");
			out.print("</tr>");
			out.print("</form>");
		}
		out.print("</table>");
		
		
		
	}
}
