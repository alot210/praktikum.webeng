package presentation;

import businesslogic.ArticleManager;

import transferobject.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(urlPatterns ={ "/Bootstrap" })
public class Bootstrap extends HttpServlet {

    public Bootstrap() {
        super();
    }

    public void init() throws ServletException {
        super.init();


        ArticleManager manager = new ArticleManager();
        manager.createArticleTable();
        manager.createArticle(1, "Kaffee", 2, 10);
        manager.createArticle(2, "Tee", 2, 20);
        manager.createArticle(3, "Mate", 3, 8);
        manager.createArticle(4, "Matcha", 5, 12);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();


        ArticleManager manager = new ArticleManager();
        ArrayList<Article> a = manager.getArticle();

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


        writer.println("<body>");
        writer.println("</html>");

        writer.close();
    }
}
