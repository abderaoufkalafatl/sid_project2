package controller;

import java.io.IOException;


import dao.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Registerservlet")
public class Registerservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = "client"; // default role
        
        
        System.out.println("register servlet SERVLET HIT");
        System.out.println("EMAIL = " + email);
        System.out.println("PASSWORD = " + password);
        System.out.println("ROLE = " + role);
        System.out.println("FULLNAME = " + fullname);
        

        UserDAO userDao = new UserDAO();

        if (userDao.register(fullname, email, password, role)) {
            // Registration successful → go to login page
            response.sendRedirect("login.jsp");
        } else {
            // Registration failed → stay on register page
            request.setAttribute("errorMessage", "Registration failed. Email may already exist.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

}

