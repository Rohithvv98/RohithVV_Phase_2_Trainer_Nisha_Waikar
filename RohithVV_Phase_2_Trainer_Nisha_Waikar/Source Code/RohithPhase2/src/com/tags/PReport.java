package com.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.dto.Student;
import com.dto.Subject;
import com.dto.Teacher;

public class PReport extends SimpleTagSupport {
	private List<Object> reportList;
	

	public void setReportList(List<Object> reportList) {
		this.reportList = reportList;
	}
	
	@Override
	public void doTag() throws IOException {

		JspWriter out = getJspContext().getOut();
		String headings[]= {"ID","Name"};
		out.print("<div style='text-align:center'>");
		out.print("<b>Student Details</b>");
		out.print("<br/>");
		out.print("<table border='1px' style='text-align:center; margin-left:auto;margin-right:auto;'>");		
		out.print("<tr>");
		for (String heading : headings) {
			out.print("<th style=\"background-color: #b9936c;\">" + heading + "</th>");
		}
		out.print("</tr>");
		
		
		for(Object studObj:reportList)
		{	
			if(studObj.getClass()==Student.class) {

			Student std=(Student)studObj;
			out.print("<tr>");
			out.print("<form action='student' method='post'>");
			out.print("<td>" +std.getStID() + "</td>");
			out.print("<td>"+std.getStName()+"</td>");
			out.print("<tr>");
			}
		}
		out.print("</table>");

		out.print("<br/>");

		out.print("<br/>");
		out.print("<b>Subject Details</b>");
		out.print("<br/>");
		
		
		String headings2[]= {"ID","Name","Teacher ID"};
		
		out.print("<table border='1px' style='text-align:center;  margin-left:auto;margin-right:auto;'>");
		out.print("<tr>");
		for (String heading : headings2) {
			out.print("<th style=\"background-color: #b9936c;\">" + heading + "</th>");
		}
		out.print("</tr>");
		
		for(Object subObj:reportList)
			{	
			if(subObj.getClass()==Subject.class) {
			
			Subject sub=(Subject) subObj;
			out.print("<tr>");
			out.print("<form action='subject' method='post'>");
			out.print("<td>"+sub.getSubID() +"</td>");
			out.print("<td>"+sub.getSubName()+"</td>");
			out.print("<td>"+sub.gettID()+"</td>");
			out.print("<tr>");
			}
		}

				out.print("</table>");
		
				out.print("<br/>");
		
		out.print("<br/>");
		
		
		out.print("<b>Teacher Details</b>");
		out.print("<br/>");
String headings3[]= {"ID","Name"};
		
		out.print("<table border='1px' style='text-align:center; margin-left:auto;margin-right:auto;'>");
		out.print("<tr>");
		for (String heading : headings3) {
			out.print("<th style=\"background-color: #b9936c;\">" + heading + "</th>");
		}
		out.print("</tr>");
		
		for(Object tchObj:reportList)
		{	
			if(tchObj.getClass()==Teacher.class) {
			Teacher tch=(Teacher)tchObj;
			out.print("<tr>");
			out.print("<form action='teacher' method='post'>");
			out.print("<td>" +tch.gettID() +"</td>");
			out.print("<td>"+tch.gettName()+"</td>");
			out.print("<tr>");
			}
		}
		out.print("</table>");
		
		out.print("</div>");
	}


}
