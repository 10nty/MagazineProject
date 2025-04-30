package main.Java.com.Servlets;

import main.Java.com.utils.PasswordUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Устанавливаем параметры подключения
        String url = "jdbc:mysql://localhost:8889/shopdb";  // Порт и база данных
        String username = "root";
        String password = "root";

        // Получаем параметры запроса из формы (например, для логина)
        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        try {
            // Устанавливаем соединение с базой данных
            Connection conn = DriverManager.getConnection(url, username, password);

            // Выполняем SQL-запрос (например, для проверки пользователя)
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, user);
            stmt.setString(2, pass);

            ResultSet rs = stmt.executeQuery();

            // Если пользователь найден
            if (rs.next()) {
                // Успешный вход, перенаправляем на главную страницу
                response.sendRedirect("home.jsp");
            } else {
                // Ошибка, возвращаем на страницу входа с сообщением
                request.setAttribute("errorMessage", "Неверный логин или пароль!");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }

            // Закрываем соединение
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Обработка ошибок
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Ошибка при подключении к базе данных");
        }
    }
}