package com.decapitator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.getWriter().append("Hello Servlet "+ req.getMethod());
        HttpSession httpSession = req.getSession();
        if (httpSession.getValue("name")==null) {
            httpSession.putValue("name", "Hello Sophocl");
            resp.getWriter().append(" No session ");
        }else {
            resp.getWriter().append((String)httpSession.getValue("name"));
        }

        }

}
