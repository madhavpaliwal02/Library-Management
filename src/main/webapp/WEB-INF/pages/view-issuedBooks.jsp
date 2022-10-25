<html>
<head>

<%@include file="./base.jsp"%>

<title><c:out value="${title }"></c:out></title>
</head>
<body>
	<!-- View Books -->
	<div class="container">
		<h1 class="text-center">Books Issued by Students</h1>

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
					<th scope="col">Student's Name</th>
					<th scope="col">Student's Roll No</th>
					<th scope="col">Student's Email</th>
					<th scope="col">Issuing Date</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ibook }" var="book">
					<tr>
						<th scope="row">${book.id }</th>
						<td>${book.bName }</td>
						<td>${book.bAuthName }</td>
						<td>${book.sName}</td>
						<td>${book.rollNo }</td>
						<td>${book.sEmail }</td>
						<td>${book.date }</td>
						<c:if test="${user=='admin' }">
							<td><a href="${pageContext.request.contextPath }/deleteIssueBookAdmin/${book.id }"> <i
									class="fas fa-trash-can text-danger" style="font-size: 25px">
								</i>
							</a></td>
						</c:if>
						<c:if test="${user=='librarian' }">
							<td><a href="${pageContext.request.contextPath }/deleteIssueBookLibrarian/${lid }/${book.id }"> <i
									class="fas fa-trash-can text-danger" style="font-size: 25px">
								</i>
							</a></td>
						</c:if>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="container text-center">
			<c:if test="${user=='admin'  }">
				<a href="${pageContext.request.contextPath }/adminDashboardBack" class="btn btn-outline-warning">Back</a>
			</c:if>
			<c:if test="${user=='librarian'  }">
				<a href="${pageContext.request.contextPath }/librarianDashboardBack/${lid }" class="btn btn-outline-warning">Back</a>
			</c:if>

			<a href="${pageContext.request.contextPath }/home" class="btn btn-outline-Danger">Home</a>
		</div>
	</div>
</body>
</html>