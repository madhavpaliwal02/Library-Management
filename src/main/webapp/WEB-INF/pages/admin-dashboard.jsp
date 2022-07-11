<html>
<head>

<%@include file="./base.jsp"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

<title><c:out value="${title }"></c:out></title>
</head>
<body>

	<div class="container mt-3">

		<h1 class="text-center">
			Welcome To The <b>Admin DashBoard</b>
		</h1>

		<!-- Navigation Button -->
		<div class="text-center mt-3">
			<a class="btn btn-primary"
				href='<c:url value='/viewLibrarians'> </c:url>' role="button">View
				Librarians</a> <a class="btn btn-primary"
				href='<c:url value='/viewStudents'> </c:url>' role="button">View
				Students</a> <a class="btn btn-primary"
				href='<c:url value='/viewBooks'> </c:url>' role="button">View
				Books</a><a class="btn btn-primary"
				href='<c:url value='/viewIssuedBooks'> </c:url>' role="button">View
				Issued Books</a>
		</div>

		

		</div>





	</div>
</body>
</html>