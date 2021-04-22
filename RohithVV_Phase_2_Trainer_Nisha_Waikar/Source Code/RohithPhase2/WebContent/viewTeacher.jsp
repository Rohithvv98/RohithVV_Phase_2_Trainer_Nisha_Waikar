<%@page import="java.util.List"%>
<%@page import="com.dto.Teacher"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="ct" uri="WEB-INF/custom_tags.tld" %>
<%@page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Teacher</title>
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
List<Teacher> teacherList=(List<Teacher>)mySession.getAttribute("teacherList");
if(teacherList !=null ){
%>
<h1 style="Color:blue">Learner's Academy</h1>
<div style="text-align:centre">
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
<b>Teacher Details</b>
<br/>
<ct:pTeacher teacherList="<%=teacherList %>"/>
<br/>
<br/>
<form action="UpdateTeacher" method="post">
<table border="1" style="text-align:center; margin-left:auto;margin-right:auto;">
<tr>
<td style="background-color: #dac292;">Teacher Name </td><td><input type="text" name="teacherName" placeholder="Teacher Name"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" name="add" value="ADD TEACHER"></td>
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