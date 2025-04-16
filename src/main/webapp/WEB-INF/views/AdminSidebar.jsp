<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN SIDEBAR</title>
</head>
<body>
        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
        
            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Admin Dashboard</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item">
                <a class="nav-link" href="admindashboard">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Dashboard</span>
                 </a>
            </li>

            

            <!-- Nav Item Menu -->
            <li class="nav-item">
                <a class="nav-link" href="listusers">
                <i class="fas fa-fw fa-cog"></i>
                    <span>Users</span>
                </a>
                
            
                <a class="nav-link" href="listaccount">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Accounts</span>
                </a>
                
                 <a class="nav-link" href="listincome">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Incomes</span>
                </a>
                
                <a class="nav-link" href="listexpense">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Expenses</span>
                </a>
                                     
                <a class="nav-link" href="listcategory">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Categories</span>
                </a>
                
                <a class="nav-link" href="listsubcategory">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Subcategories</span>
                </a>
            
                <a class="nav-link" href="listvendor">
                <i class="fas fa-fw fa-cog"></i>
                    <span>Vendors</span>
                </a>
                
                <a class="nav-link" href="liststate">
                <i class="fas fa-fw fa-cog"></i>
                    <span>States</span>
                </a>
                
                <a class="nav-link" href="listcity">
                <i class="fas fa-fw fa-cog"></i>
                    <span>Cities</span>
                </a>
          
    	      
            </li>

    


            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

            

        </ul>
        <!-- End of Sidebar -->
</body>
</html>