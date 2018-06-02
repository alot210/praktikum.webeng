<%@ page import="transferobject.Article" %>
<%@ page import="java.util.*" %>

<%--
  Created by IntelliJ IDEA.
  User: otten
  Date: 24.05.2018
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Artikel</title>
    <style>
        table, th, tr, td {
            border: 1px solid black;
            border-collapse: collapse;
            align: center;
            align-items: center;
            align-content: center;
        }

        table {
            width: 50%;
        }
    </style>
</head>
<body>
<jsp:useBean id="articleList" type="java.util.ArrayList" scope="session"></jsp:useBean>
<jsp:useBean id="cart" type="transferobject.ShoppingCart" scope="session"></jsp:useBean>
<jsp:useBean id="cartManager" type="businesslogic.ShoppingCartManager" scope="session"></jsp:useBean>
<h3>Warenkorb: </h3>
<table>
    <tr>
        <th>Artikel-Id</th>
        <th>Name</th>
        <th>Preis</th>
        <th>Anzahl</th>
    </tr>
    <%
        int index = 0;
        for (Article article2 : cart.articlel) {
    %>

    <tr>
        <td><%=article2.id%>
        </td>
        <td><%=article2.name%>
        </td>
        <td><%=article2.price%>
        </td>
        <td><%=article2.amount%>
        </td>
        <td>
            <form action="/webengShop/FrontController">
                <input type="hidden" name="action" value="articlelist">
                <button type="submit " name="Delete" value=<%=index%>>aus dem Warenkorb entfernen</button>
            </form>
        </td>
        <% index++;%>
    </tr>
    <%}%>
</table>
<br>
<p>Preis: <%=cartManager.calculate(cart)%>
</p>
<h3>Artikel: </h3>


<table>
    <tr>
        <th>Artikel-Id</th>
        <th>Name</th>
        <th>Preis</th>
        <th>Anzahl</th>
        <th>Link</th>
    </tr>
    <%
        Iterator i = articleList.iterator();
        while (i.hasNext()) {
            Article article = (Article)i.next();

    %>
    <tr>
        <td><%=article.id%>
        </td>
        <td><%=article.name%>
        </td>
        <td><%=article.price%>
        </td>
        <td><%=article.amount%>
        </td>

        <td><a href="/webengShop/FrontController?action=articledetails&id=<%=article.getId()%>">Link zum Artikel</a></td>
    </tr>
    <%}%>
</table>
<br>
<br>

<form action="/webengShop/FrontController">
    <input type="hidden" name="action" value="checkout">
    <button type="submit" name="Kaufen" value="checkout">Kaufen</button>
</form>

<%--<% request.setAttribute("Cart", cart);%>--%>

<%--<a href="../FrontController?action=addarticle">Artikel hinzufügen</a>--%>
<br>
</body>
</html>
