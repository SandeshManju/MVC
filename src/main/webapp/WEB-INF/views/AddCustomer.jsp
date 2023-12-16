<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="./save" method="post" modelAttribute="register">
<table>

<tr>
<td>Cust_Id</td>
<td><form:input path="id"></form:input></td>
</tr>
<tr>
<td>Cust_Name</td>
<td><form:input path="cname"></form:input></td>
</tr>
<tr>
<td>Cust_Email</td>
<td><form:input path="email"></form:input></td>
</tr>
<tr>
<td>Cust_Phone</td>
<td><form:input path="phone"></form:input></td>
</tr>
<tr>

<td><input type="submit" value="Save"></input></td>
</tr>

</table>
</form:form>
</body>
</html>