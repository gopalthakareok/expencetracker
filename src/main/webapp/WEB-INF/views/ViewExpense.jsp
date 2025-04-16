<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Admin Dashboard</title>

    <!-- Custom fonts for this template-->
    <link href="Asset/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="Asset/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <jsp:include page="AdminSidebar.jsp"></jsp:include>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                 <jsp:include page="AdminHeader.jsp"></jsp:include>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
                       
                    </div> 
                    <div class="card shadow mb-4">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
					                <tr>
										<th>Title</th>
										<th>Category</th>
										<th>Sub-category</th>
										<th>Vendor Name</th>
										<th>Accountname</th>
										<th>Status</th>
										<th>Amount</th>
										<th>Transaction Date</th>
										<th>Description</th>
										
									</tr>
                                    </thead>
                                    <tfoot>
                                    
											<tr>
						 						<td>${expense[10]}</td>
												<td>${expense[11]}</td>
												<td>${expense[12]}</td>
												<td>${expense[14]}</td>
												<td>${expense[13]}</td>
												<td>${expense[15]}</td>
												<td>${expense[16]}</td>
												<td>${expense[2]}</td>
												<td>${expense[6]}</td>
												<td>${expense[4]}</td>
												
											</tr>
										
                                    </tfoot>
                                </table>
                             </div>
                         </div>
                     </div>          
                    
                    
                    
                    
                    
                    
                                 
                 </div>
                                              
                                     
                      
                 </div>
                 <!-- /.container-fluid --> 
                </div>
                 <!-- End of Main Content -->

            </div>
             <!-- End of Content Wrapper -->
       
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>


    
<footer id="footer" class="footer">
	<jsp:include page="AdminFooter.jsp"></jsp:include>
</footer>

</body>

</html>

