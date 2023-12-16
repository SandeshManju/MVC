<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  <%@page isELIgnored="false"%>
<h1>Employees List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Email</th><th>Phone</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="cust" items="${list}">   
   <tr>  
   <td>${cust.id}</td>  
   <td>${cust.cname}</td>  
   <td>${cust.email}</td>  
   <td>${cust.phone}</td>  
   <td><a href="editcust/${cust.id}">Edit</a></td>  
   <td><a href="deletecust/${cust.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="add">Add New Customer</a>  