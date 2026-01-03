<%@ page language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>sign-up</title>
    <link rel="stylesheet" href="register.css">
</head>
<body>

    <form class="form" action="${pageContext.request.contextPath}/Registerservlet" method="post">
       <p class="form-title">Create new account</p>
       <div class="input-container">
          <input placeholder="Enter name" type="text" name="fullname">
          
        </div>
        <div class="input-container">
          <input placeholder="Enter role    Admin or Client" type="text" name="role">
          
        </div>
        <div class="input-container">
          <input placeholder="Enter email" type="email" name="email">
          
        </div>
        <div class="input-container">
          <input placeholder="Enter password" type="password" name="password">

        
        </div>
        <button class="submit" type="submit"> 
           create account
        </button>
   </form>

</body>
</html>