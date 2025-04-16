<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Category Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Category</h2>
        <!-- Edit Category Form -->
                            <form action="editcategory" method="post">
                                <div class="mb-3">
                                    <label for="categoryName" class="form-label">Category Name</label>
                                    <input type="text" class="form-control" id="categoryName" name="categoryname" value="${category.categoryName}" required>
                                </div>

                                <!-- Hidden input to pass category ID -->
                                <input type="hidden" name="categoryId" value="${category.categoryId}">

                                <button type="submit" class="btn btn-primary">Update Category</button>
                                <a href="listcategory" class="btn btn-secondary">Cancel</a>
                            </form>
                            <!-- End Form -->

    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>