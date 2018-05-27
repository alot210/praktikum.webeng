<%@ page import="data.ArticleDAO" %>
<%@ page import="data.H2FactoryDAO" %>
<%@ page import="transferobject.Article" %><%--
  Created by IntelliJ IDEA.
  User: otten
  Date: 25.05.2018
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
</head>
<body>

<% String queryString = request.getParameter("id");
    ArticleDAO articleDAO = H2FactoryDAO.getDaoArticle();
    Article article = articleDAO.getArticle(Integer.parseInt(queryString));
%>
<h3>Artikeldetails</h3>
<table>
    <tr>
        <th>Artikelname</th>
        <th>Preis</th>
        <th>Anzahl</th>
    </tr>
    <tr>
        <td><%=article.getName()%>
        </td>
        <td><%=article.getPrice()%>€</td>
        <td><%=article.getAmount()%>
        </td>
    </tr>
</table>
<br>

<form action="Artikel.jsp">
    <button type="submit" name="Add" value=<%=article.getId()%>>
        in den Warenkorb
    </button>
</form>


<br>
<a href="Artikel.jsp">zurück zur Artikelübersicht</a>
</body>
</html>
