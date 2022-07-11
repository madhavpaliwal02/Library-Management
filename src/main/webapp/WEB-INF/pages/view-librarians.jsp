<html>
<head>

<%@include file="./base.jsp"%>

<title><c:out value="${title }"></c:out></title>
</head>
<body>
	<!-- View Librarian -->
	<div class="container">

		<table class="table table-hover">
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
				<c:forEach items="${librarain }" var="lib">
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
	</div>
</body>
</html>