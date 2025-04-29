<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <html>
<head>
    <title>Expense Report</title>
</head>
<body>

<h2>Generate Expense Distribution by Users</h2>

<!-- Date Range Form -->
<form method="post" action="adminexpensereport">
    <label>Start Date:</label>
    <input type="date" name="startDate" required />
    <label>End Date:</label>
    <input type="date" name="endDate" required />
    <button type="submit">Generate</button>
</form>

<!-- Report Table -->
<c:if test="${not empty reportData}">
    <hr>
    <h3>Report From ${startDate} to ${endDate}</h3>
    <table border="1">
        <thead>
            <tr>
                <th>User</th>
                <th>Total Expense (₹)</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="row" items="${reportData}">
                <tr>
                    <td>${row[0]} ${row[1]}</td>
                    <td>₹${row[2]}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>

</body>
</html> --%>




<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Report : Expenses of Users</title>

<jsp:include page="AdminCss.jsp"></jsp:include>


<link  href="https://cdn.datatables.net/2.2.2/css/dataTables.bootstrap5.min.css" rel="stylesheet"/>
 <link href="https://cdn.datatables.net/buttons/3.2.2/css/buttons.dataTables.css" rel="stylesheet" />


</head>
<body>
	<jsp:include page="AdminHeader.jsp"></jsp:include>

	<jsp:include page="AdminSidebar.jsp"></jsp:include>

	<main id="main" class="main">
	

		<div class="pagetitle">
			<h1>Generate Expense Distribution by Users</h1>
			<nav>
        		<ol class="breadcrumb">
          			<li class="breadcrumb-item"><a href="admindashboard">Home</a></li>
          			<li class="breadcrumb-item">Reports</li>
          			<li class="breadcrumb-item active">Expenses of Users</li>
        		</ol>
      		</nav>
			<section class="section dashboard" >
			<div class="card col-4">
            <div class="card-body">
			 <form class="row g-3 mt-2" action="adminexpensereport" method="post">
			 
			 <div class="col-10">
                  <label for="startDate" class="form-label">Start Date</label>
                  <input type="date" class="form-control" name="startDate" id="startDate">
                </div>
                <div class="col-10">
                  <label for="endDate" class="form-label">End Date</label>
                  <input type="date" class="form-control" name="endDate" id="endDate">
                </div>
              <div class="text-center">
                  <button type="submit" class="btn btn-primary">Generate</button>
                </div>
			 </form>
			   </div>
                </div>
		
		
			<div class="row" style="min-height: 467px;">

				<!-- Left side columns -->
				<div class="col-lg-12">
					<div class="row">
						<!-- Reports -->
						<div class="col-12">
							<div class="card">
								<div class="card-body">
									<c:if test="${not empty reportData}">
    									<hr>
    									<h3>Report From ${startDate} to ${endDate}</h3>

									<table class="table datatable datatable-table table-hover" id="myTable">
									
										<thead>
           									 <tr>
              								  	 <th>User</th>
               									 <th>Total Expense (₹)</th>
            								</tr>	
        								</thead>

										<tbody>
											 <c:forEach var="row" items="${reportData}">
               										 <tr>
                    									<td>${row[0]} ${row[1]}</td>
                    									<td>₹${row[2]}</td>
                									</tr>
            								</c:forEach>
										</tbody>
									</table>
									
									</c:if>
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
 	<script src="https://cdn.datatables.net/buttons/3.2.2/js/dataTables.buttons.js"></script>
 	<script src="https://cdn.datatables.net/buttons/3.2.2/js/buttons.dataTables.js"></script>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.10.1/jszip.min.js"></script>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.2.7/pdfmake.min.js"></script>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.2.7/vfs_fonts.js"></script>
 	<script src="https://cdn.datatables.net/buttons/3.2.2/js/buttons.html5.min.js"></script>
 	<script src="https://cdn.datatables.net/buttons/3.2.2/js/buttons.print.min.js"></script>
 	

	<script type="text/javascript">

	$( document ).ready(function() {
		// let table = new DataTable('#myTable');
		
		new DataTable('#myTable', {
 	 	    layout: {
 	 	        topStart: {
 	 	            buttons: ['copy', 'csv', 'excel', 'pdf', 'print']
 	 	        }
 	 	    }
 	 	});
	});
	</script>

</body>
</html>