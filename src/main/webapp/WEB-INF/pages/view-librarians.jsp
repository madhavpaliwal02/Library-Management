<html>
<head>

<%@include file="./base.jsp"%>

<title><c:out value="${title }"></c:out></title>
</head>
<body>
	<!-- View Librarian -->
	<div class="container">
		<h1 class="text-center">Librarians List</h1>

		<table class="table table-hover text-center mt-3">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Department</th>
					<th scope="col">Gender</th>
					<th scope="col">Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${librarian }" var="lib">
					<tr>
						<th scope="row">${lib.id }</th>
						<td>${lib.name }</td>
						<td>${lib.email }</td>
						<td>${lib.department }</td>
						<td>${lib.gender }</td>
						<td>${lib.date }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="container text-center">
			<a href="adminLogin" class="btn btn-outline-warning">Back</a>
			<a href="home" class="btn btn-outline-Danger">Home</a>
		</div>
	</div>
</body>
</html>