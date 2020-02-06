package com.packt.webstore.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.packt.webstore.dao.DAO;
import com.packt.webstore.domain.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class LogInServlet extends HttpServlet {
    HttpSession session = null;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        DAO data = new DAO();
        List<User> customers = data.getCustomerList();
        User client = null;

        for(User c : customers){
            if(userName.equals(c.getUserName())){
                if(password.equals(c.getPassword())){
                    client = c;
                    break;
                }
            }
        }

        if(client == null){
            System.out.println("c is null");
            req.setAttribute("msg","Invalid username and/or password");
            RequestDispatcher d = req.getRequestDispatcher("login.jsp");
            d.forward(req, resp);
        }else {
            HttpSession bookSession = req.getSession();
            bookSession.setAttribute("name", client.getFirstName());
            bookSession.setAttribute("userName", client.getUserName());
            bookSession.setAttribute("password", client.getPassword());
            bookSession.setAttribute("user", client);
            String rem = req.getParameter("remember");
            if (rem != null) {
                Cookie c = new Cookie("userCookie", client.getUserName());
                c.setMaxAge(2592000);
                resp.addCookie(c);
            } else {
                for (Cookie c : req.getCookies()) {
                    if (c.getValue().equals(userName)) {
                        Cookie d = new Cookie("userCookie", "");
                        d.setMaxAge(0);
                        resp.addCookie(d);
                        break;
                    }
                }
            }

            String value = "", checkbox = "";
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().equals("username")) {
                        value = c.getValue();
                        checkbox = "checked";
                        break;
                    }
                }
            }

            String loggedIn = "hidden";
            bookSession.setAttribute("logged", loggedIn);

            RequestDispatcher rd = req.getRequestDispatcher("userPage.jsp");
            rd.forward(req, resp);
        }
    }


//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//         doPost(req,resp);
//
//
//    }
}