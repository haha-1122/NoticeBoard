package com.example.demo.controller;

import com.example.demo.model.DB;

import javax.ejb.SessionContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ViewData", value = "/ViewData")
public class ViewData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DB db = new DB(req, resp);
        HttpSession session = req.getSession();
        session.setAttribute("view", db.getViewData());
        resp.sendRedirect("/view.jsp");
    }
}
