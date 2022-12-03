<html>
<head>

<%@include file="./base.jsp"%>

<title><c:out value="${title }"></c:out></title>
<script type="text/javascript">
	/* Book Delete Admin */
	function bookDeleteAdmin(bid) {
		/* Confirmation Message to be displayed */
		let ans = confirm("Are you sure you want to delete !!!");
		if (ans == true) {
			let ac = document.createElement("a")
			let stringUrl = `${pageContext.request.contextPath }/bookDeleteAdmin/`
					+ bid;
			ac.href = stringUrl;
			ac.click();
			console.log('deleted')
		} else {
			console.log('no deleted')
		}
	}
	/* Book Delete Librarian */
	function bookDeleteLibrarian(lid, bid) {
		/* Confirmation Message to be displayed */
		let ans = confirm("Are you sure you want to delete !!!");
		if (ans == true) {
			let ac = document.createElement("a")
			let stringUrl = `${pageContext.request.contextPath }/bookDeleteLibrarian/`
					+ lid + `/` + bid;
			ac.href = stringUrl;
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
			<b>Registered Books Availability Details</b>
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
					<th scope="col">Author's Name</th>
					<th scope="col">Edition</th>
					<th scope="col">Description</th>
					<th scope="col">Count</th>
					<th scope="col">Date</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${book }" var="book">
					<tr>
						<th scope="row">${book.id }</th>
						<td>${book.name }</td>
						<td>${book.authorName }</td>
						<td>${book.edition}</td>
						<td>${book.description }</td>
						<td>${book.count }</td>
						<td>${book.date }</td>

						<c:if test="${user=='admin' }">
							<!-- Using JS -->
							<td><span onclick='return bookDeleteAdmin(`${book.id }`)'
								href=""> <i class="fas fa-trash-can text-danger"
									style="font-size: 25px"> </i>
							</span></td>
						</c:if>

						<c:if test="${user=='librarian' }">
							<!-- Using JS -->
							<td><span
								onclick='return bookDeleteLibrarian(`${lid }`, `${book.id }`)'
								href=""> <i class="fas fa-trash-can text-danger"
									style="font-size: 25px"> </i>
							</span></td>
						</c:if>

						<c:if test="${user=='student' }">
							<td><a
								href="${pageContext.request.contextPath }/issuedBook/${sid }/${book.id }">
									<i class="fas fa-book" style="font-size: 25px"> </i>
							</a></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="container text-center">
			<c:if test="${user=='admin' }">
				<a href="${pageContext.request.contextPath }/adminDashboardBack"
					class="btn btn-warning">Back</a>
			</c:if>
			<c:if test="${user=='librarian' }">
				<a
					href="${pageContext.request.contextPath }/librarianDashboardBack/${lid }"
					class="btn btn-warning">Back</a>
			</c:if>
			<c:if test="${user=='student' }">
				<a
					href="${pageContext.request.contextPath }/studentDashboardBack/${sid }"
					class="btn btn-warning">Back</a>
			</c:if>

			<a href="${pageContext.request.contextPath }/home"
				class="btn btn-Danger">Home</a>
		</div>
	</div>
</body>
</html>