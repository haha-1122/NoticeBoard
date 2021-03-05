package com.example.demo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "PWCheck", value = "/PWCheck")
public class PWCheck extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        HashMap<String, String> hMap = (HashMap<String, String>) session.getAttribute("view");
        pwCheck(hMap, req, resp);
    }

    private void pwCheck(HashMap<String, String> hMap, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        switch (Integer.parseInt(req.getParameter("op"))) {
            case 0:
                if (hMap.get("pw").equals(req.getParameter("pw")))
                    resp.sendRedirect("/modify.jsp");
                else {
                    out.write("<script>alert('비밀번호 틀림'); location.href='/view.jsp';</script>");
                    out.close();
                }
                break;
            case 1:
                if (hMap.get("pw").equals(req.getParameter("pw")))
                    resp.sendRedirect("/DropData");
                else {
                    out.write("<script>alert('비밀번호 틀림'); location.href='/view.jsp';</script>");
                    out.close();
                }
        }

    }
}
