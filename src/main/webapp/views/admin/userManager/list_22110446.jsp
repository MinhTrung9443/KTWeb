<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Danh Sách Tác Giả</title>
</head>
<body> 
	<div>
	<h2>Danh Sách Tác Giả</h2>
	<a href="/KTGiuaKy/admin/user/insert">Thêm tác giả</a>
	</div>

	<table border="1" , width=100%>
		<thead>
			<tr>
				<th>STT</th>
				<th>User ID</th>
				<th>User Name</th>
				<th>User Email</th>
				<th>User Phone</th>
				<th>User Password</th>
				<th>isAdmin</th>
				<th>Action</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}" varStatus="status">
				<tr>
					<td>${(currentPage - 1) * 6 + status.index + 1}</td>
					<td>${user.id}</td>
					<td>${user.fullName}</td>
					<td>${user.email}</td>
					<td>${user.phone}</td>
					<td>${user.password}</td>
					<td>${user.isAdmin() == true ? 'Admin' : 'User'}</td>
					<td><a
						href="<c:url value='/admin/user/update?email=${user.email}'/>"
						class="center">Sửa </a> | <a
						href="<c:url value='/admin/user/delete?id=${user.id}'/>"
						class="center">Xóa </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<!-- Phân trang -->
	<div class="pagination">
		<a href="/KTGiuaKy/admin/users?page=${currentPage - 1}">Previous</a>
		<span>Page ${currentPage} of ${totalPages}</span> <a
			href="/KTGiuaKy/admin/users?page=${currentPage + 1}">Next</a>
	</div>

</body>
</html>