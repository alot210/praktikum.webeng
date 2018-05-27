<%@ page import="data.ArticleDAO" %>
<%@ page import="data.H2FactoryDAO" %>
<%@ page import="transferobject.ShoppingCart" %>
<%@ page import="businesslogic.ShoppingCartManager" %>
<%@ page import="transferobject.Article" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: otten
  Date: 24.05.2018
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Warenkorb</title>
</head>
<body>
<h3>Warenkorb: </h3>

<table>
    <tr>
        <th>Artikel-Id</th>
        <th>Name</th>
        <th>Preis</th>
        <th>Anzahl</th>
    </tr>
    <%
        ArticleDAO articleDAO = H2FactoryDAO.getDaoArticle();
        ShoppingCartManager cartManager = new ShoppingCartManager();
        ArrayList<Article> articles = new ArrayList<>();
        ShoppingCart cart;
        if (session.getAttribute("Cart") != null) {
            cart = (ShoppingCart) session.getAttribute("Cart");
        } else {
            cart = cartManager.createShopCart(articles);
        }
        String param = request.getParameter("Add");
        String param2 = request.getParameter("Delete");

        if (param != null) {
            int value = Integer.parseInt(param);
            cartManager.addArticle(cart, value);
            session.setAttribute("Cart", cart);
        }

        if (param2 != null) {
            int value = Integer.parseInt(param2);
            cartManager.deleteArticle(cart, value);
            session.setAttribute("Cart", cart);
        }

        articles = cart.articleList;
        int index = 0;
        for (Article article : articles) {
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
        <td>
            <form action="Artikel.jsp">
                <button type="submit " name="Delete" value=<%=index%>>aus dem Warenkorb entfernen</button>
            </form>
        </td>
        <% index ++;%>
    </tr>
    <%}%>
</table>
<br>
<p>Preis: <%=cartManager.calculate(cart)%>
</p>
</body>
</html>
