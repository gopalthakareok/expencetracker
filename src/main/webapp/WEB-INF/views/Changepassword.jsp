<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHANGE PASSWORD</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }
        h1 {
            font-size: 1.5rem;
            margin-bottom: 1rem;
            color: #333;
            text-align: center;
        }
        .form-group {
            margin-bottom: 1rem;
        }
        label {
            display: block;
            margin-bottom: 0.5rem;
            font-weight: bold;
        }
        input {
            width: 100%;
            padding: 0.5rem;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        button {
            width: 100%;
            padding: 0.75rem;
            background-color: #28a745;
            border: none;
            color: white;
            border-radius: 4px;
            font-size: 1rem;
            cursor: pointer;
        }
        button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
<div class="container">
        <h1>Reset Password</h1>
<form action="updatepassword" method="post">

               <div class="form-group">
                <label for="otp">OTP</label>
                <input type="text" id="otp" name="otp" required placeholder="Enter OTP">
            </div>
            <div class="form-group">
                <label for="new-password">New Password</label>
                <input type="password" id="new-password" name="new_password" required placeholder="Enter new password">
            </div>
            <div class="form-group">
                <label for="confirm-password">Confirm Password</label>
                <input type="password" id="confirm-password" name="confirm_password" required placeholder="Confirm new password">
            </div>
            <button type="submit">Update Password</button>
                
</form>       
</div>
</body>
</html>