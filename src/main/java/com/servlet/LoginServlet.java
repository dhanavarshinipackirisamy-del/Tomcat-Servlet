package com.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        if(user.equals("admin") && pwd.equals("1234")){

            RequestDispatcher rd =
                    request.getRequestDispatcher("LoginSuccess.jsp");

            request.setAttribute("user", user);

            rd.forward(request,response);

        } else {

            response.getWriter().println("<h3>Invalid Login</h3>");

        }
    }
}
