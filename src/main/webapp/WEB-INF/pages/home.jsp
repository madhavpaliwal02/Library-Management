<html>
<head>

<%@include file="./base.jsp"%>

<title><c:out value="${title }"></c:out></title>

<style>
.center {
	display: block;
	margin-left: auto;
	margin-right: auto;
	width: 12%;
}

.card-body a {
	text-decoration: none;
}

.card-text {
	font-size: 1.5rem;
}
</style>

</head>
<body>

	<div class="container mt-4">

		<div>
			<img class="center" alt=""
				src="data:image/jpeg;base64,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">
		</div>
		<div class="text-center">
			<h1>
				Welcome To The <i><b>LIMSY</b></i>
			</h1>
			<h4>A Library Management System</h4>
		</div>

		<div class="row justify-content-around mt-5">
			<!-- Admin Card -->
			<div class="card text-center col-3" style="width: 8rem;">
				<a href="${pageContext.request.contextPath }/adminLogin"
					class="mt-3"><i class="fa-solid fa-5x fa-user-graduate"></i></a>
				<div class="card-body">
					<a href="${pageContext.request.contextPath }/adminLogin"
						class="card-text">Admin</a>
				</div>
			</div>
			<!-- Librarian Card -->
			<div class="card text-center col-3" style="width: 8rem;">
				<a href="${pageContext.request.contextPath }/librarianLogin"
					class="mt-3"><i class="fa-solid fa-5x fa-user-graduate"></i></a>
				<div class="card-body">
					<a href="${pageContext.request.contextPath }/librarianLogin"
						class="card-text">Librarian</a>
				</div>
			</div>
			<!-- Student Card -->
			<div class="card text-center col-3" style="width: 8rem;">
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
