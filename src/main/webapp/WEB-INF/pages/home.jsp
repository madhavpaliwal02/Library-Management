<html>
<head>

<%@include file="./base.jsp"%><%-- 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

<title><c:out value="${title }"></c:out></title>
</head>
<body>

	<div class="container mt-3">

		<h1 class="text-center">
			Welcome To The <b>Library Management</b> System
		</h1>

		<div class="row md-6 offset-3 mt-5">
			<div class="card text-center" style="width: 12rem;">
				<a href="adminHome" class="mt-3"><i
					class="fa-solid fa-5x fa-user-graduate"></i></a>
				<div class="card-body">
					<a href="adminHome" class="card-text">Admin</a>
				</div>
			</div>

			<div class="card text-center" style="width: 12rem;">
				<a href="librarianHome" class="mt-3"><i
					class="fa-solid fa-5x fa-user-graduate"></i></a>
				<div class="card-body">
					<a href="librarianHome" class="card-text">Librarian</a>
				</div>
			</div>

			<div class="card text-center" style="width: 12rem;">
				<a href="studentHome" class="mt-3"><i
					class="fa-solid fa-5x fa-user-graduate"></i></a>
				<div class="card-body">
					<a href="studentHome" class="card-text">Student</a>
				</div>
			</div>
		</div>

	</div>
</body>
</html>