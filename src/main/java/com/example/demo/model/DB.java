package com.example.demo.model;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DB {
    private static final String url = "jdbc:mysql://localhost:3306/project";
    private static final String id = "root";
    private static final String pw = "1234";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private final ServletRequest request;
    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;
    int cnt = 1;

    public DB(ServletRequest request, ServletResponse response) {
        this.request = request;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, id, pw);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void input() {
        try {
            pst = conn.prepareStatement(SQL.Insert.sql);
            pst.setString(1, request.getParameter("title"));
            pst.setString(2, request.getParameter("name"));
            pst.setString(3, request.getParameter("pw"));
            pst.setString(4, request.getParameter("email"));
            pst.setString(5, request.getParameter("contents"));
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int index) {
        try{
            pst = conn.prepareStatement(String.format(Format.Update.format, index));
            pst.setString(1, request.getParameter("title"));
            pst.setString(2, request.getParameter("name"));
            pst.setString(3, request.getParameter("contents"));
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void drop(String index) {
        try {
            pst = conn.prepareStatement(SQL.Delete.sql);
            pst.setString(1, index);
            pst.executeUpdate();
            conn.prepareStatement("set @cnt = 0").executeUpdate();
            conn.prepareStatement("update board set no = @cnt := @cnt+1").executeUpdate();
            conn.prepareStatement("alter table board auto_increment = " + cnt).executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> repository() {
        ArrayList<String> repository = new ArrayList<String>() {
            public String toString() {
                return super.toString().replaceAll("[,\\[\\]]", "");
            }
        };
        try {
            pst = conn.prepareStatement(SQL.Select.sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                repository.add(getString(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        cnt = repository.size();
        return repository;
    }

    private String getString(ResultSet rs) throws SQLException {
        return String.format(
                Format.Select.format,
                rs.getInt(1),
                rs.getInt(1),
                rs.getString(2),
                rs.getInt(1),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5));
    }

    public HashMap<String, String> getViewData() {
        HashMap<String, String> vData = new HashMap<>();
        try {
            pst = conn.prepareStatement(String.format(Format.SelectView.format, Integer.parseInt(request.getParameter("index"))));
            rs = pst.executeQuery();
            rs.next();
            vData.put("no", rs.getString("no"));
            vData.put("title", rs.getString("title"));
            vData.put("name", rs.getString("name"));
            vData.put("wTime", rs.getString("wTime"));
            vData.put("contents", rs.getString("contents"));
            vData.put("pw", rs.getString("pw"));
            pst = conn.prepareStatement(SQL.Update.sql);
            pst.setString(1, rs.getString("no"));
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return vData;
    }


    private enum SQL {
        Insert("insert into board(title, name, pw, email, contents) values(?, ?, ?, ?, ?)"),
        Select("select no, title, name, wTime, rCnt from board order by no desc"),
        Delete("delete from board where no = ?"),
        Update("update board set rCnt = rCnt+1 where no = ?");

        final String sql;
        SQL(String sql) {
            this.sql = sql;
        }

        }
    private enum Format {
        Select("<tr>" +
                "   <td>%d</td>" +
                "   <td><a href=/ViewData?index=%d>%s</a></td>" +
                "   <td><a href=/ViewData?index=%d>%s</a></td>" +
                "   <td>%s</td>" +
                "   <td>%s</td>"),
        Update("update board set title = ?, name = ?, contents = ? where no = %d"),
        SelectView("select no, title, name, wTime, contents, pw from board where no = %d");

        final String format;

        Format(String format) {
            this.format = format;
        }
    }
}
