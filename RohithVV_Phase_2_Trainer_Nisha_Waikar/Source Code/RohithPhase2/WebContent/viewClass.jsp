<%@page import="java.util.List"%>
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
<title>View Class</title>
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
@SuppressWarnings("unchecked")
List<Classes> classList=(List<Classes>)mySession.getAttribute("classList");
if(classList !=null){

%>
<h1 style="text-align:center;Color:black;background-color: #dac292;border: 1px outset black">Learner's Academy</h1>
<table  style="text-align:center; margin-left:auto;">
<tr><td>&nbsp;&nbsp;<a href="logout">logout</a>&nbsp;&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;<a href="/RohithPhase2/Dashboard.jsp">Dashboard</a>&nbsp;&nbsp;</td></tr>
</table>
<br/>

<div style="color:red;text-align: center; border: 1px outset red; background-color: #dac292;" >
<%if(mySession.getAttribute("exception")!=null) {%>
<%=mySession.getAttribute("exception") %>
<%}if(mySession.getAttribute("exceptionSys")!=null) {%>
System Error <%=mySession.getAttribute("exceptionSys") %>
<%} %>
</div>
<br/>
<b>Class Details</b>
<br/>
<ct:pClass classList="<%=classList %>"/>
<br/>
<br/>
<form action="UpdateClass" method="post">
<table border="1" style="text-align:center; margin-left:auto;margin-right:auto;">
<tr>
<td style="background-color: #dac292;">Standard </td><td><input type="number" name="standard" min="0" placeholder="standard"></td>
</tr>
<tr>
<td style="background-color: #dac292;">Division </td><td><input type="text" name="division" placeholder="division"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" name="add" value="ADD CLASS"></td>
</tr>
</table>
</form>
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