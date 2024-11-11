<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
/* CSS cho header và footer */
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
}

/* Header */
.header {
	background-color: #333;
	color: white;
	padding: 10px;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.header .menu {
	list-style-type: none;
	margin: 0;
	padding: 0;
	display: flex;
}

.header .menu li {
	margin-right: 20px;
}

.header .menu li a {
	color: white;
	text-decoration: none;
}

</style>

	<header class="header">
		<div class="logo">Logo</div>
		<ul class="menu">
			<li><a href="#">Trang Chủ</a></li>
			<li><a href="/BookStoreJPA/admin/books">Sản phẩm</a></li>
			<li><a href="/KTGiuaKy/login">Đăng nhập</a></li>
			<li><a href="/KTGiuaKy/register">Đăng Ký</a></li>
		</ul>
	</header>

