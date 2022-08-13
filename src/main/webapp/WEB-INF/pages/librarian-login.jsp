<html>
<head>

<%@include file="./base.jsp"%><%-- 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

<title><c:out value="${title }"></c:out></title>
</head>
<body>

	<div class="container">
		<h1 class="text-center">Welcome Librarian</h1>

		<!-- Navigation Button -->
		<div class="text-center mt-3">
			<a class="btn btn-primary"
				href='<c:url value='/librarianLogin'></c:url>' role="button">Login
				Librarian</a> <a class="btn btn-primary"
				href='<c:url value='/librarianSignupForm'></c:url>' role="button">SignUp
				Librarian</a>
		</div>

		<!-- Condition - success -->
		<c:if test="${not empty msg }">
			<div class="alert alert-success text-center">
				<c:out value="${msg }"></c:out>
			</div>
		</c:if>

		<!-- Log In Page -->
		<c:if test="${librarianPage=='librarianLogin' }">
			<div class="container mt-5">
				<h3 class="text-center">
					<b>Librarian Login Form</b>
				</h3>
				<form action="librarianDashboard" method="post">
					<div class="form-group">
						<label for="exampleInputEmail1">Email address</label> <input
							type="email" class="form-control" id="exampleInputEmail1"
							placeholder="Enter email" name="email" required>
						<small id="emailHelp" class="form-text text-muted">We'll
							never share your email with anyone else.</small>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> <input
							type="password" class="form-control" id="exampleInputPassword1"
							placeholder="Password" name="password" required>
					</div>
					<div class="container text-center">
						<button class="btn btn-outline-success">Log-In</button>
					</div>
				</form>
			</div>
		</c:if>

		<!-- Sign Up Page -->
		<c:if test="${librarianPage=='librarianSignupForm' }">
			<div class="container mt-5">
				<h3 class="text-center">
					<b>Librarian Signup Form</b>
				</h3>
				<form action="librarianSignup" method="post">

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
						<button class="btn btn-outline-success">Sign-Up</button>
					</div>
				</form>
			</div>
		</c:if>

		<div class="container text-center mt-3">
			<a href="home" class="btn btn-outline-Warning">Back</a>
		</div>
	</div>
</body>
</html>