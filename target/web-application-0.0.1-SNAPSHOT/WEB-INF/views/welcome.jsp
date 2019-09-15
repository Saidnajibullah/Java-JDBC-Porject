<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.personal.project.model.Todo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="webjars/bootstrap/3.3.5/css/bootstrap.main.css">
<title>Welcome</title>
	<style>
		table, th, td{
		 border: 2px solid black;
		 border-collapse: collapse;
		 text-align: center;
		 
		} 
		table{
		width: 500px;
		margin-left: 90px;
		}
		.center{
		position: relative;
		width: 700px;
		height: 600px;
		margin: auto;
		background-color:lightblue;
		text-align: center;
		}
		#logout{
		 float: right;
		 margin-right: 30px;
		 margin-top: -40px;
		}
	</style>
</head>
<body>
<div class="center">
   <h1>Welcome ${name}</h1>
<h3>This is Your Todo List</h3>
<h4 id="logout"><a href="logout.jsp">Logout</a></h4>
	<table>
		<tr>  
			<td>Name</td>
			<td>Task</td>
			<td>Delete Task</td>
		</tr>
	<%-- <% List<Todo>todos = (ArrayList)request.getAttribute("todos");
	for(Todo todo: todos){ %>
		<tr>
			<td><%= todo.getName() %></td>
			<td><%= todo.getTask() %></td>
		</tr>
	
	<% } %> --%>
	<c:forEach items="${todos}" var="todo">
	  <tr>
			<td>${todo.getName()}</td>  
			<td>${todo.getTask()}</td>
			<td><a href="/welcome.jsp?name=${todo.getName()}">Delete</a></td>
		</tr>
	</c:forEach>
	</table><br><br>
	<h1>Add to the List</h1><br>
	<form action="/welcome.jsp" method="post">
		<label>Name</label><br>
		<input type="text" name="name"><br><br>
		<label>Task</label><br>
		<input type="text" name="task"><br><br>
		<input type="submit" value="Add">
	</form>
</div>
</body>
</html>