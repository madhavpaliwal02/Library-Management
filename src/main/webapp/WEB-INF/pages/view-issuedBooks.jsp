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
					<th scope="col">Book's Name</th>
					<th scope="col">Author's Name</th>
					<th scope="col">Student's Name</th>
					<th scope="col">Student's Roll No</th>
					<th scope="col">Student's Email</th>
					<th scope="col">Issuing Date</th>
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
						<%-- <c:choose>
							<c:when test="${viewBook!= 'viewBookStudent' }">
								<td><a href="deleteBook/${book.id }"> <i
										class="fas fa-trash-can text-danger" style="font-size: 25px">
									</i>
								</a> <a href="updateBook/${book.id }"> <i class="fas fa-pen"
										style="font-size: 25px"> </i>
								</a></td>
							</c:when>
							<c:otherwise>
								<td><a
									href="${pageContext.request.contextPath }/issuedBook/${studentId }/${book.id }">
										<i class="fas fa-trash-can" style="font-size: 25px"> </i>
								</a></td>
							</c:otherwise>
						</c:choose> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="container text-center">
			<%-- <c:if test="${back == 'admin-dashboard'  }">
				<a href="adminDashboardBack" class="btn btn-outline-warning">Back</a>
			</c:if>
			<c:if test="${back == 'librarian-dashboard'  }">
				<a href="librarianDashboardBack" class="btn btn-outline-warning">Back</a>
			</c:if>
			<c:if test="${back == 'student-dashboard'  }">
				<a href="${pageContext.request.contextPath }/studentDashboardBack"
					class="btn btn-outline-warning">Back</a>
			</c:if> --%>

			<a href="home" class="btn btn-outline-Danger">Home</a>
		</div>
	</div>
</body>
</html>