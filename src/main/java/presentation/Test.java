package presentation;

import businesslogic.ArticleManager;
import businesslogic.ShoppingCartManager;
import transferobject.Article;
import transferobject.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns ={ "/Test" })

public class Test extends HttpServlet {

    public Test() {
        super();
    }


    public void init() throws ServletException {
        super.init();



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();


        ArticleManager manager = new ArticleManager();
        ArrayList<Article> a = manager.getArticle();

        ShoppingCartManager shopManager = new ShoppingCartManager();
        ShoppingCart cart =  shopManager.createShopCart(a);
        int calc = shopManager.calculate(cart);



        writer.println("<!doctype html>");
        writer.println("<html>");
        writer.println("<head><title>2. Praktikum WebEng</title></head>");
        writer.println("<body>");
        writer.println("<h3>Artikel im Shop</h3><br>");

        writer.println("<table width = \"50%\" border = \"1 solid\" align = \"center\">");
        writer.println("<tr>");
        writer.println("<th>ID </th>");
        writer.println("<th>Name </th>");
        writer.println("<th>Price </th>");
        writer.println("<th>Amount </th>");
        writer.println("</tr>");

        for(Article article : a ) {
            writer.println("<tr>");

            writer.println("<td>"+article.id+"</td>");
            writer.println("<td>"+article.name+"</td>");
            writer.println("<td>"+article.price+"</td>");
            writer.println("<td>"+article.amount+"</td>");
            writer.println("</tr>");
        }

        writer.println("</table>");
        writer.println("<p>Summe: "+calc);
        writer.println("</p><br>");
        try {
            shopManager.checkout(cart);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        a = manager.getArticle();

        writer.println("<table width = \"50%\" border = \"1 solid\" align = \"center\">");
        writer.println("<tr>");
        writer.println("<th>ID </th>");
        writer.println("<th>Name </th>");
        writer.println("<th>Price </th>");
        writer.println("<th>Amount </th>");
        writer.println("</tr>");

        for(Article article : a ) {
            writer.println("<tr>");

            writer.println("<td>"+article.id+"</td>");
            writer.println("<td>"+article.name+"</td>");
            writer.println("<td>"+article.price+"</td>");
            writer.println("<td>"+article.amount+"</td>");
            writer.println("</tr>");
        }

        writer.println("</table>");
        writer.println("<p>Summe: "+shopManager.calculate(cart));

        writer.println("<body>");
        writer.println("</html>");

        writer.close();
    }


}
