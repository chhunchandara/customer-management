<html>
<form action="UPDATE" method="post">
<table>
	<tr>
		<td>ID</td>
		<td>:</td>
		<td><input type="text" name="id" value=<%= request.getParameter("a") %> readonly="readonly"></td>
	</tr>
	<tr>
		<td>First Name</td>
		<td>:</td>
		<td><input type="text" name="fname" value=<%= request.getParameter("b") %>></td>
	</tr>
	<tr>
		<td>Last Name</td>
		<td>:</td>
		<td><input type="text" name="lname" value=<%= request.getParameter("c") %>></td>
	</tr>
	<tr>
		<td>Gender</td>
		<td>:</td>
		<td><select name="gender" value=<%= request.getParameter("d") %>>
  			<option value="Male">Male</option>
  			<option value="Female">Female</option>
		    </select>
		</td>
	</tr>
	<tr>
		<td>Email</td>
		<td>:</td>
		<td><input type="text" name="email" value=<%= request.getParameter("e") %>></td>
	</tr>
	<tr>
		<td>Date of birth</td>
		<td>:</td>
		<td><input type="text" name="dob" value=<%= request.getParameter("f") %>></td>
	</tr>
	<tr>
		<td>Address</td>
		<td>:</td>
		<td><input type="text" name="address" value=<%= request.getParameter("g") %>></td>
	</tr>
	<tr>
		<td>Phone Number</td>
		<td>:</td>
		<td><input type="text" name="phone" value=<%= request.getParameter("h") %>></td>
	</tr>
	<tr>
		<td>Create Date</td>
		<td>:</td>
		<td><input type="text" name="createdate"  value=<%= request.getParameter("i") %> readonly="readonly"></td>
	</tr>
	<tr>
		<td>Update Date</td>
		<td>:</td>
		<td><input type="text" name="updatedate" value=<%= request.getParameter("j") %> readonly="readonly"></td>
	</tr>

</table>
<input type="submit" value="Update">
  
</form>

</html>