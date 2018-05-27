<%--
  Created by IntelliJ IDEA.
  User: otten
  Date: 21.05.2018
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSPTest</title>
</head>
<body>
<%!
    int erg2 = 3 * 5;
%>
<%
    System.out.println("inside JSP");
    int erg = (int) Math.pow(5, 2);
%>


<p><h4>Aktuelle Datum:</h4>
<%=new java.text.SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date())%>
</p>
<br>
<p>
    5^2=
    <%=erg%><br>
    3x5=
    <%=erg2%>

</p>

<p>
<h4>Passwort Generator:</h4><br>
<%
    HttpServletRequest r = (HttpServletRequest) request;
    String codeValue = "";
    String shifted = "";
    if (r.getParameter("codeValue") == null
            || r.getParameter("codeValue").equals("")
            || r.getParameter("shiftValue") == null
            || r.getParameter("shiftValue").equals("")) {
        System.out.println("Ungueltige Eingabe, bitte füllen sie die Felder aus!");
    } else {
        codeValue = r.getParameter("codeValue");
        int shift = Integer.parseInt(r.getParameter("shiftValue"));
        char[] chars = codeValue.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] -= 'a';
            chars[i] += shift;
            chars[i] = (char) (chars[i] % 26);
            chars[i] += 'a';
        }
        shifted = new String(chars);
    }

%>
<form name="generator" method="POST">
    Codewort: <input type='TEXT' name='codeValue' required/>
    Verschiebung: <input type='TEXT' name='shiftValue' required/>
    <button type='submit' name='submit' value='submit'>Submit</button>
</form>
<br>
Codewort:<%= codeValue%> <br>
Ergebnis:<%= shifted%>
</p>
<p>
    HTTP-Method: <%= r.getMethod()%><br>
    Param: <%= r.getServletContext().getInitParameter("Mate")%>
</p>
</body>
</html>
