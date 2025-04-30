package main.Java.com.Servlets;

import main.Java.com.utils.PasswordUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String rawPassword = req.getParameter("password");
        String hashedPassword = PasswordUtil.hashPassword(rawPassword);

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/shopdb", "root", "password")) {

            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, hashedPassword);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                HttpSession session = req.getSession();
                session.setAttribute("user", username);
                session.setAttribute("role", rs.getString("role"));
                resp.sendRedirect("index.jsp");
            } else {
                resp.getWriter().println("Неверный логин или пароль");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

