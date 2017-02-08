<html>
<body>
<form action="LOGIN" method="post">
<div align=center>
<table>
	<tr>
		<td><b>User Name</b></td>
		<td><b>:</b></td>
		<td><input type="text" name="username" required="required" /></td>
		<td>
			<input type="submit" value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Login&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" />
		</td>
	</tr>
	<tr>
		<td><b>Password</b></td>
		<td><b>:</b></td>
		<td><input type="password" name="password" required="required" /></td>
	</tr>
	<tr>
		<td colspan=3 align=left>
			<% if(null != request.getParameter("login") && request.getParameter("login").toString().equals("false") )
			{
				out.println("<div style='color:red'>User/Password is invalid! <br/> Please, try again.</div>");
				
			}
			%>

</div>
</form>

</body>
</html>
