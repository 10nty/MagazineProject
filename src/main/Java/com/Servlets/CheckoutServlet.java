package main.Java.com.Servlets;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<String> cart = (List<String>) session.getAttribute("cart");

        if (cart != null && !cart.isEmpty()) {
            double total = cart.size() * 10; // Предположим, что каждый товар стоит 10

            try (Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:8889/shopdb", "root", "root")) {

                String sql = "INSERT INTO orders (total) VALUES (?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setDouble(1, total);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            cart.clear();
            resp.sendRedirect("thankyou.jsp");
        } else {
            resp.sendRedirect("cart.jsp");
        }
    }
}