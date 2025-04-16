<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FORGET PASSWORD</title>
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
        input[type="email"] {
            width: 100%;
            padding: 0.5rem;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        button {
            width: 100%;
            padding: 0.75rem;
            background-color: #007BFF;
            border: none;
            color: white;
            border-radius: 4px;
            font-size: 1rem;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
        .login-link {
            display: block;
            margin-top: 1rem;
            text-align: center;
            color: #007BFF;
            text-decoration: none;
        }
        .login-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
 <div class="container">
        <h1>Forget Password</h1>

<form action="resetpassword" method="GET">
                
                <div class="form-group">
                  <label for="email">Email</label>
                  <input type="email" id="email" name="email" required placeholder="Enter your email">
                </div>
                  
                <button type="submit">Send OTP</button>
            
                
</form>           
 <a href="/login" class="login-link">Back to Login</a>
 </div>                              
</body>
</html>