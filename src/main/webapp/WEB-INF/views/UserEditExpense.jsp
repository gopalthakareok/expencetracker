<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
  	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0" name="viewport">

  	<title>Edit Expense | Expense Tracker</title>
  	<meta content="" name="description">
  	<meta content="" name="keywords">

  	<!-- Favicons -->
  	<link href="assets/img/favicon.png" rel="icon">
  	<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  	<!-- Google Fonts -->	
  	<link href="https://fonts.gstatic.com" rel="preconnect">
  	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  	<!-- Vendor CSS Files -->
  	<link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  	<link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  	<link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  	<link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
  	<link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
  	<link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  	<link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">
	
  	<!-- Template Main CSS File -->
  	<link href="assets/css/style.css" rel="stylesheet">
	
  	<!-- =======================================================
  	* Template Name: NiceAdmin
  	* Updated: Jan 29 2024 with Bootstrap v5.3.2
  	* Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  	* Author: BootstrapMade.com
  	* License: https://bootstrapmade.com/license/
  	======================================================== -->
</head>

<body>

  	<!-- ======= Header ======= -->
  	<jsp:include page="UserHeader.jsp"></jsp:include>
  	<!-- End Header -->

  	<!-- ======= Sidebar ======= -->
  	<jsp:include page="UserSidebar.jsp"></jsp:include>
  	<!-- End Sidebar-->

  	<main id="main" class="main">

    	<div class="pagetitle">
      		<h1>Edit Expense</h1>
      		<nav>
        		<ol class="breadcrumb">
          			<li class="breadcrumb-item"><a href="userdashboard">Home</a></li>
          			<li class="breadcrumb-item active">Edit Expense</li>
        		</ol>
      		</nav>
    	</div><!-- End Page Title -->

    	<section class="section dashboard" style="min-height: 467px;">
			<div class="card col-6">
            <div class="card-body">

              <!-- Vertical Form -->
              <form class="row g-3 mt-2" action="userupdateexpense" method="post">
                 <div class="col-10">
                  <label for="title" class="form-label">Title</label>
                  <input type="text" class="form-control" name="title" id="title" value="${expense.title}">
                </div>
                <div class="col-10">
                  <label for="amount" class="form-label">Amount</label>
                  <input type="text" class="form-control" name="amount" id="amount" value="${expense.amount}">
                </div>
                <div class="col-10">
                  <label for="transactionDate" class="form-label">TranscationDate</label>
                  <input type="date" class="form-control" name="transactionDate" id="transactionDate" value="${expense.transactionDate}">
                </div>
                <div class="col-10">
                  <label for="description" class="form-label">Description</label>
                  <input type="text" class="form-control" name="description" id="description" value="${expense.description}">
                </div>
                <div class="col-md-10">
                  <label for="accountId" class="form-label">Account</label>
                  <select id="accountId" class="form-select" name="accountId">
                    <option selected="">Choose...</option>
                    <c:forEach items="${accountList}" var="i">
                    <option value="${i.accountId}">${i.title}</option>
                    </c:forEach>
                  </select>
                </div>
                 <div class="col-md-10">
                  <label for="inputCategory" class="form-label">Category</label>
                  <select id="inputCategory" class="form-select" name="categoryId">
                    <option selected="">Choose...</option>
                    <c:forEach items="${categoryList}" var="c">
                    <option value="${c.categoryId}">${c.categoryName}</option>
                    </c:forEach>
                  </select>
                </div>
                 <div class="col-md-10">
                  <label for="inputsubCategory" class="form-label">SubCategory</label>
                  <select id="inputsubCategory" class="form-select" name="subCategoryId">
                    <option selected="">Choose...</option>
                    <c:forEach items="${subcategoryList}" var="s">
                    <option value="${s.subCategoryId}">${s.subCategoryName}</option>
                    </c:forEach>
                  </select>
                </div>
                <div class="col-md-10">
                  <label for="status" class="form-label">Status</label>
                  <select id="status" class="form-select" name="status">
                    <option selected="${expense.status}">${expense.status}</option>
                    <option value="Completed">Completed</option>
                    <option value="Pending">Pending</option>
                    <option value="Hold">Hold</option>
                    <option value="Partial">Partial</option>
                  </select>
                </div>
                <div class="col-md-10">
                  <label for="inputvendor" class="form-label">Vendor</label>
                  <select id="inputvendor" class="form-select" name="vendorId">
                    <option selected="">Choose...</option>
                    <c:forEach items="${vendorList}" var="v">
                    <option value="${v.vendorId}">${v.vendorName}</option>
                    </c:forEach>
                  </select>
                </div>
                <input type="hidden" name="expenseId"  value="${expense.expenseId}"/>
                <div class="text-center">
                  <button type="submit" class="btn btn-primary">Submit</button>
                </div>
              </form><!-- Vertical Form -->

            </div>
          </div>
    	</section>

  	</main><!-- End #main -->

  	<!-- ======= Footer ======= -->
  	<jsp:include page="AdminFooter.jsp"></jsp:include>
  	<!-- End Footer -->

  	<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  	<!-- Vendor JS Files -->
  	<script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
  	<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  	<script src="assets/vendor/chart.js/chart.umd.js"></script>
  	<script src="assets/vendor/echarts/echarts.min.js"></script>
  	<script src="assets/vendor/quill/quill.min.js"></script>
  	<script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
  	<script src="assets/vendor/tinymce/tinymce.min.js"></script>
  	<script src="assets/vendor/php-email-form/validate.js"></script>

  	<!-- Template Main JS File -->
  	<script src="assets/js/main.js"></script>

</body>
</html>
