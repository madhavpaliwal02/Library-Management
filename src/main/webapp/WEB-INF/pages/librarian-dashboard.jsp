<html>
<head>

<%@include file="./base.jsp"%>

<title><c:out value="${title }"></c:out></title>
</head>
<body>

	<div class="container">
		<h1 class="text-center">
			Welcome To The <b>Librarian DashBoard</b>
		</h1>


		<!-- Navigation Button -->
		<div class="text-center mt-3">
			<a class="btn btn-primary"
				href='<c:url value='/viewStudentsLibrarian/${lib.id }'></c:url>'
				role="button">View All Students</a> <a class="btn btn-primary"
				href='<c:url value='/viewBooksLibrarian/${lib.id }'></c:url>'
				role="button">View All Books</a> <a class="btn btn-primary"
				href='<c:url value='/viewIssuedBooksLibrarian/${lib.id }'></c:url>'
				role="button">View All Issued Books</a>
		</div>

		<!-- Condition - Success Book -->
		<c:if test="${not empty msg }">
			<div class="alert alert-success text-center mt-3">
				<c:out value="${msg }"></c:out>
			</div>
		</c:if>


		<div class="row text-center mt-4">

			<!-- //////////////////// Personal Details //////////////////// -->
			<div class="col-5">
				<h3 class="text-center">Personal Details</h3>
				<table class="table table-hover">
					<tr>
						<td>Id:</td>
						<td>${lib.id }</td>
					</tr>
					<tr>
						<td>Name:</td>
						<td>${lib.name }</td>
					</tr>
					<tr>
						<td>E-mail:</td>
						<td>${lib.email }</td>
					</tr>
					<tr>
						<td>Department:</td>
						<td>${lib.department }</td>
					</tr>
					<tr>
						<td>Gender:</td>
						<td>${lib.gender }</td>
					</tr>

					<tr>
						<td>Date of Joining:</td>
						<td>${lib.date }</td>
					</tr>
				</table>
				<div class="container text-center mt-3">
					<a href="${pageContext.request.contextPath }/librarianLogin"
						class="btn btn-outline-Danger">Log-Out</a> <a
						href="${pageContext.request.contextPath }/home"
						class="btn btn-outline-Warning">HOME</a>
				</div>
			</div>

			<!-- //////////////////////// Add Book Page //////////////////////// -->
			<!-- Add Book Form -->
			<div class="col-5 offset-1">
				<h3 class="text-center">
					<b>Add Book Form</b>
				</h3>
				<form action="addBook" method="post">

					<div class="form-row">
						<!-- Book Name -->
						<div class="form-group col-md-6">
							<label for="book-name">Book Name</label> <input type="text"
								class="form-control" id="book-name"
								placeholder="Enter Book Name" name="name" required>
						</div>
						<!-- Author's Name -->
						<div class="form-group col-md-6">
							<label for="author's-name">Author's Name</label> <input
								type="text" class="form-control" id="author's-name"
								placeholder="Enter Author's Name" name="authorName" required>
						</div>
					</div>

					<!-- Edition -->
					<div class="form-group">
						<label for="book's-edition">Edition</label> <input type="text"
							class="form-control" id="book's-edition"
							placeholder="Enter Edition" name="edition" required>
					</div>

					<!-- Description -->
					<div class="form-group">
						<label for="description">Description</label>
						<textarea class="form-control" id="description"
							placeholder="Enter Description" name="description" rows="5"></textarea>
					</div>

					<div class="container text-center">
						<button class="btn btn-outline-success">Add-Book</button>
					</div>
				</form>
			</div>

		</div>


	</div>
</body>
</html>
