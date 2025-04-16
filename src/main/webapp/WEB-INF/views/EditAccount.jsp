<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Account Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Edit account</h2>
          <!-- Update Account Form -->
                            <form action="editaccount" method="post" id="EditAccountForm">
                                <div class="mb-3">
                                    <label class="form-label">Account Title</label>
                                    <input type="text" class="form-control" name="title" value="${account.title}" required>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Amount</label>
                                    <input type="number" class="form-control" name="amount" value="${account.amount}" required>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Description</label>
                                    <textarea class="form-control" name="description" rows="3" required>${account.description}</textarea>
                                </div>

                                <!-- Hidden input to pass account ID -->
                                <input type="hidden" name="accountId" value="${account.accountId}">

                                <button type="submit" class="btn btn-primary">Update Account</button>
                                <a href="listaccount" class="btn btn-secondary">Cancel</a>
                            </form>
                            <!-- End Form -->

    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

