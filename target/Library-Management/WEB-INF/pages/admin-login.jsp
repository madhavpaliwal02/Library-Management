<html>
<head>

<%@include file="./base.jsp"%><%-- 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

<title><c:out value="${title }"></c:out></title>
</head>
<body>

	<div class="container mt-5">
		<h1 class="text-center">Welcome Admin</h1>
		<h3 class="text-center">
			<b>Admin Login Form</b>
		</h3>
		<form action="adminDashboard" method="post">
		<c:if test="${msg!='' }"><p class="text-center alert alert-danger">${msg }</p></c:if>
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
				<a href="home" class="btn btn-outline-Danger">Back</a>
				<button class="btn btn-outline-success">Login</button>
			</div>
		</form>
	</div>
</body>
</html>