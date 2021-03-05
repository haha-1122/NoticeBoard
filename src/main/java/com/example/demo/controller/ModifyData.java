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

@WebServlet(name = "ModifyData", value = "/ModifyData")
public class ModifyData extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DB db = new DB(req, resp);
        HttpSession session = req.getSession();
        HashMap<String, String> hMap = (HashMap<String, String>) session.getAttribute("view");
        db.update(Integer.parseInt(hMap.get("no")));
        resp.sendRedirect("/index.jsp");
    }
}
