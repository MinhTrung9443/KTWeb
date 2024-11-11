<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Form Đăng Ký</title>
</head>
<body>
	<h1>Đăng Ký Tài Khoản</h1>
	<div>
	<c:if test="${message != null }">
	<h3 style="color: red">${message }</h3>
	</c:if>
	</div>
	<form action="/KTGiuaKy/register" method="POST">
		<label for="fullname">Họ và tên:</label><br> <input type="text"
			id="fullname" name="fullname" required><br>
		<br> <label for="email">Email:</label><br> <input
			type="email" id="email" name="email" required><br>
		<br> <label for="phone">Số điện thoại:</label><br> <input
			type="tel" id="phone" name="phone" required><br>
		<br> <label for="password">Mật khẩu:</label><br> <input
			type="password" id="password" name="password" required><br>
		<br> <input type="submit" value="Đăng Ký">
	</form>
</body>
</html>
