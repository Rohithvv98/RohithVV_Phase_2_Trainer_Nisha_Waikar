<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align:center;Color:black;background-color: #dac292;border: 1px outset black">Learner's Academy Portal</h1>
 
<h2 style="text-align:center; Color:red;"> Login</h2>

<div style="color:white;text-align: center;">
<form action="login" method="post">
<table border="1" style="text-align:center;color:black; margin-left:auto;margin-right:auto;" > 
<tr>
	<td><br/>&nbsp;&nbsp;Username: <input type="text" name="username" placeholder="username">&nbsp;&nbsp;<br/><br/>
	&nbsp;&nbsp;Password: <input type="password" name="password" placeholder="password">&nbsp;&nbsp;
	<br/><br/>
	</td>
</tr>
<tr><td><input type="submit" value="login"></td></tr>
</table>
<br/>
<br/>
<br/>
<%@include file='footer.html' %>
</form>
</div>
<br/>
<br/>
<br/>
<br/>
</body>
</html>