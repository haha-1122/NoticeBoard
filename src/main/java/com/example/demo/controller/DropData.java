package com.example.demo.controller;

import com.example.demo.model.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "DropData", value = "/DropData")
public class DropData extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        HashMap<String, String> hMap = (HashMap<String, String>) session.getAttribute("view");
        DB db = new DB(req, resp);
        db.drop(hMap.get("no"));
        resp.sendRedirect("/index.jsp");
    }
}
