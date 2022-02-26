package ru.javavision.servlet;

import sun.rmi.runtime.Log;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;
import java.io.*;
import java.sql.*;

public class GetIndexPageServlet extends HttpServlet {
    Connection con;
    Statement stmt;

    public void DBConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:sqlite:D:\\userdata.db"; // Я не смог пока что указать относительный путь
                                                    // Пожалуйста, переместите БД куда вам будет удобнее
                                                    // и укажите к нему путь в переменной "url"
        String user = "root";
        String password = "";

        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Statement getStatement() {
        try {
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stmt;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\"/>");
        out.println("</head>");
        try {
            DBConnection();
            getStatement();
            String Login, Password, Name, EMail, Gender, BDay, FavColor, Description, Mailing, UsrAgrmnt;
            Login = req.getParameter("login");
            Password = req.getParameter("password");
            Name = req.getParameter("name");
            EMail = req.getParameter("email");
            Gender = req.getParameter("gender");
            BDay = req.getParameter("bday");
            FavColor = req.getParameter("favColor");
            Description = req.getParameter("description");
            Mailing = req.getParameter("mailing");
            UsrAgrmnt = req.getParameter("usrAgrmnt");;
            out.println(Login + " " + Password + " " + Name + " " + EMail + " " + Gender + " " + BDay + " " + FavColor + " " + Description);
            if(Login.length() > 3 || Password.length() > 3 || Name.length() > 3 || EMail.length() > 3)
            {
                stmt.executeUpdate("INSERT INTO users (Login, Password, Name, EMail, Gender, BDay, FavColor, Mailing, UsrAgrmnt, Description) values ('" + Login + "', '" + Password + "', '" + Name + "', '" + EMail + "', '" + Gender + "', '" + BDay + "', '" + FavColor + "', '" + Mailing + "', '" + UsrAgrmnt + "', '" + Description + "')");
                out.println("Database has been successfully updated");
            }
            stmt.close();
            /*getStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM users");
            while (res.next()) {
                out.println(res.getString("ID") + " - " + res.getString("Name") + " " + res.getString("EMail"));
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("There was an error writing data to the database, double-check the entered data and try again");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        out.println("</html>");
        out.close();
    }
}
