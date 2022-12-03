<html>
<head>

<%@include file="./base.jsp"%>

<title><c:out value="${title }"></c:out></title>
<script type="text/javascript">
	function checkDelete(bid, sid) {
		/* Confirmation Message to be displayed */
		let ans = confirm("Are you sure you want to delete !!!");
		if (ans == true) {
			let ac = document.createElement("a")
			/* let stringUrl = `${pageContext.request.contextPath }/deleteLibrarian/`
					+ id; */
			ac.href = `${pageContext.request.contextPath }/returnBookDeleteAdmin/`
					+ bid + `/` + sid;
			ac.click();
			console.log('deleted')
		} else {
			console.log('no deleted')
		}
	}
</script>
</head>
<body>
	<!-- View Books -->
	<div class="container">
		<h1 class="text-center">
			<b>Books Returned by Students Details</b>
		</h1>

		<!-- Condition - success -->
		<c:if test="${not empty msg }">
			<div class="alert alert-success text-center">
				<c:out value="${msg }"></c:out>
			</div>
		</c:if>

		<table class="table table-hover text-center mt-3">
			<thead class="thead-dark">
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Book's Name</th>
					<th scope="col">Author's Name</th>
					<th scope="col">Book's Edition</th>
					<th scope="col">Student's Name</th>
					<th scope="col">Student's Roll No</th>
					<th scope="col">Student's Course</th>
					<th scope="col">Student's Gender</th>
					<th scope="col">Returned Date</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${rbook }" var="book">
					<tr>
						<th scope="row">${book.id }</th>
						<td>${book.bName }</td>
						<td>${book.author }</td>
						<td>${book.edition }</td>
						<td>${book.sName}</td>
						<td>${book.rollNo }</td>
						<td>${book.course }</td>
						<td>${book.gender }</td>
						<td>${book.date }</td>
						<c:if test="${user=='admin' }">
							<!-- Using JS -->
							<td><span
								onclick='return checkDelete(`${book.bid }`,`${book.sid }`)'
								href=""> <i class="fas fa-trash-can text-danger"
									style="font-size: 25px"> </i>
							</span></td>
						</c:if>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="container text-center">
			<c:if test="${user=='admin'  }">
				<a href="${pageContext.request.contextPath }/adminDashboardBack"
					class="btn btn-warning">Back</a>
			</c:if>
			<c:if test="${user=='librarian'  }">
				<a
					href="${pageContext.request.contextPath }/librarianDashboardBack/${lid }"
					class="btn btn-warning">Back</a>
			</c:if>

			<a href="${pageContext.request.contextPath }/home"
				class="btn btn-Danger">Home</a>
		</div>
	</div>
</body>
</html>