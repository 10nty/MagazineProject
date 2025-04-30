<%@ page import="java.sql.*" %>
<%
    String role = (String) session.getAttribute("role");
    if (!"admin".equals(role)) {
        response.sendRedirect("index.jsp");
        return;
    }

    Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/shopdb", "root", "password");

    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM orders ORDER BY order_date DESC");
%>
<h2>Список заказов</h2>
<table border="1">
    <tr><th>ID</th><th>Сумма</th><th>Дата</th></tr>
    <%
        while (rs.next()) {
    %>
    <tr>
        <td><%= rs.getInt("id") %></td>
        <td><%= rs.getDouble("total") %></td>
        <td><%= rs.getTimestamp("order_date") %></td>
    </tr>
    <%
        }
        conn.close();
    %>
</table>
<a href="index.jsp">← Назад</a>