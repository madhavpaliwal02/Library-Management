<html>
<head>

<%@include file="./base.jsp"%>

<title><c:out value="${title }"></c:out></title>
</head>
<body>
	<!-- View Books -->
	<div class="container">
		<h1 class="text-center"><b>Books Returned by Students Details</b></h1>

		<!-- Condition - success -->
		<c:if test="${not empty msg }">
			<div class="alert alert-success text-center">
				<c:out value="${msg }"></c:out>
			</div>
		</c:if>

		<table class="table table-hover text-center mt-3">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Book's Name</th>
					<th scope="col">Author's Name</th>
					<th scope="col">Book's Edition</th>
					<th scope="col">Student's Name</th>
					<th scope="col">Student's Roll No</th>
					<th scope="col">Student's Course</th>
					<th scope="col">Student's Gender</th>
					<th scope="col">Returned Date</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${rbook }" var="book">
					<tr>
						<th scope="row">${book.id }</th>
						<td>${book.bName }</td>
						<td>${book.author }</td>
						<td>${book.edition }</td>
						<td>${book.sName}</td>
						<td>${book.rollNo }</td>
						<td>${book.course }</td>
						<td>${book.gender }</td>
						<td>${book.date }</td>
						<c:if test="${user=='admin' }">
							<td><a
								href="${pageContext.request.contextPath }/returnBookDeleteAdmin/${book.id }">
									<i class="fas fa-trash-can text-danger" style="font-size: 25px">
								</i>
							</a></td>
						</c:if>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="container text-center">
			<c:if test="${user=='admin'  }">
				<a href="${pageContext.request.contextPath }/adminDashboardBack"
					class="btn btn-outline-warning">Back</a>
			</c:if>
			<c:if test="${user=='librarian'  }">
				<a
					href="${pageContext.request.contextPath }/librarianDashboardBack/${lid }"
					class="btn btn-outline-warning">Back</a>
			</c:if>

			<a href="${pageContext.request.contextPath }/home"
				class="btn btn-outline-Danger">Home</a>
		</div>
	</div>
</body>
</html>