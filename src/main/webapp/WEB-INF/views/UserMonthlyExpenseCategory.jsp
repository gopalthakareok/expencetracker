<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <html>
<head>
    <title>Monthly Expense by Category</title>
    <style>
        table {
            width: 60%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #999;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #eee;
        }
        form {
            margin-top: 20px;
        }
    </style>
</head>
<body>

    <h2>Monthly Expense Breakdown by Category</h2>

    <!-- Form to select month and year -->
    <form action="usermonthlyexpensecategories" method="post">
        <label>Select Month:</label>
        <select name="month">
            <c:forEach var="i" begin="1" end="12">
                <option value="${i}">${i}</option>
            </c:forEach>
        </select>

        <label>Select Year:</label>
        <select name="year">
            <c:forEach var="y" begin="2022" end="2025">
                <option value="${y}">${y}</option>
            </c:forEach>
        </select>

        <input type="submit" value="Show Report"/>
    </form>

    <!-- Report Table -->
    <c:if test="${not empty categorywiseexpenses}">
        <h4>Showing Data for: ${month}/${year}</h4>
        <table>
            <thead>
                <tr>
                    <th>Category</th>
                    <th>Total Expense</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="row" items="${categorywiseexpenses}">
                    <tr>
                        <td>${row[0]}</td>
                        <td>₹ ${row[1]}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty categorywiseexpenses}">
        <p>No data found for selected month/year.</p>
    </c:if>

</body>
</html>
 --%>
 
 
 

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Report : Categories wise Monthly Expenses</title>

<jsp:include page="AdminCss.jsp"></jsp:include>


<link  href="https://cdn.datatables.net/2.2.2/css/dataTables.bootstrap5.min.css" rel="stylesheet"/>
<link href="https://cdn.datatables.net/buttons/3.2.2/css/buttons.dataTables.css" rel="stylesheet" />


</head>
<body>
	<jsp:include page="UserHeader.jsp"></jsp:include>

	<jsp:include page="UserSidebar.jsp"></jsp:include>

	<main id="main" class="main">
	

		<div class="pagetitle">
			<h1>Categories wise Monthly Expenses</h1>
			<nav>
        		<ol class="breadcrumb">
          			<li class="breadcrumb-item"><a href="userdashboard">Home</a></li>
          			<li class="breadcrumb-item">Reports</li>
          			<li class="breadcrumb-item active">Categories wise Monthly Expenses</li>
        		</ol>
      		</nav>
			<section class="section dashboard" >
			<div class="card col-4">
            <div class="card-body">
			 <form class="row g-3 mt-2" action="usermonthlyexpensecategories" method="post">
			 
			 <div class="col-md-10">
                  <label for="month" class="form-label">Select Month: </label>
                  <select id="month" class="form-select" name="month">
                    <option selected="">Choose...</option>
                    <c:forEach  var="i" begin="1" end="12">
                    <option value="${i}">${i}</option>
                    </c:forEach>
                  </select>
                </div>
                <div class="col-md-10">
                  <label for="year" class="form-label">Select Year: </label>
                  <select id="year" class="form-select" name="year">
                    <option selected="">Choose...</option>
                    <c:forEach var="y" begin="2022" end="2025">
                    <option value="${y}">${y}</option>
                    </c:forEach>
                  </select>
                </div>
              <div class="text-center">
                  <button type="submit" class="btn btn-primary">Show Report</button>
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
									<c:if test="${not empty categorywiseexpenses}">
    									<hr>
    									<h3>Showing Data for: ${month}/${year}</h3>

									<table class="table datatable datatable-table table-hover" id="myTable">
									
										<thead>
           									 <tr>
              								  	 <th>Category</th>
               									 <th>Total Expense (₹)</th>
            								</tr>	
        								</thead>

										<tbody>
											 <c:forEach var="row" items="${categorywiseexpenses}">
               										 <tr>
                    									<td>${row[0]}</td>
     									                <td>₹ ${row[1]}</td>
                									</tr>
            								</c:forEach>
										</tbody>
									</table>
									
									</c:if>
									 <c:if test="${empty categorywiseexpenses}">
        								<p>No data found for selected month/year.</p>
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