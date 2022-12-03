<html>
<head>

<%@include file="./base.jsp"%>

<title><c:out value="${title }"></c:out></title>

<script type="text/javascript">
	function studentDeleteAdmin(sid) {
		/* Confirmation Message to be displayed */
		let ans = confirm("Are you sure you want to delete !!!");
		if (ans == true) {
			let ac = document.createElement("a");
			let stringUrl = `${pageContext.request.contextPath }/studentDeleteAdmin/`
					+ sid;
			ac.href = stringUrl;
			ac.click();
			console.log('deleted')
		} else {
			console.log('no deleted')
		}
	}

	function studentDeleteLibrarian(lid, sid) {
		/* Confirmation Message to be displayed */
		let ans = confirm("Are you sure you want to delete !!!");
		if (ans == true) {
			let ac = document.createElement("a");
			ac.href = `${pageContext.request.contextPath }/studentDeleteLibrarian/`
					+ lid + `/` + sid;
			ac.click();
			console.log('deleted')
		} else {
			console.log('no deleted')
		}
	}
</script>

</head>
<body>
	<!-- View Students -->
	<div class="container">
		<h1 class="text-center">
			<b>Registered Students Details</b>
		</h1>

		<!-- Condition - success -->
		<div class="container mt-2">
			<c:if test="${not empty msg }">
				<c:if test="${msg == 'failed' }">
					<div class="alert alert-danger text-center">
						<c:out value="${cause }" />
					</div>
				</c:if>
				<c:if test="${msg == 'success' }">
					<div class="alert alert-success text-center">
						<c:out value="${cause }" />
					</div>
				</c:if>
			</c:if>
		</div>

		<table class="table table-hover text-center mt-3">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">Roll NO</th>
					<th scope="col">Email</th>
					<th scope="col">Course</th>
					<th scope="col">Gender</th>
					<th scope="col">Date</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${student }" var="stu">
					<tr>
						<th scope="row">${stu.id }</th>
						<td>${stu.name }</td>
						<td>${stu.rollno }</td>
						<td>${stu.email }</td>
						<td>${stu.course }</td>
						<td>${stu.gender }</td>
						<td>${stu.date }</td>

						<c:if test="${user=='admin' }">

							<!-- Using JS -->
							<td><span onclick='return studentDeleteAdmin(`${stu.id }`)'
								href=""> <i class="fas fa-trash-can text-danger"
									style="font-size: 25px"> </i>
							</span></td>
						</c:if>
						<c:if test="${user=='librarian' }">
							<!-- Using JS -->
							<td><span
								onclick='studentDeleteLibrarian(`${lid }`,`${stu.id }`)'>
									<i class="fas fa-trash-can text-danger" style="font-size: 25px">
								</i>
							</span></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- Navigation Button -->
		<div class="container text-center">
			<c:if test="${user=='admin' }">
				<a href="${pageContext.request.contextPath }/adminDashboardBack"
					class="btn btn-warning">Back</a>
			</c:if>
			<c:if test="${user=='librarian' }">
				<a href="${pageContext.request.contextPath }/${value }/${lid }"
					class="btn btn-warning">Back</a>
			</c:if>
			<a href="${pageContext.request.contextPath }/home"
				class="btn btn-Danger">Home</a>
		</div>
	</div>
</body>
</html>