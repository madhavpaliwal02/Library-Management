<html>
<head>

<%@include file="./base.jsp"%>

<title><c:out value="${title }"></c:out></title>
</head>
<body>
	<!-- View Books -->
	<div class="container">
		<h1 class="text-center">Books Available</h1>

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
					<th scope="col">Name</th>
					<th scope="col">Author's Name</th>
					<th scope="col">Edition</th>
					<th scope="col">Description</th>
					<th scope="col">Date</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${book }" var="book">
					<tr>
						<th scope="row">${book.id }</th>
						<td>${book.name }</td>
						<td>${book.authorName }</td>
						<td>${book.edition}</td>
						<td>${book.description }</td>
						<td>${book.date }</td>
							<c:if test="${user=='admin' }">
								<td><a href="${pageContext.request.contextPath }/bookDeleteAdmin/${book.id }"> <i
										class="fas fa-trash-can text-danger" style="font-size: 25px">
									</i>
								</a></td>
							</c:if>
							<c:if test="${user=='librarian' }">
								<td><a href="${pageContext.request.contextPath }/bookDeleteLibrarian/${lid }/${book.id }"> <i
										class="fas fa-trash-can text-danger" style="font-size: 25px">
									</i>
								</a></td>
							</c:if>
							<c:if test="${user=='student' }">
								<td><a
									href="${pageContext.request.contextPath }/issuedBook/${studentId }/${book.id }">
										<i class="fas fa-book" style="font-size: 25px"> </i>
								</a></td>
							</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="container text-center">
			<c:if test="${user=='admin' }">
				<a href="${pageContext.request.contextPath }/adminDashboardBack" class="btn btn-outline-warning">Back</a>
			</c:if>
			<c:if test="${user=='librarian' }">
				<a href="${pageContext.request.contextPath }/librarianDashboardBack/${lid }" class="btn btn-outline-warning">Back</a>
			</c:if>
			<c:if test="${user=='student' }">
				<a href="${pageContext.request.contextPath }/studentDashboardBack/${sid }"
					class="btn btn-outline-warning">Back</a>
			</c:if>

			<a href="${pageContext.request.contextPath }/home" class="btn btn-outline-Danger">Home</a>
		</div>
	</div>
</body>
</html>