<%
    String user = (String) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head><title>Главная</title></head>
<body>
<h1>Добро пожаловать, <%= user %>!</h1>
<a href="logout">Выйти</a>
<%
    if ("admin".equals(session.getAttribute("role"))) {
%>
<br><a href="admin.jsp">Админ-панель</a>
<%
    }
%>
</body>
</html>