<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
  	<meta charset="utf-8">
	<meta content="width=device-width, initial-scale=1.0" name="viewport">

  	<title>Subcategories | Expense Tracker</title>
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
  	<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
	
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
  	<jsp:include page="AdminHeader.jsp"></jsp:include>
  	<!-- End Header -->

  	<!-- ======= Sidebar ======= -->
  	<jsp:include page="AdminSidebar.jsp"></jsp:include>
  	<!-- End Sidebar-->

  	<main id="main" class="main">

    	<div class="pagetitle">
      		<h1> Add Subcategories</h1>
      		<nav>
        		<ol class="breadcrumb">
          			<li class="breadcrumb-item"><a href="admindashboard">Home</a></li>
          			<li class="breadcrumb-item">Subcategories</li>
          			<li class="breadcrumb-item active">Add Subcategories</li>
        		</ol>
      		</nav>
    	</div><!-- End Page Title -->

    	<section class="section dashboard" style="min-height: 467px;">
			<div class="card col-6">
            <div class="card-body">

              <!-- Vertical Form -->
              <form class="row g-3 mt-2" action="adminsavesubcategory" method="post">
                <div class="col-10">
                  <label for="subcategoryName" class="form-label">SubCategory</label>
                  <input type="text" class="form-control" name="subCategoryName" id="title">
                </div>
                <div class="col-md-10">
                  <label for="userId" class="form-label">User</label>
                  <select id="userId" class="form-select" name="userId" onchange="getCategory()">
                    <option selected="">Select User</option>
                    <c:forEach items="${userList}" var="u">
                    <option value="${u.userId}">${u.firstName}</option>
                    </c:forEach>
                  </select>
                </div>
                <div class="col-md-10">
                  <label for="inputCategory" class="form-label">Category</label>
                  <select id="categoryId" class="form-select" name="categoryId">
                    <option selected="">Select Category</option>
                    <%-- <c:forEach items="${allCategory}" var="c">
                    <option value="${c.categoryId}">${c.categoryName}</option>
                    </c:forEach> --%>
                  </select>
                </div>
                
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
  	
  	<script type="text/javascript">

	function getCategory(){
		console.log("user Change");
		let userId = document.getElementById("userId").value;
		console.log(userId);
		
		//url -> json REST 
		
		  $.get( "getallcategorybyuserid/"+userId, function() {
			})
			  .done(function(data) {
			    console.log(data);
			    //fill the subcategory 
			    $('#categoryId').empty().append('<option selected="selected" value="-1">Select Category</option>')
			    
			    for (var i = 0; i < data.length; i++) {
    			  $('#categoryId').append('<option value="' + data[i].categoryId + '">' + data[i].categoryName + '</option>');
 				 }
			    
			  })
			  .fail(function() {
			    alert( "error" );
			  })
	}
		</script>

</body>
</html>
