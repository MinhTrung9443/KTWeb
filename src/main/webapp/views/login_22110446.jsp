<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Đăng Nhập</title>
</head>
<body>
	<h1>Đăng Nhập</h1>
	<c:if test="${message != null}">
		<h3 style="color: red">${message}</h3>
	</c:if>
	<div></div>
	<form action="/KTGiuaKy/login" method="POST">
		<label for="email">Email:</label><br> <input type="email"
			id="email" name="email" required value="${account.email}"><br> <br> <label
			for="password">Mật khẩu:</label><br> <input type="password"
			id="password" name="password" required value="${account.password}"><br> <br> <input
			type="checkbox" id="remember" name="remember"> <label
			for="remember">Nhớ mật khẩu</label><br>
		<br> <input type="submit" value="Đăng Nhập">

	</form>
</body>
</html>
