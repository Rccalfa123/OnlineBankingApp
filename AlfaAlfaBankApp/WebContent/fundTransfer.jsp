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
						<th colspan="6" height="35"><h2>Fund Transfer</h2></th>
					</tr>
					<tr>
						<th height="20">From Account Number : </th>
						<th colspan="5" > <input type="number" name="typedFromAccount"  placeholder=" From Account Number "></th>
					</tr>
					<tr>
						<th height="20">To Account Number : </th>
						<th colspan="5" > <input type="number" name="typedToAccount"  placeholder=" To Account Number "></th>
					</tr>
					<tr>
						<th height="20">Amount : </th>
						<th colspan="5" > <input type="number" name="typedAmount"  placeholder="Enter Amount"></th>
					</tr>
					<tr>
						<th height="20">Remarks : </th>
						<th colspan="5" > <input type="text" name="typedremarks"  placeholder=" Remarks "></th>
					</tr>
 					<tr>
						<th colspan="6"  height="40"><a href = "withdraw.app">Transfer</a></th>
					</tr>
				</table>
			</div>

		</form>
	<jsp:include page="footer.html"></jsp:include>


</body>
</html>