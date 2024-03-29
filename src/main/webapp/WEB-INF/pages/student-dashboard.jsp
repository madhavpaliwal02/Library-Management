<html>
<head>

<%@include file="./base.jsp"%>

<title><c:out value="${title }"></c:out></title>
</head>
<body>

	<div class="container mt-3">

		<h1 class="text-center">
			Welcome To The <b>Student DashBoard</b>
		</h1>


		<!-- Condition - success -->
		<div class="container mt-2">
			<c:if test="${not empty msg }">
				<c:if test="${msg == 'failed' }">
					<div class="alert alert-danger text-center">
						<c:out value="${message }" />
					</div>
				</c:if>
				<c:if test="${msg != 'failed' }">
					<div class="alert alert-success text-center">
						<c:out value="${msg }" />
					</div>
				</c:if>
			</c:if>
		</div>


		<div class="row text-center mt-4">
			<!-- Personal Details -->
			<div class="col-4">
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

				<!-- Navigation Button -->
				<div class="text-center mt-2">
					<a
						href="${pageContext.request.contextPath }/updateStudentForm/${stu.id }"
						class="btn btn-primary">Update</a>
				</div>

			</div>

			<!-- Issued Books -->
			<div class="col-7 offset-1">
				<h3 class="text-center">Issued Books</h3>
				<div class="container">
					<table class="table table-hover text-center mt-3">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Book's Name</th>
								<th scope="col">Author's Name</th>
								<th scope="col">Book's Edition</th>
								<th scope="col">Return Book</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${iBook }" var="book">
								<tr>
									<th scope="row">${book.id }</th>
									<td>${book.name }</td>
									<td>${book.authorName }</td>
									<td>${book.edition }</td>
									<td><a
										href="${pageContext.request.contextPath }/returnBook/${stu.id }/${book.id }">
											<i class="fas fa-book text-danger" style="font-size: 25px">
										</i>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- Buttons -->
				<div class="container text-center mt-3">
					<a class="btn btn-primary"
						href='${pageContext.request.contextPath }/viewBooksStudent/${stu.id }'
						role="button">View Books</a>
				</div>
			</div>
		</div>




		<!-- Navigation Button -->
		<div class="text-center mt-2">
			<a href="${pageContext.request.contextPath }/studentLogin"
				class="btn btn-Warning">Log-Out</a> <a
				href="${pageContext.request.contextPath }/home"
				class="btn btn-Danger">Home</a>
		</div>

	</div>
</body>
</html>