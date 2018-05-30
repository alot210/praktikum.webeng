package controller;

import businesslogic.ArticleManager;
import transferobject.Article;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns = {"/"})
public class FrontController extends HttpServlet {

    public FrontController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request,response);
    }

    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher;
        String action = request.getParameter("action");
        String redirect = "";

        String authToken = "Webeng";
        String param = request.getParameter("token");


        if(action == null) {
            action = "";
        }

        switch (action) {
            case "addarticle":
                System.out.print("addarticle");
                if(param!=null && param.equals(authToken)){
                    redirect = "/webShop/ArtikelService.jsp";
                    dispatcher = request.getRequestDispatcher(redirect);
                    dispatcher.forward(request,response);
                } else {
                    response.setStatus(403);
                }

                break;
            case "articlelist":

                ArticleManager articleManager = new ArticleManager();
                ArrayList<Article> article = articleManager.getArticle();

                System.out.println(article);
                HttpSession session = request.getSession(true);
                request.setAttribute("articleList", article);

                redirect = "/webShop/Artikel.jsp";


            break;
            case "articledetails":
                break;
            case "checkout":
                break;

            default:
                case"":
                case "home":
                redirect = "/";
                break;

        }

        dispatcher = request.getRequestDispatcher(redirect);
        dispatcher.forward(request,response);

    }

}
