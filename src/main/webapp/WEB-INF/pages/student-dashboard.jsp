<html>
<head>

<%@include file="./base.jsp"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

<title><c:out value="${title }"></c:out></title>
</head>
<body>

	<div class="container mt-3">

		<h1 class="text-center">
			Welcome To The <b>Student DashBoard</b>
		</h1>

		<!-- Navigation Button -->
		<div class="text-center mt-2">
			<a class="btn btn-primary"
				href='<c:url value='/viewBookStu'> </c:url>' role="button">View
				Books</a> <a class="btn btn-primary"
				href='<c:url value='/returnBook'> </c:url>' role="button">Return
				Books</a>
		</div>

		<div class="row text-center">
			<div class="col-5">
				<h3 class="text-center">Personal Details</h3>
				

			</div>
			<div class="col-5 offset-2">
				<h3 class="text-center">Issued Books</h3>

			</div>
		</div>


		<div class="container text-center mt-3">
			<a href="studentHome" class="btn btn-outline-Danger">Log-Out</a> <a
				href="home" class="btn btn-outline-Danger">HOME</a>
		</div>

	</div>
</body>
</html>