package controller;

import java.io.IOException;

import dao.User;
import dao.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class Loginservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	 String email = request.getParameter("email");
         String password = request.getParameter("password");
         
         
         
         System.out.println("LOGIN SERVLET HIT");
         System.out.println("EMAIL = " + email);
         System.out.println("PASSWORD = " + password);
         
         
         
         
         UserDAO userDao = new UserDAO();
         User user = userDao.getUserByEmail(email);

         if (user != null && user.getPassword().equals(password)) { // compare password
             // Login successful
             HttpSession session = request.getSession();
             session.setAttribute("user", user); // store the User object in session

             // Redirect based on role
             if ("admin".equalsIgnoreCase(user.getRole())) {
                 response.sendRedirect("admin.jsp");
             } else {
                 response.sendRedirect("index.jsp");
             }

         } else {
             // Login failed
             request.setAttribute("errorMessage", "Invalid email or password");
             request.getRequestDispatcher("login.jsp").forward(request, response);
         }

        
    }

}



