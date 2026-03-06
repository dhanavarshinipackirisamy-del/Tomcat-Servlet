package com.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/validate")
public class ValidationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        response.setContentType("text/html");

        // UC3 Name validation
        boolean validName = user.matches("^[A-Z][a-zA-Z]{2,}$");

        // UC4 Password validation
        boolean validPassword = pwd.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=]).{8,}$");

        if(validName && validPassword) {

            request.setAttribute("user", user);

            RequestDispatcher rd =
                    request.getRequestDispatcher("LoginSuccess.jsp");

            rd.forward(request,response);

        } else {

            response.getWriter().println("<h3>Invalid Name or Password</h3>");

        }
    }
}