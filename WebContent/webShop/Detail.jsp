<%--
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
<jsp:useBean id="article" class="transferobject.Article" type="transferobject.Article" scope="request"></jsp:useBean>

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

<form action="/webengShop/FrontController">
    <input type="hidden" name="action" value="articlelist">
    <button type="submit" name="Add" value=<%=article.getId()%>>
        in den Warenkorb
    </button>
</form>
<br>
<a href="/webengShop/FrontController?action=articlelist">zurück zur Artikelübersicht</a>
</body>
</html>
