<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
HttpSession mySession=request.getSession(false);
if(mySession==null){
	out.print("<center><h3>Your session has expired.. Navigating you to home page.....</h3></center>");
	response.setHeader("refresh", "5;url='/RohithPhase2'");
}
else{
	
%>
<h1 style="Color:black;text-align:center;background-color: #dac292;">Learner's Academy DashBoard</h1><b style="Color:blue;"></b>
<div style="text-align:center;">
<table  style="text-align:center; margin-left:auto;">
<tr><td>&nbsp;&nbsp;<a href="logout">logout</a>&nbsp;&nbsp;</td></tr>
</table>
<br/>

<div style="color:red;text-align: center; border: 1px outset red;
  background-color: lightblue;" >
<%if(mySession.getAttribute("exception")!=null) {%>
<%=mySession.getAttribute("exception") %>
<%}if(mySession.getAttribute("exceptionSys")!=null) {%>
System Error <%=mySession.getAttribute("exceptionSys") %>
<%} %>
</div>
<br/>
 <table border="1" style="text-align:center; margin-left:auto;margin-right:auto;">
<tr>
	<td style="color:black;background-color: #b9936c;"><b>ACTION</b></td>
	<td style="color:black;background-color: #b9936c;"><b>DESCRIPTION</b></td>
	<td style="color:black;background-color: #b9936c;"><b>LINKS</b></td>
</tr>
<tr>
	<td style="color:white;background-color: #dac292;text-align: left;"><b>MANAGE STUDENTS</b></td>
	<td style="background-color: #e6e2d3;text-align: left;">&nbsp;&nbsp; -> Get a list of all students
		<br/>&nbsp;&nbsp; -> Add New Students
		<br/>&nbsp;&nbsp; -> Update Student Details
		<br/>&nbsp;&nbsp; -> Delete an existing student</td>
	<td style="color:white;background-color:  #c4b7a6;">&nbsp;&nbsp;<a href="student">Click here</a>&nbsp;&nbsp;</td>
</tr>


<tr>
	<td style="color:white;background-color: #dac292;text-align: left;"><b>MANAGE CLASSES</b></td>
	<td style="background-color: #e6e2d3;text-align: left;">&nbsp;&nbsp; -> Get a list of all Classes
		<br/>&nbsp;&nbsp; ->Add New Class
		<br/>&nbsp;&nbsp; ->Delete an existing Class
		<br/>&nbsp;&nbsp; ->Generate Class Report</td>
	<td style="color:white;background-color:  #c4b7a6;">&nbsp;&nbsp;<a href="classes">Click here</a>&nbsp;&nbsp;</td>

</tr>


<tr>
	<td style="color:white;background-color: #dac292;text-align: left;"><b>MANAGE TEACHERS</b></td>
	<td style="background-color: #e6e2d3;text-align: left;">&nbsp;&nbsp; -> Get a list of all Teachers
		<br/>&nbsp;&nbsp; ->Add New Teachers
		<br/>&nbsp;&nbsp; ->Update Teacher Details
		<br/>&nbsp;&nbsp; ->Delete an existing Teacher</td>
	<td style="color:white;background-color:  #c4b7a6;">&nbsp;&nbsp;<a href="teacher">Click here</a>&nbsp;&nbsp;</td>
</tr>


<tr>
<td style="color:white;background-color: #dac292;text-align: left;"><b>MANAGE SUBJECTS</b></td>
	<td style="background-color: #e6e2d3;text-align: left;">&nbsp;&nbsp; -> Get a list of all Subjects
		<br/>&nbsp;&nbsp; ->Add New Subject
		<br/>&nbsp;&nbsp; ->Update Subject Details, Assign a Teacher, Designate a Class
		<br/>&nbsp;&nbsp; ->Delete an existing Subject</td>
	<td style="color:white;background-color:  #c4b7a6;">&nbsp;&nbsp;<a href="subject">Click here</a>&nbsp;&nbsp;</td>
</tr>
</table>

</div>
<%@include file='footer.html' %>
<%} %>
<%mySession.removeAttribute("exception");
mySession.removeAttribute("exceptionSys");%>
</body>
</html>