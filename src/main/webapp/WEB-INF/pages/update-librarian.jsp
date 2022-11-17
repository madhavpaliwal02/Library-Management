
<html>
<head>

<%@include file="./base.jsp"%>

<title>Update Librarian</title>
</head>
<body>
	<div class="container">
		<!-- Sign Up Page -->
		<div class="container mt-5">
			<h3 class="text-center">
				<b>Librarian Update Form</b>
			</h3>
			<form
				action="${pageContext.request.contextPath }/updateLibrarian"
				method="post">
				<input type="text" name="id" value="${librarian.id }" hidden>
				<div class="form-row">
					<!-- Librarian Name -->
					<div class="form-group col-md-6">
						<label for="librarian-name">Librarian Name</label> <input
							type="text" class="form-control" id="librarian-name"
							value="${librarian.name }" name="name">
					</div>
					<!-- Department -->
					<div class="form-group col-md-6">
						<label for="librarian-department">Department</label> <input
							type="text" class="form-control" id="librarian-department"
							value="${librarian.department }" name="department">
					</div>
				</div>

				<div class="form-row">
					<!-- Email -->
					<div class="form-group col-md-6">
						<label for="librarian-email">Email address</label> <input
							type="email" class="form-control" id="librarian-email"
							value="${librarian.email }" name="email"> <small
							id="emailHelp" class="form-text text-muted">We'll never
							share your email with anyone else.</small>
					</div>
					<!-- Password -->
					<div class="form-group col-md-6">
						<label for="librarian-password">Password</label> <input
							type="password" class="form-control" id="librarian-password"
							value="${librarian.password }" name="password">
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
					<a
						href="${pageContext.request.contextPath }/librarianDashboardBack/${librarian.id }"
						class="btn btn-outline-Warning">Back</a>
					<button class="btn btn-outline-success">Update</button>
					<a href="${pageContext.request.contextPath }/home"
						class="btn btn-outline-Warning">Home</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>