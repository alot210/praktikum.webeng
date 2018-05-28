package controller;

import sun.misc.Request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    public FrontController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);

    }

    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher;
        String action = request.getParameter("action");
        String redirect = "";

        String AuthToken = "Webeng";


        if(action == null) {
            action = "";
        }

        switch (action) {
            case "addarticle":
                System.out.print("addarticle");
                String queryString = request.getParameter("AuthToken");
                if(queryString!=null){
                    redirect = "/webShop/ArtikelService.jsp";
                }

                break;
            case "articlelist":
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
