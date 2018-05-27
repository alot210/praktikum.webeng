<%@ page import="businesslogic.ShoppingCartManager" %>
<%@ page import="transferobject.ShoppingCart" %><%--
  Created by IntelliJ IDEA.
  User: otten
  Date: 25.05.2018
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Checkout</title>
</head>
<body>
<%
    ShoppingCartManager cartManager = new ShoppingCartManager();

    String s = request.getParameter("Kaufen");

    ShoppingCart cart = (ShoppingCart) session.getAttribute("Cart");
    if (s!=null) {
        cartManager.checkout(cart);
    }
%>
<h2>Danke für Ihren Einkauf!</h2>
<a href="Artikel.jsp">zurück zur Artikelübersicht</a>
</body>
</html>
