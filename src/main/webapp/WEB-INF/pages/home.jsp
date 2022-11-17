<html>
<head>

<%@include file="./base.jsp"%><%-- 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

<title><c:out value="${title }"></c:out></title>
</head>
<body>

	<div class="container mt-3">

		<div class="text-center">
			<h1>
				Welcome To The <b>LIMSY</b>
			</h1>
			<h4>A Library Management System</h4>
		</div>

		<div class="row md-6 offset-3 mt-5">
			<!-- Admin Card -->
			<div class="card text-center" style="width: 12rem;">
				<a href="${pageContext.request.contextPath }/adminLogin"
					class="mt-3"><i class="fa-solid fa-5x fa-user-graduate"></i></a>
				<div class="card-body">
					<a href="${pageContext.request.contextPath }/adminLogin"
						class="card-text">Admin</a>
				</div>
			</div>
			<!-- Librarian Card -->
			<div class="card text-center" style="width: 12rem;">
				<a href="${pageContext.request.contextPath }/librarianLogin"
					class="mt-3"><i class="fa-solid fa-5x fa-user-graduate"></i></a>
				<div class="card-body">
					<a href="${pageContext.request.contextPath }/librarianLogin"
						class="card-text">Librarian</a>
				</div>
			</div>
			<!-- Student Card -->
			<div class="card text-center" style="width: 12rem;">
				<a href="${pageContext.request.contextPath }/studentLogin"
					class="mt-3"><i class="fa-solid fa-5x fa-user-graduate"></i></a>
				<div class="card-body">
					<a href="${pageContext.request.contextPath }/studentLogin"
						class="card-text">Student</a>
				</div>
			</div>
		</div>

	</div>
</body>
</html>
