<html>
<head>

<%@include file="./base.jsp"%>

<title><c:out value="${title }"></c:out></title>
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

							<td><a data-toggle="modal" data-target="#exampleModal">
									<i class="fas fa-trash-can text-danger" style="font-size: 25px">
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
												href="${pageContext.request.contextPath }/studentDeleteAdmin/${stu.id }">
												Delete</a>
											<button type="button" data-dismiss="modal"
												class="btn btn-outline-Warning">Cancel</button>
										</div>
									</div>
								</div>
							</div>
						</c:if>
						<c:if test="${user=='librarian' }">
							<td><a data-toggle="modal" data-target="#exampleModal">
									<i class="fas fa-trash-can text-danger" style="font-size: 25px">
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
												href="${pageContext.request.contextPath }/studentDeleteLibrarian/${lid }/${stu.id }">
												Delete</a>
											<button type="button" data-dismiss="modal"
												class="btn btn-outline-Warning">Cancel</button>
										</div>
									</div>
								</div>
							</div>
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
				<a href="${pageContext.request.contextPath }/${value }/${lid }"
					class="btn btn-warning">Back</a>
			</c:if>
			<a href="${pageContext.request.contextPath }/home"
				class="btn btn-Danger">Home</a>
		</div>
	</div>
</body>
</html>