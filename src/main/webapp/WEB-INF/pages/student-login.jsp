<html>
<head>

<%@include file="./base.jsp"%>

<title><c:out value="${title }"></c:out></title>
</head>
<body>

	<div class="container mt-3">

		<!-- Heading -->
		<h1 class="text-center">
			Welcome To The <b>Student Page</b>
		</h1>

		<!-- Navigation Button -->
		<div class="text-center mt-3">
			<a class="btn btn-primary"
				href='<c:url value='/studentLogin'></c:url>' role="button">Student
				LogIn</a> <a class="btn btn-primary"
				href='<c:url value='/studentSignupForm'></c:url>' role="button">Student
				SignUp</a>
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
		<c:if test="${studentPage=='studentLoginForm' }">
			<div class="container mt-5">
				<h3 class="text-center">
					<b>Student Login Form</b>
				</h3>
				<form action="${pageContext.request.contextPath }/studentDashboard"
					method="post">
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
						<a href="${pageContext.request.contextPath }/home"
							class="btn btn-Warning">Back</a>
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
				<c:if test="${studentPage=='studentSignupForm' }">
					<div class="container mt-5">
						<h3 class="text-center">
							<b>Student Signup Form</b>
						</h3>
						<form action="${pageContext.request.contextPath }/studentSignup"
							method="post">

							<div class="form-row">
								<!-- Student Name -->
								<div class="form-group col-md-6">
									<label for="student-name">Student Name</label> <input
										type="text" class="form-control" id="student-name"
										placeholder="Enter Name" name="name">
								</div>
								<!-- Roll No -->
								<div class="form-group col-md-6">
									<label for="student-rollno">Roll NO</label> <input type="text"
										class="form-control" id="student-rollno"
										placeholder="Enter Roll No (IT-2KXX-XX)" name="rollno">
								</div>
							</div>

							<div class="form-row">
								<!-- Email -->
								<div class="form-group col-md-6">
									<label for="student-email">Email address</label> <input
										type="email" class="form-control" id="student-email"
										placeholder="Enter email" name="email"> <small
										id="emailHelp" class="form-text text-muted">We'll
										never share your email with anyone else.</small>
								</div>
								<!-- Password -->
								<div class="form-group col-md-6">
									<label for="student-password">Password</label> <input
										type="password" class="form-control" id="student-password"
										placeholder="Password" name="password">
								</div>
							</div>
							<div class="form-group">
								<label for="student-course">Course</label> <input type="text"
									class="form-control" id="student-course" placeholder="Course"
									name="course">
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
								<a href="${pageContext.request.contextPath }/home"
									class="btn btn-Warning">Back</a>
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