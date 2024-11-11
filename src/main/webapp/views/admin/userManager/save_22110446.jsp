<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit User</title>
<style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f5f5f5;
            margin: 0;
        }
        .form-container {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #555;
        }
        input[type="text"], input[type="email"], input[type="password"], input[type="date"], input[type="datetime-local"], input[type="checkbox"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="checkbox"] {
            width: auto;
        }
        button {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
	<c:if test="${user != null}">
		<h2>Edit User</h2>
	</c:if>
	<c:if test="${user == null}">
		<h2>Insert User</h2>
	</c:if>
	<form action="/KTGiuaKy/admin/user/save" method="post">

		<c:if test="${user != null}">
			<label for="id">ID:</label>
			<input type="text" id="id" name="id" readonly value="${user.id}">
			<br>
			<br>
		</c:if>

		<label for="email">Email:</label>
        <input type="email" id="email" name="email" required value="${user.email}"><br><br>
        
        <label for="fullname">Full Name:</label>
        <input type="text" id="fullname" name="fullname" value="${user.fullName}"><br><br>
        
        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone" value="${user.phone}"><br><br>
        
        <label for="passwd">Password:</label>
        <input type="password" id="passwd" name="passwd" value="${user.password}"><br><br>
        
        <label for="is_admin">Is Admin:</label>
        <input type="checkbox" id="is_admin" name="is_admin" ><br><br>
        
        <button type="submit">Save User</button>
    </form>
</body>
</html>
