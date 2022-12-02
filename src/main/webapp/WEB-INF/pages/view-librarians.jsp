<html>
<head>

<%@include file="./base.jsp"%>

<title><c:out value="${title }"></c:out></title>

<!-- <script type="text/javascript">
	function checkDelete(id) {
		console.log("check delete");
		let ans = confirm("Are you sure you want to delete !!!");
		if (ans == true) {

			// fetch(URL,GET) - AXIOS

			let ac = document.createElement("a")
			let stringUrl = `${pageContext.request.contextPath }/deleteLibrarian/`
					+ id
			ac.href = stringUrl
			ac.click();
			console.log(id, stringUrl, `${pageContext.request.contextPath }`);
			console.log(ac);
		} else {
			console.log('no deleted')
		}
	}
</script> -->

</head>
<body>
	<!-- View Librarian -->
	<div class="container">
		<h1 class="text-center">
			<b>Registered Librarians Details</b>
		</h1>

		<table class="table table-hover text-center mt-3">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Department</th>
					<th scope="col">Gender</th>
					<th scope="col">Date</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${librarian }" var="lib">
					<tr>
						<th scope="row">${lib.id }</th>
						<td>${lib.name }</td>
						<td>${lib.email }</td>
						<td>${lib.department }</td>
						<td>${lib.gender }</td>
						<td>${lib.date }</td>

						<!-- Using JS -->
						<%-- <td><span onclick='return checkDelete(`${lib.id }`)' href="">
								<i class="fas fa-trash-can text-danger" style="font-size: 25px">
							</i>;
						</span></td> --%>

						<!-- Using BootStrap -->
						<td><a data-toggle="modal" data-target="#exampleModal"> <i
								class="fas fa-trash-can text-danger" style="font-size: 25px">
							</i>
						</a></td>

						<!-- Modal -->
						<div class="modal fade" id="exampleModal" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<!-- Header -->
									<div class="modal-header">
										<h2 class="modal-title text-center" id="exampleModalLabel">Delete</h2>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<!-- Body -->
									<div class="modal-body">
										<h5>Are you sure that you want to Delete the Record !!!</h5>
									</div>
									<!-- Footer -->
									<div class="modal-footer">
										<a class="btn btn-outline-Danger"
											href="${pageContext.request.contextPath }/deleteLibrarian/${lib.id }">
											Delete</a>
										<button type="button" data-dismiss="modal"
											class="btn btn-outline-Warning">Cancel</button>
									</div>
								</div>
							</div>
						</div>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="container text-center">
			<a href="${pageContext.request.contextPath }/adminDashboardBack"
				class="btn btn-warning">Back</a> <a
				href="${pageContext.request.contextPath }/home"
				class="btn btn-Danger">Home</a>
		</div>
	</div>
</body>
</html>