<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Signup Form</h2>
        <form method="POST" action="saveuser" id="Signup">
            <div class="mb-3">
                <label for="firstname" class="form-label">First Name</label>
                <input type="text" class="form-control" id="firstname" name="firstname" required>
            </div>
            <div class="mb-3">
                <label for="lastname" class="form-label">Last Name</label>
                <input type="text" class="form-control" id="lastname" name="lastname" required>
            </div>
            <div class="mb-3">
   			 <label for="email" class="form-label">Email</label>
   			 <input type="email" class="form-control" id="email" name="email" required>
   			 <div class="invalid-feedback">
   			     Please enter a valid email address.
   			 </div>
			</div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <div class="mb-3">
                <label for="confirmpassword" class="form-label">Confirm Password</label>
                <input type="password" class="form-control" id="confirmpassword" name="confirmpassword" required>
            </div>
            <div class="mb-3">
                <label for="contactno" class="form-label">Contact No</label>
                <input type="tel" class="form-control" id="contactno" name="contactno" pattern="[0-9]{10}" required>
			    <div class="invalid-feedback">
			        Please enter a valid 10-digit contact number!
			    </div>

            </div>
            <div class="mb-3">
                <label for="address" class="form-label">Address</label>
                <input type="text" class="form-control" id="address" name="address" required>
            </div>
            
              <div class="mb-3">
                <label class="form-label">Gender</label><br>
                <input type="radio" name="gender" value="Male" required> Male
                <input type="radio" name="gender" value="Female" required> Female
            </div>
      
            
        
        
            <button type="submit" class="btn btn-primary">Sign Up</button>
            <p class="mt-3">Already have an account? <a href="login">Login</a></p>
        
  </form>
  </div>
    
  
 
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>


</body>
</html>