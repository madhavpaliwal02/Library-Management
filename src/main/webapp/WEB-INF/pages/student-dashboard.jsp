<html>
<head>

<%@include file="./base.jsp"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

<title><c:out value="${title }"></c:out></title>
</head>
<body>

	<div class="container mt-3">

		<h1 class="text-center">
			Welcome To The <b>Student DashBoard</b>
		</h1>

		<!-- Navigation Button -->
		<div class="text-center mt-2">
			<a class="btn btn-primary"
				href='<c:url value='/viewBooksStudent/${stu.id }'> </c:url>' role="button">View
				Books</a> <a class="btn btn-primary"
				href='<c:url value='/returnBook'> </c:url>' role="button">Return
				Books</a>
		</div>

		<div class="row text-center mt-4">
			<!-- Personal Details -->
			<div class="col-5">
				<h3 class="text-center">Personal Details</h3>
				<table class="table table-hover">
					<tr>
						<td>Id:</td>
						<td>${stu.id }</td>
					</tr>
					<tr>
						<td>Name:</td>
						<td>${stu.name }</td>
					</tr>
					<tr>
						<td>Roll No:</td>
						<td>${stu.rollno }</td>
					</tr>
					<tr>
						<td>E-mail:</td>
						<td>${stu.email }</td>
					</tr>
					<tr>
						<td>Gender:</td>
						<td>${stu.gender }</td>
					</tr>
					<tr>
						<td>Course:</td>
						<td>${stu.course }</td>
					</tr>
					<tr>
						<td>Date of Admission:</td>
						<td>${stu.date }</td>
					</tr>
				</table>


			</div>
			
			<!-- Issued Books -->
			<div class="col-5 offset-2">
				<h3 class="text-center">Issued Books</h3>
				<div class="container">
					<table class="table table-hover text-center mt-3">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Name</th>
								<th scope="col">Author's Name</th>
								<th scope="col">Edition</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ibook }" var="book">
								<tr>
									<th scope="row">${book.id }</th>
									<td>${book.name }</td>
									<td>${book.authorName }</td>
									<td>${book.edition}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>


		<div class="container text-center mt-3">
			<a href="studentLogin" class="btn btn-outline-Danger">Log-Out</a> <a
				href="home" class="btn btn-outline-Danger">HOME</a>
		</div>

	</div>
</body>
</html>