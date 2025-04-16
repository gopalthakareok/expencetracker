<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Expense Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Expense</h2>
        <form method="POST" action="saveexpense" id="ExpenseForm">
            <div class="mb-3">
                <label for="title" class="form-label">Title</label>
                <input type="text" class="form-control" id="title" name="exptitle" required>
            </div>
            <div class="mb-3">
                <label for="amount" class="form-label">Amount</label>
                <input type="number" class="form-control" id="amount" name="amount" required>
            </div>
            <div class="mb-3">
                <label for="date" class="form-label">Transaction Date</label>
                <input type="date" class="form-control" id="date" name="transactiondate" required>
            </div>
            <div class="mb-3">
                <label for="description" class="form-label">Description</label>
                <textarea class="form-control" id="description" name="description" rows="3"></textarea>
            </div>
            <div class="mb-3">
                  Account: <select name="accountId">
                <option>Select Account</option>
                <c:forEach items="${accountList}" var="a">

					<option value="${a.accountId}">${a.acctitle}</option>
			        
			    </c:forEach>
			    </select>
            </div>
            <div class="mb-3">
              
                Category: <select name="categoryId">
                <option>Select Category</option>
                <c:forEach items="${categoryList}" var="c">

					<option value="${c.categoryId}">${c.categoryname}</option>
			        
			    </c:forEach>
			    </select>
            </div>
            
             <div class="mb-3">
              
                Sub Category: <select name="subcategoryId">
                <option>Select Sub Category</option>
                <c:forEach items="${subcategoryList}" var="sc">

					<option value="${sc.subcategoryId}">${sc.subcategoryname}</option>
			        
			    </c:forEach>
			    </select>
            </div>
            
            
           
            <!-- <div class="mb-3">
                <label for="status" class="form-label">Status</label>
                <select class="form-control" id="status" name="status">
                    <option value="Paid">Paid</option>
                    <option value="Pending">Pending</option>
                </select>
            </div> -->
            <button type="submit" class="btn btn-primary">ADD EXPENSE</button>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>