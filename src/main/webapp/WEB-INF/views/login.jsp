<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	 <h1>Login Page</h1>
	 <form action="/login" method="post">  
	 <label for="username">Username</label><br>
	 <input class="wrong" type="text" name="name" id="username"><br><br>
	 <label for="password">Password</label><br>
	 <input class="wrong"  type="password" name="password" id="password"><br><br>
	 <input type="submit" value="Submit">
	 </form>
</body>
</html>  