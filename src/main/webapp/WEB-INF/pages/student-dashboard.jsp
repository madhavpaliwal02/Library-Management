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
			<a class="btn btn-primary" href='<c:url value='/viewBooks'> </c:url>'
				role="button">View Books</a> <a class="btn btn-primary"
				href='<c:url value='/issueBook'> </c:url>' role="button">Issue
				Book</a> <a class="btn btn-primary"
				href='<c:url value='/viewBooks'> </c:url>' role="button">Return
				Books</a>
		</div>



	</div>
</body>
</html>