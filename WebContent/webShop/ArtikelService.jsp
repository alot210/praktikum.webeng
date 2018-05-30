<%--
  Created by IntelliJ IDEA.
  User: otten
  Date: 27.05.2018
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Artikel hinzufügen</title>
</head>
<body>
<h3>Artikel hinzufügen:</h3>
<br>
    <form action="addarticle">
        <label>Artikel-ID</label>
            <input type="number" name="artikelid" min="1" required="required">
        <br>
        <br>
        <label>Artikelname</label>
            <input type="text" name="artikelname" required="required">
        <br>
        <br>
        <label>Preis</label>
            <input type="number" name="preis" min="1" required="required">
        <br>
        <br>
        <label>Anzahl</label>
        <input type="number" name="anzahl" min="1" required="required">
        <button name="send">Senden</button>
    </form>
</body>
</html>
