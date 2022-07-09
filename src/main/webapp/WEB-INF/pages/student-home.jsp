<html>
<head>

<%@include file="./base.jsp"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

<title>Home Page</title>
</head>
<body>

	<div class="container mt-3">

		<h1 class="text-center">
			Welcome To The <b>Student Page</b>
		</h1>

		<!-- Navigation Button -->
		<div class="text-center mt-5">
			<a class="btn btn-primary"
				href='<c:url value='/studentLoginForm'></c:url>' role="button">LogIn</a>
			<a class="btn btn-primary"
				href='<c:url value='/studentSignupForm'></c:url>' role="button">SignUp</a>
		</div>


		<!-- Log In Page -->
		<c:if test="${studentPage=='studentLoginForm' }">
			<div>
				<form:form action="" method="post" modelAttribute="student">
					<div class="form-group">
						<label for="exampleInputEmail1">Email address</label> <input
							type="email" class="form-control" id="exampleInputEmail1"
							placeholder="Enter email" name="student-email" required>
						<small id="emailHelp" class="form-text text-muted">We'll
							never share your email with anyone else.</small>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> <input
							type="password" class="form-control" id="exampleInputPassword1"
							placeholder="Password" name="student-password" required>
					</div>
					<div class="container text-center">
						<button class="btn btn-outline-success">Login</button>
					</div>
				</form:form>
			</div>
		</c:if>

		<!-- Sign Up Page -->
		<c:if test="${studentPage=='studentSignupForm' }">
			<div>
				<form:form action="signupStudent" method="post"
					modelAttribute="student">
					<div class="form-group">
						<label for="exampleInputName">Student Name</label> <input
							type="text" class="form-control" id="exampleInputName"
							placeholder="Enter Name">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Email address</label> <input
							type="email" class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" placeholder="Enter email"> <small
							id="emailHelp" class="form-text text-muted">We'll never
							share your email with anyone else.</small>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> <input
							type="password" class="form-control" id="exampleInputPassword1"
							placeholder="Password">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> <input
							type="password" class="form-control" id="exampleInputPassword1"
							placeholder="Password">
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio"
							name="gender" id="male" value="Male">
						<label class="form-check-label" for="male">Male</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio"
							name="gender" id="female" value="Female">
						<label class="form-check-label" for="female">Female</label>
					</div>

					<div class="container text-center">
						<button class="btn btn-outline-success">Login</button>
					</div>
				</form:form>
			</div>
		</c:if>


	</div>
</body>
</html>