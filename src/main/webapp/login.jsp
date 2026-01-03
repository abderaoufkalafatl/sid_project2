<%@ page language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>login</title>
    <link rel="stylesheet" href="login.css">
</head>
<body>

    <form class="form" action="${pageContext.request.contextPath}/login" method="post">
       <p class="form-title">Sign in to your account</p>
        <div class="input-container">
          <input placeholder="Enter email" type="email" name="email">
        </div>
        <div class="input-container">
          <input placeholder="Enter password" type="password" name="password">
        </div>
        <button class="submit" type="submit">Sign in</button>

      <p class="signup-link">
        No account?
        <a href="${pageContext.request.contextPath}/register.jsp">Sign up</a>
      </p>
    </form>

</body>
</html>