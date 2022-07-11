<html>
<head>

<%@include file="./base.jsp"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

<title><c:out value="${title }"></c:out></title>
</head>
<body>

	<div class="container mt-3">

		<h1 class="text-center">
			Welcome To The <b>Admin DashBoard</b>
		</h1>

		<!-- Navigation Button -->
		<div class="text-center mt-3">
			<a class="btn btn-primary"
				href='<c:url value='/viewLibrarians'> </c:url>' role="button">View
				Librarians</a> <a class="btn btn-primary"
				href='<c:url value='/viewStudents'> </c:url>' role="button">View
				Students</a> <a class="btn btn-primary"
				href='<c:url value='/viewBooks'> </c:url>' role="button">View
				Books</a><a class="btn btn-primary"
				href='<c:url value='/viewIssuedBooks'> </c:url>' role="button">View
				Issued Books</a>
		</div>

		<!-- Condition - success -->
		<c:if test="${not empty msg }">
			<div class="alert alert-success text-center">
				<c:out value="${msg }"></c:out>
			</div>
		</c:if>


		<!-- Sign Up Page -->
		<c:if test="${adminPage=='addLibrarianForm' }">
			<div class="container mt-5">
				<h3 class="text-center">
					<b>Librarian Signup Form</b>
				</h3>
				<form action="signupLibrarian" method="post">

					<div class="form-row">
						<!-- Librarian Name -->
						<div class="form-group col-md-6">
							<label for="librarian-name">Librarian Name</label> <input
								type="text" class="form-control" id="librarian-name"
								placeholder="Enter Name" name="name">
						</div>
						<!-- Department -->
						<div class="form-group col-md-6">
							<label for="librarian-department">Department</label> <input
								type="text" class="form-control" id="librarian-department"
								placeholder="Enter Department" name="department">
						</div>
					</div>

					<div class="form-row">
						<!-- Email -->
						<div class="form-group col-md-6">
							<label for="librarian-email">Email address</label> <input
								type="email" class="form-control" id="librarian-email"
								placeholder="Enter email" name="email"> <small
								id="emailHelp" class="form-text text-muted">We'll never
								share your email with anyone else.</small>
						</div>
						<!-- Password -->
						<div class="form-group col-md-6">
							<label for="librarian-password">Password</label> <input
								type="password" class="form-control" id="librarian-password"
								placeholder="Password" name="password">
						</div>
					</div>
					<div class="form-group">
						<span class="mr-3">Gender</span>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="gender"
								id="male" value="Male"> <label class="form-check-label"
								for="male">Male</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="gender"
								id="female" value="Female"> <label
								class="form-check-label" for="female">Female</label>
						</div>
					</div>

					<div class="container text-center">
						<a href="home" class="btn btn-outline-Danger">Back</a>
						<button class="btn btn-outline-success">Login</button>

					</div>
				</form>
			</div>
		</c:if>


	</div>
</body>
</html>