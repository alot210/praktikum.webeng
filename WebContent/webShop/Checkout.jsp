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
<jsp:useBean id="shopCart" type="transferobject.ShoppingCart" scope="session"></jsp:useBean>
<h2>Danke für Ihren Einkauf!</h2>
<a href="/webengShop/FrontController?action=articlelist">zurück zur Artikelübersicht</a>
</body>
</html>
