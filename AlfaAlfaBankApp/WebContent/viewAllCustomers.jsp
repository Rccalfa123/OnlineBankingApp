<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="alfa" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="mystyle.css">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

		<form action=".app" method="get">

			<div>
				<table cellspacing="15" align="center" border="2">
					<tr>
						<th colspan="6" height="35"><h2>All Account Details</h2></th>
					</tr>
					<tr>
						<th height="20">Customer ID</th>
						<th height="20">Customer Name</th>
						<th height="20">Account Number</th>
						<th height="20">Email ID</th>
						<th height="20">Phone No</th>
						<th height="20">Date Of Birth</th>
					</tr>

					<alfa:forEach var="booksInCart" items="${sessionScope.booksInCart}">
						<tr>
							<td align="center">${booksInCart.bookObject.bookId}</td>
							<td align="center">${booksInCart.bookObject.bookName}</td>
							<td align="center">${booksInCart.bookObject.bookDescription}</td>
							<td align="center">${booksInCart.bookObject.bookPrice}</td>
							<td align="center">${booksInCart.noofBookAdded}</td>
							<td align="center" colspan="2"><a
								href="removenew.app?bookId=${booksInCart.bookObject.bookId}"> Update </a></td>
						</tr>
					</alfa:forEach>
					<tr>
						<th colspan="6">Total Price = ${sessionScope.price}</th>
					</tr>
				</table>
			</div>

		</form>
	<jsp:include page="footer.html"></jsp:include>

</body>
</html>