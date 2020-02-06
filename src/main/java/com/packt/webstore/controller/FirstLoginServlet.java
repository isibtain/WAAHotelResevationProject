package com.packt.webstore.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.google.gson.Gson;
import com.packt.webstore.dao.DAO;
import com.packt.webstore.domain.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@WebServlet("/firstLogin")
public class FirstLoginServlet extends HttpServlet {
    HttpSession session = null;

    DAO data;
    Gson mapper = new Gson();

    @Override
    public void init() throws ServletException {
        data = new DAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        User user = mapper.fromJson(req.getParameter("user"), User.class);

        String userName = user.getUserName();
        String password = user.getPassword();
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

        if(client != null){
            String message = "success";
            PrintWriter out = resp.getWriter();
            out.print(mapper.toJson(message));
        }else {
            String message = "Invalid User Name or Password";
            PrintWriter out = resp.getWriter();
            out.print(mapper.toJson(message));
        }
    }

}