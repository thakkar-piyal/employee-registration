<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
td
{
    padding:0 100px;
}
@media screen and (max-width: 600px) {
  .h1 {
    width: 100%;
  }
}
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</style>

<body bgcolor="oldlace">
	<h1>
	<font color="oldlace">...........</font>You have successfully logged in...
	Which task do you want to perform??
	
	<br><br>
	<table>
	<tr>

		<td><img class="img-responsive" src="add.png"></td>
		<td><img class="img-responsive" src="view-emp.png"></td>
	</tr>
	
	<tr>
	<td>
		<br><a href="EmployeeReg.jsp">ADD EMPLOYEE</a>
		</td>
		<br>
		<td>
		<br><a href="EmployeeListController">VIEW EMPLOYEE</a>
		</td>
	</h1>
	</table>
</body>
</html>