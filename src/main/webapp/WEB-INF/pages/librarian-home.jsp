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
				href='<c:url value='/addLibrarianForm'></c:url>' role="button">Add
				Librarian</a> <a class="btn btn-primary"
				href='<c:url value='/viewStudents'></c:url>' role="button">View
				Students</a> <a class="btn btn-primary"
				href='<c:url value='/viewBooks'></c:url>' role="button">View
				Books</a> <a class="btn btn-primary"
				href='<c:url value='/viewIssuedBooks'></c:url>' role="button">View
				Books</a>
			<%-- <a class="btn btn-primary"
				href='<c:url value='/studentSignupForm'></c:url>' role="button">SignUp</a> --%>
		</div>
	</div>
</body>
</html>