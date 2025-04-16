<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Income Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Income</h2>
        <!-- Update Account Form -->
                            <form action="updateincome" method="post" id="editIncomeForm">
                                <div class="mb-3">
                                    <label class="form-label">Income Title</label>
                                    <input type="text" class="form-control" name="title" value="${income.title}" required>
                                </div>

                                <div class="mb-3">	
                                    <label class="form-label">Amount</label>
                                    <input type="number" class="form-control" name="amount" value="${income.amount}" required>
                                </div>
                                
                                <div class="mb-3">
                                    <label class="form-label">Income TransactionDate</label>
                                    <input type="date" class="form-control" name="transcationDate" value="${income.transcationDate}" required>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Description</label>
                                    <textarea class="form-control" name="description" rows="3" required>${income.description}</textarea>
                                </div>
                                <div class = "mb-3">
                                	<label for="accountId" class="form-label">Select Account</label>
                                        <select  class="form-select" id="accountId" name="accountId" required>
									        <option   selected >  Select Account </option>
									        <c:forEach items = "${allAccount}" var = "account">
									        	<option value="${ account.accountId}"  ${account.accountId == account.accountId? "selected":"" }>${account.title}</option>        
									        </c:forEach>
									        </select><br>
                                	</div>

                                <!-- Hidden input to pass account ID -->
                                <input type="hidden" name="incomeId" value="${income.incomeId}">

                                <button type="submit" class="btn btn-primary">Update Income</button>
                                <a href="listincome" class="btn btn-secondary">List Income</a>
                            </form>
                            <!-- End Form -->
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
