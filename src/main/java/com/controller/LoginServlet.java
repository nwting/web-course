package com.controller;

import com.entity.Users;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final Logger LOGGER=Logger.getLogger(LoginServlet.class.getName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/login.html")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url;
        String username=req.getParameter("username");
        String pwd=req.getParameter("pwd");
        if(username.equals("nwt") && pwd.equals("123456")){
            Users user=new Users("nwt");
            req.getSession().setAttribute("users",user);
            url="/welcome";
        }
        else{
            url="/login";
        }
        //req.getRequestDispatcher(url);
        resp.sendRedirect(req.getContextPath()+url);
    }
}
