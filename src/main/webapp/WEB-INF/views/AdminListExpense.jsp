 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 <%-- 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Expense</title>
</head>
<body>
<h2>List Expense</h2>

	<table border="1">
<tr>
			<th>Title</th>
			<th>Amount</th>
			<th>TransactionDate</th>
			<th>Description</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${incomeList}" var="i">
			<tr>
				<td>${i.title }</td>
				<td>${i.amount}</td>
				<td>${i.transactionDate }</td>
			    <td>${i.description }</td>
				
			</tr>
		</c:forEach>
	</table>


</body>
</html> --%>






<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Expenses | List Expenses</title>

<jsp:include page="AdminCss.jsp"></jsp:include>


<link  href="https://cdn.datatables.net/2.2.2/css/dataTables.bootstrap5.min.css" rel="stylesheet"/>


</head>
<body>
	<jsp:include page="AdminHeader.jsp"></jsp:include>

	<jsp:include page="AdminSidebar.jsp"></jsp:include>

	<main id="main" class="main">

		<div class="pagetitle">
			<h1>List Expenses</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="admindashboard">Home</a></li>
					<li class="breadcrumb-item">Expenses</li>
					<li class="breadcrumb-item active">List Expenses</li>
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
										Expenses<span>/all</span>
									</h5>


									<table class="table datatable datatable-table table-hover" id="myTable">
									
										<thead>
											<tr>
												<th>Expense Title</th>
												<th>Category</th>
												<th>SubCategory</th>
												<th>Vendor</th>
												<th>Account</th>
												<th>Status</th>
												<th>Amount</th>
												<th>Date</th>
												<th>Description</th>
												<th>User</th>
												<th>Action</th>
											</tr>
										</thead>

										<tbody>
											<c:forEach items="${expenseList		}" var="e">
												<tr>
													<td>${e[1]}</td>
													<td>${e[9]}</td>
													<td>${e[10]}</td>
													<td>${e[8]}</td>
													<td>${e[7]}</td>
													<td>${e[5]}</td>
													<td>${e[2]}</td>
													<td>${e[4]}</td>
													<td>${e[3]}</td>
													<td>${e[6]}</td>
													<td><a href="adminviewexpense?expenseId=${e[0]}">View</a> | <a href="admindeleteexpense?expenseId=${e[0]}">Delete</a> | Edit </td>
				
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