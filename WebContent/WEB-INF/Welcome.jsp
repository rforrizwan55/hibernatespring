<%@ include file="/WEB-INF/includes.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/hibernateExample/add" method="post">
	<table>
	<tr><td>${msg}</td></tr>
	<tr><td><input type="text" name="empId" placeholder="id"></td></tr>
	<tr><td><input type="text" name="firstName" placeholder="Name"></td></tr>
	<tr><td><input type="text" name="lastName" placeholder="Lname"></td></tr>
	<tr><td><input type="submit" name ="action" value="add"></td><td><input type="submit" value="edit" name ="action"></td><td><input type="submit" value="delete" name ="action"></td></tr>
	</table>
	
	<table border="1">
	<th>ID</th>
	<th>First name</th>
	<th>Last name</th>
	<th>Year level</th>
	<c:forEach items="${empList}" var="emp1">
		<tr>
			
			<td>${emp1.firstName}</td>
			<td>${emp1.lastName}</td>
			<td>${emp1.empId}</td>
		</tr>
	</c:forEach>
</table>
	
</form>
</body>
</html>