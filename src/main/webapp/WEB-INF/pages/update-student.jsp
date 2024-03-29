<html>
<head>

<%@include file="./base.jsp"%>

<title><c:out value="${title }"></c:out></title>
</head>
<body>
	<div class="container mt-5">
		<h2 class="text-center">
			<b>Student Update Form</b>
		</h2>
		<div class="row">
			<div class="col-md-6 m-auto">
				<form action="${pageContext.request.contextPath }/updateStudent"
					method="post">

					<input type="text" name="id" value="${stu.id }" hidden>
					<div class="form-row">
						<!-- Student Name -->
						<div class="form-group col-md-6">
							<label for="student-name">Student Name</label> <input type="text"
								class="form-control" id="student-name" placeholder="Enter Name"
								name="name" value="${stu.name }">
						</div>
						<!-- Roll No -->
						<div class="form-group col-md-6">
							<label for="student-rollno">Roll NO</label> <input type="text"
								class="form-control" id="student-rollno"
								placeholder="Enter Roll No (IT-2KXX-XX)" name="rollno"
								value="${stu.rollno }">
						</div>
					</div>

					<div class="form-row">
						<!-- Email -->
						<div class="form-group col-md-6">
							<label for="student-email">Email address</label> <input
								type="email" class="form-control" id="student-email"
								placeholder="Enter email" name="email" value="${stu.email }">
							<small id="emailHelp" class="form-text text-muted">We'll
								never share your email with anyone else.</small>
						</div>
						<!-- Password -->
						<div class="form-group col-md-6">
							<label for="student-password">Password</label> <input
								type="password" class="form-control" id="student-password"
								placeholder="Password" name="password" value="${stu.password }">
						</div>
					</div>
					<div class="form-group">
						<label for="student-course">Course</label> <input type="text"
							class="form-control" id="student-course" placeholder="Course"
							name="course" value="${stu.course }">
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
							href="${pageContext.request.contextPath }/studentDashboardBack/${stu.id }"
							class="btn btn-Warning">Back</a> <a
							href="${pageContext.request.contextPath }/home"
							class="btn btn-Danger">Home</a>
						<button class="btn btn-success">Update</button>
					</div>
				</form>
			</div>
		</div>
	</div>


</body>
</html>