<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List User</title>
</head>
<body>
<h2>List User</h2>

	<table border="1">
		<c:forEach items="${userList}" var="u">

			<tr>
				<td>${u.firstName }</td>
				<td>${u.lastName}</td>
				<td>${u.email }</td>
			    <td>${u.password }</td>
			    <td>${u.gender }</td>
			    <td>${u.contactNum }</td>
				
			</tr>
		</c:forEach>
	</table>

</body>
</html> --%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Users | List Users</title>

<jsp:include page="AdminCss.jsp"></jsp:include>


<link  href="https://cdn.datatables.net/2.2.2/css/dataTables.bootstrap5.min.css" rel="stylesheet"/>


</head>
<body>
	<jsp:include page="AdminHeader.jsp"></jsp:include>

	<jsp:include page="AdminSidebar.jsp"></jsp:include>

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>List Users</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="admindashboard">Home</a></li>
					 <li class="breadcrumb-item">Users</li>
					<li class="breadcrumb-item active">List Users</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row" style="min-height: 467px;">

				<!-- Left side columns -->
				<div class="col-lg-12">
					<div class="row">
						<!-- Reports -->
						<div class="col-12">
							<div class="card">


								<div class="card-body">
									<h5 class="card-title">
										Users<span>/all</span>
									</h5>


									<table class="table datatable datatable-table table-hover" id="myTable">
									
										<thead>
											<tr>
												<th>UserId</th>
												<th>First Name</th>
												<th>Last Name</th>
												<th>Email</th>
												<th>Role</th>
												<th>Gender</th>
												<th>Contact No</th>
												<th>Action</th>
											</tr>
										</thead>

										<tbody>
											<c:forEach items="${userList}" var="u">
												<tr>
												<td>${u.userId }</td>
												<td>${u.firstName }</td>
												<td>${u.lastName}</td>
												<td>${u.email }</td>
			    								<td>${u.role }</td>
			    								<td>${u.gender }</td>
			    								<td>${u.contactNum }</td>
													<td><a href="adminviewuser?userId=${u.userId}">View</a> | <a href="admindeleteuser?userId=${u.userId}">Delete</a> | Edit </td>
				
												</tr>
											</c:forEach>
										</tbody>

									</table>
									


								</div>

							</div>
						</div>
						<!-- End Reports -->

					</div>
				</div>
				<!-- End Left side columns -->

				<!-- Right side columns -->
				<!-- End Right side columns -->

			</div>
		</section>

	</main>
	<!-- main content end  -->


	<jsp:include page="AdminFooter.jsp"></jsp:include>

	<jsp:include page="AdminJs.jsp"></jsp:include>
	
	

	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

	<script src="https://cdn.datatables.net/2.2.2/js/dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/2.2.2/js/dataTables.bootstrap5.min.js"></script>

	<script type="text/javascript">

	$( document ).ready(function() {
		let table = new DataTable('#myTable');
	});
	</script>

</body>
</html>