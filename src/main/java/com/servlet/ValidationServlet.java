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

        response.setContentType("text/html");

        if(user.matches("^[A-Z][a-zA-Z]{2,}$")) {

            request.setAttribute("user", user);

            RequestDispatcher rd =
                    request.getRequestDispatcher("LoginSuccess.jsp");

            rd.forward(request, response);

        } else {

            response.getWriter().println("<h3>Invalid Name</h3>");
            response.getWriter().println("Name must start with capital letter and minimum 3 characters");

        }
    }
}