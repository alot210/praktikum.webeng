<%@ page import="businesslogic.ArticleManager" %>
<%@ page import="transferobject.Article" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="data.ArticleDAO" %>
<%@ page import="data.H2FactoryDAO" %>
<%@ page import="transferobject.ShoppingCart" %>
<%@ page import="businesslogic.ShoppingCartManager" %>
<%@ page import="transferobject.Article" %>
<%@ page import="java.util.ArrayList" %>
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
<%--<%RequestDispatcher requestDispatcher = request.getRequestDispatcher("Warenkorb.jsp");
    requestDispatcher.include(request, response);
%>--%>
<jsp:useBean id="articleList" type="java.util.ArrayList" scope="request"></jsp:useBean>
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

        <td><a href="Detail.jsp?id=<%=article.getId()%>">Link zum Artikel</a></td>
    </tr>
    <%}%>
</table>
<br>
<br>

<form action="Checkout.jsp">
    <button type="submit" name="Kaufen" value="Checkout">Kaufen</button>
</form>

<%--<% request.setAttribute("Cart", cart);%>--%>

<%--<a href="../FrontController?action=addarticle">Artikel hinzufügen</a>--%>
<br>
</body>
</html>
