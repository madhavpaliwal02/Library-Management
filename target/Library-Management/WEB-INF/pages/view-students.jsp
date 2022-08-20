<html>
<head>

<%@include file="./base.jsp"%>

<title><c:out value="${title }"></c:out></title>
</head>
<body>
	<!-- View Students -->
	<div class="container">
		<h1 class="text-center">Students List</h1>

		<table class="table table-hover text-center mt-3">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">Roll NO</th>
					<th scope="col">Email</th>
					<th scope="col">Course</th>
					<th scope="col">Gender</th>
					<th scope="col">Date</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${student }" var="stu">
					<tr>
						<th scope="row">${stu.id }</th>
						<td>${stu.name }</td>
						<td>${stu.rollno }</td>
						<td>${stu.email }</td>
						<td>${stu.course }</td>
						<td>${stu.gender }</td>
						<td>${stu.date }</td>
						<td><a href="deleteStudent/${stu.id }"> <i
								class="fas fa-trash-can text-danger" style="font-size: 25px">
							</i>
						</a> <a href="updateStudent/${stu.id }"> <i class="fas fa-pen"
								style="font-size: 25px"> </i>
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="container text-center">

			<c:if test="${user=='admin' }">
				<a href="${pageContext.request.contextPath }/adminDashboardBack"
					class="btn btn-outline-warning">Back</a>
			</c:if>
			<c:if test="${user=='librarian' }">
				<a href="${pageContext.request.contextPath }/${value }"
					class="btn btn-outline-warning">Back</a>
			</c:if>
			<a href="home" class="btn btn-outline-Danger">Home</a>
		</div>
	</div>
</body>
</html>