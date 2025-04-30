<%@ page import="java.util.*" %>
<%
    List<String> cart = (List<String>) session.getAttribute("cart");
    if (cart == null) {
        cart = new ArrayList<>();
        session.setAttribute("cart", cart);
    }
%>

<h2>Корзина</h2>
<%
    if (cart.isEmpty()) {
%>
<p>Корзина пуста</p>
<%
} else {
%>
<ul>
    <%
        for (String item : cart) {
    %>
    <li><%= item %></li>
    <%
        }
    %>
</ul>
<form action="checkout" method="post">
    <button type="submit">Оформить заказ</button>
</form>
<%
    }
%>
<a href="index.jsp">Назад</a>