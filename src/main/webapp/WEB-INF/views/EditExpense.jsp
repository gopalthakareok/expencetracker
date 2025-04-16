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
        <form method="POST" action="editexpense" id="ExpenseForm">
            <div class="mb-3">
                <label for="title" class="form-label">Title</label>
                <input type="text" class="form-control" id="title" name="title" required>
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
                <label for="account" class="form-label">Account</label>
                  Account: <select name="accountId">
                <option>Select Account</option>
                <c:forEach items="${accountList}" var="a">

					<option value="${a.accountId}"></option>
			        
			    </c:forEach>
			    </select>
            </div>
            <div class="mb-3">
                <label for="category" class="form-label">Category</label>
                Category: <select name="categoryId">
                <option>Select Category</option>
                <c:forEach items="${categoryList}" var="c">

					<option value="${c.categoryId}">${c.categoryname}</option>
			        
			    </c:forEach>
			    </select>
            </div>
            <div class="mb-3">
                <label for="subcategory" class="form-label">Subcategory</label>
                SubCategory: <select name="subcategoryId">
                <option>Select Subcategory</option>
                <c:forEach items="${subcategoryList}" var="s">
                
					<option value="${s.subcategoryId}">${s.subcategoryname}</option>
			        System.out.print("subcategoryList");
			    </c:forEach>
			     </select>
            </div>
            <div class="mb-3">
                <label for="vendor" class="form-label">Vendor</label>
                <input type="text" class="form-control" id="vendor" name="vendor" required>
            </div>
         
            <button type="submit" class="btn btn-primary">UPDATE EXPENSE</button>
            <a href="listexpense" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
