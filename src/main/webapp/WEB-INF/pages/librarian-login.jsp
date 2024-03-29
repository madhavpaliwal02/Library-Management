<html>
<head>

<%@include file="./base.jsp"%>

<title><c:out value="${title }"></c:out></title>
</head>
<body>

	<div class="container mt-3">

		<!-- Heading -->
		<h1 class="text-center">
			Welcome To The <b>Librarian Page</b>
		</h1>

		<!-- Navigation Button -->
		<div class="text-center mt-3">
			<a class="btn btn-primary"
				href='<c:url value='/librarianLogin'></c:url>' role="button">Librarian
				Login </a> <a class="btn btn-primary"
				href='<c:url value='/librarianSignupForm'></c:url>' role="button">Librarian
				SignUp </a>
		</div>

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

		<!-- Log In Page -->
		<div class="row">
			<div class="col-md-6 m-auto">
				<c:if test="${librarianPage=='librarianLoginForm' }">
					<div class="container mt-5">
						<h3 class="text-center">
							<b>Librarian Login Form</b>
						</h3>
						<form action="librarianDashboard" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									placeholder="Enter email" name="email" required> <small
									id="emailHelp" class="form-text text-muted">We'll never
									share your email with anyone else.</small>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									placeholder="Password" name="password" required>
							</div>
							<div class="container text-center">
								<a href="home" class="btn btn-Warning">Back</a>
								<button class="btn btn-success">Log-In</button>
							</div>
						</form>
					</div>
				</c:if>
			</div>
		</div>

		<!-- Sign Up Page -->
		<div class="row">
			<div class="col-md-6 m-auto">
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
										id="emailHelp" class="form-text text-muted">We'll
										never share your email with anyone else.</small>
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
										id="male" value="Male"> <label
										class="form-check-label" for="male">Male</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="gender"
										id="female" value="Female"> <label
										class="form-check-label" for="female">Female</label>
								</div>
							</div>

							<div class="container text-center">
								<a href="home" class="btn btn-Warning">Back</a>
								<button class="btn btn-success">Sign-Up</button>
							</div>
						</form>
					</div>
				</c:if>
			</div>
		</div>

	</div>
</body>
</html>