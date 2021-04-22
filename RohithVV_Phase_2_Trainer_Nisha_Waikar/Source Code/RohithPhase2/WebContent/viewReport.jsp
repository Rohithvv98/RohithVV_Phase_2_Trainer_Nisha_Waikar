<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="com.dto.Classes"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="ct" uri="WEB-INF/custom_tags.tld" %>
<%@page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Class Report</title>
</head>
<body>
 
<div style="text-align:centre">
<%
HttpSession mySession=request.getSession(false);
if(mySession==null){
	out.print("<center><h3>Your session has expired.. Navigating you to home page.....</h3></center>");
	response.setHeader("refresh", "5;url='/RohithPhase2'");
}
else{
Classes cls=(Classes)mySession.getAttribute("class");
@SuppressWarnings("unchecked")
List<Object> reportList=(List<Object>)mySession.getAttribute("reportList");
if(reportList !=null){

%>
<h1 style="Color:black; background-color: #b9936c;text-align:center">Learner's Academy</h1>
<table  style="text-align:center; margin-left:auto;">
<tr><td>&nbsp;&nbsp;<a href="logout">logout</a>&nbsp;&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;<a href="/RohithPhase2/Dashboard.jsp">Dashboard</a>&nbsp;&nbsp;</td></tr>
</table>
<br/>
<h3 style="text-align:center;  color: red;background-color: #b9936c;"><b>CLASS REPORT</b></h3>
<h3 style="text-align:center; color:blue;">Class ID: <%=cls.getClassID() %><br/>Standard: <%=cls.getStd() %><br/> Division: <%=cls.getDiv() %></h3>

<ct:pReport reportList="<%=reportList %>"/>
<br/>
<br/>
</div>
<%@include file='footer.html' %>
<%} else{
response.sendRedirect("/RohithPhase2/Dashboard.jsp");
%>

<%}} %>

<%mySession.removeAttribute("exception");
mySession.removeAttribute("exceptionSys");%>
</body>
</html>