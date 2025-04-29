<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Incomes | List Incomes</title>

<jsp:include page="AdminCss.jsp"></jsp:include>


<link  href="https://cdn.datatables.net/2.2.2/css/dataTables.bootstrap5.min.css" rel="stylesheet"/>


</head>
<body>
	<jsp:include page="UserHeader.jsp"></jsp:include>

	<jsp:include page="UserSidebar.jsp"></jsp:include>

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>List Incomes</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="userdashboard">Home</a></li>
					<li class="breadcrumb-item">Incomes</li>
					<li class="breadcrumb-item active">List Incomes</li>
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
										Incomes<span>/all</span>
									</h5>


									<table class="table datatable datatable-table table-hover" id="myTable">
										<thead>
											<tr>
												<th>Title</th>
												<th>Amount</th>
												<th>Account</th>
												<th>TranscationDate</th>
												<th>Description</th>
												<th>Action</th>
											</tr>
										</thead>

										<tbody>
											<c:forEach items="${incomes}" var="i">
												<tr>
													<td>${i[5]}</td>
													<td>${i[1]}</td>
													<td>${i[8]}</td>
													<td>${i[6]}</td>
													<td>${i[3]}</td>				
													<td><a href="viewincome?incomeId=${i[0]}">View</a> | <a href="userdeleteincome?incomeId=${i[0]}">Delete</a> | <a href="usereditincome?incomeId=${i[0]}">Edit</a> </td>
				
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