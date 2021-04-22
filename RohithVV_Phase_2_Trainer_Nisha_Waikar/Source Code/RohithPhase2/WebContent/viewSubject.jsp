<%@page import="java.util.List"%>
<%@page import="com.dto.Subject"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="ct" uri="WEB-INF/custom_tags.tld" %>
<%@page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Subjects</title>
</head>
<body>
<%
HttpSession mySession=request.getSession(false);
if(mySession==null){
	out.print("<center><h3>Your session has expired.. Navigating you to home page.....</h3></center>");
	response.setHeader("refresh", "5;url='/RohithPhase2'");
}
else{
@SuppressWarnings("unchecked")
List<Subject> subList=(List<Subject>)mySession.getAttribute("subList");
if(subList !=null){

%>
<h1 style="Color:blue">Learner's Academy</h1>

<table  style="text-align:center; margin-left:auto;">
<tr><td>&nbsp;&nbsp;<a href="logout">logout</a>&nbsp;&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;<a href="/RohithPhase2/Dashboard.jsp">Dashboard</a>&nbsp;&nbsp;</td></tr>
</table>
<br/>

<div style="color:red;text-align: center; border: 1px outset red;
  background-color: #dac292;" >
<%if(mySession.getAttribute("exception")!=null) {%>
<%=mySession.getAttribute("exception") %>
<%}if(mySession.getAttribute("exceptionSys")!=null) {%>
System Error <%=mySession.getAttribute("exceptionSys") %>
<%} %>
</div>
<br/>
<b>Subject Details</b>
<br/>
<ct:pSubject sublist="<%=subList %>"/>
<br/>
<br/>
<form action="UpdateSubject" method="post">
<table border="1" style="text-align:center; margin-left:auto;margin-right:auto;">
<tr>
<td style="background-color: #dac292;">Subject Name </td><td><input type="text" name="subName" placeholder="Subject Name"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" name="add" value="ADD SUBJECT"></td>
</tr>
</table>
</form>

<%@include file='footer.html' %>

<%} else{
response.sendRedirect("/RohithPhase2/Dashboard.jsp");
%>

<%}} %>

<%mySession.removeAttribute("exception");
mySession.removeAttribute("exceptionSys");%>
</body>
</html>