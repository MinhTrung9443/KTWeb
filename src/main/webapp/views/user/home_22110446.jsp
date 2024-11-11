<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách Sách theo Tác giả</title>
<style>
body {
	font-family: Arial, sans-serif;
}

.container {
	width: 80%;
	margin: auto;
}

.author-section {
	margin-top: 30px;
	border: 1px solid #ccc;
	padding: 20px;
	border-radius: 5px;
}

.book-table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 10px;
}

.book-table th, .book-table td {
	border: 1px solid #ccc;
	padding: 10px;
	text-align: left;
}

.cover-image {
	width: 10px;
	height: 15px;
	object-fit: cover;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Chào mừng đến với trang chủ User - Danh sách Sách theo Tác
			giả</h1>

		<c:forEach items="${map}" var="entry">
			<div class="author-section">
				<h2>
					Tác giả: <span>${entry.key.authorName}</span>
				</h2>
				<table class="book-table">
					<tr>
						<th>Hình ảnh</th>
						<th>Thông tin sách</th>
					</tr>
					<c:forEach var="book" items="${entry.value}">
						<tr>
							<td><c:choose>
									<c:when test="${book.coverImage.startsWith('https')}">
										<c:url value="${book.coverImage}" var="imgUrl" />
									</c:when>
									<c:otherwise>
										<c:url value="/image?fname=${book.coverImage}" var="imgUrl" />
									</c:otherwise>
								</c:choose> <img height="200" width="250" class="cover-image" src="${imgUrl}" alt="Book Cover"/></td>
							<td>
								<p>
									<strong>Tiêu đề:</strong> ${book.title}
								</p>
								<p>
									<strong>Mã ISBN:</strong> ${book.isbn}
								</p>
								<p>
									<strong>Nhà xuất bản:</strong> ${book.publisher}
								</p>
								<p>
									<strong>Ngày xuất bản:</strong> ${book.publishDate}
								</p>
								<p>
									<strong>Số lượng:</strong> ${book.quantity}
								</p>
								<p>
									<strong>Review (10)</strong>
								</p>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</c:forEach>
	</div>
</body>
</html>
