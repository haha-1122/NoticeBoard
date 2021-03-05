package com.example.demo.controller;

import com.example.demo.model.DB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "InputData", value = "/InputData")
public class InputData extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DB db = new DB(request, response);
        db.input();
        response.sendRedirect("index.jsp");
    }
}
