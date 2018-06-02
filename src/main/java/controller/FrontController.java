package controller;

import businesslogic.ArticleManager;
import businesslogic.ShoppingCartManager;
import data.ArticleDAO;
import data.H2FactoryDAO;
import transferobject.Article;
import transferobject.ShoppingCart;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

@WebServlet(urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    public FrontController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher;
        String action = request.getParameter("action");
        String redirect = "";

        String authToken = "Webeng";
        String param = request.getParameter("token");


        if (action == null) {
            action = "";
        }

        switch (action) {
            case "addarticle":
                System.out.print("addarticle");
                String id = request.getParameter("artikelid");
                String name = request.getParameter("artikelname");
                String preis = request.getParameter("preis");
                String anzahl = request.getParameter("anzahl");

                if (param != null && param.equals(authToken)) {
                    if(request.getParameter("send") == null) {
                        redirect = "/webShop/ArtikelService.jsp";
                        dispatcher = request.getRequestDispatcher(redirect);
                        dispatcher.forward(request, response);
                    }
                    else if (id != null && !id.equals("") && name != null && !name.equals("") && preis != null && !preis.equals("") && anzahl != null && !anzahl.equals("")) {
                        ArticleManager manager = new ArticleManager();
                        manager.createArticle(Integer.parseInt(id), name, Integer.parseInt(preis), Integer.parseInt(anzahl));
                        request.getSession().setAttribute("articleList", manager.getArticle());
                        redirect = "/FrontController?action=articlelist";
                        dispatcher = request.getRequestDispatcher(redirect);
                        dispatcher.forward(request, response);
                    }
                } else {
                    response.setStatus(403);
                }

                break;
            case "articlelist":

                ArticleManager articleManager = new ArticleManager();
                ArrayList<Article> article = articleManager.getArticle();
                ArrayList<Article> article2 = new ArrayList<>();
                ShoppingCartManager cartManager = new ShoppingCartManager();
                ShoppingCart cart = null;

                HttpSession session = request.getSession();
                if (session.getAttribute("cart") != null) {
                    cart = (ShoppingCart) session.getAttribute("cart");
                } else {
                    cart = cartManager.createShopCart(article2);
                }

                String paramAdd = request.getParameter("Add");
                String paramDelete = request.getParameter("Delete");
                try {
                    if (paramAdd != null) {
                        System.out.println("add");
                        int value = Integer.parseInt(paramAdd);
                        cartManager.addArticle(cart, value);
                        session.setAttribute("cart", cart);
                    }

                    if (paramDelete != null) {
                        int value = Integer.parseInt(paramDelete);
                        cartManager.deleteArticle(cart, value);
                        session.setAttribute("cart", cart);
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }

                session.setAttribute("cart", cart);
                session.setAttribute("cartManager", cartManager);
                session.setAttribute("articleList", article);

                redirect = "/webShop/Artikel.jsp";

                dispatcher = request.getRequestDispatcher(redirect);
                dispatcher.forward(request, response);

                break;
            case "articledetails":
                String param1 = request.getParameter("id");
                ArticleDAO articleDAO = H2FactoryDAO.getDaoArticle();
                try {

                    Article a = articleDAO.getArticle(Integer.parseInt(param1));
                    request.setAttribute("article", a);


                } catch (SQLException e) {
                    System.out.println("SQL Exception");
                }
                redirect = "/webShop/Detail.jsp";
                dispatcher = request.getRequestDispatcher(redirect);
                dispatcher.forward(request, response);
                break;
            case "checkout":

                session = request.getSession(true);

                ShoppingCartManager cM = new ShoppingCartManager();

                String s = request.getParameter("Kaufen");

                cart = (ShoppingCart) session.getAttribute("cart");
                try {
                    if (s != null) {
                        cM.checkout(cart);
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }
                session.setAttribute("shopCart", cart);
                redirect = "/webShop/Checkout.jsp";
                dispatcher = request.getRequestDispatcher(redirect);
                dispatcher.forward(request, response);
                break;

            default:
            case "":
            case "home":
                redirect = "/";
                dispatcher = request.getRequestDispatcher(redirect);
                dispatcher.forward(request, response);
                break;

        }


    }

}
