package businesslogic;

import data.H2ArticleDAO;
import data.H2FactoryDAO;
import transferobject.Article;
import transferobject.ShoppingCart;

import java.sql.SQLException;
import java.util.ArrayList;

public class ShoppingCartManager {

    public ShoppingCartManager() {}

    public void addArticle(ShoppingCart cart, int id) throws SQLException {

        Article a = H2FactoryDAO.getDaoArticle().getArticle(id);
        a.setAmount(1);
        cart.articlel.add(a);
    }

    public void deleteArticle(ShoppingCart cart, int index) throws SQLException {
        cart.articlel.remove(index);
    }

    public void checkout(ShoppingCart cart) throws SQLException {

        System.out.println(cart);
        H2ArticleDAO daoArticle = H2FactoryDAO.getDaoArticle();

        for(Article article: cart.articlel){
            int amount = daoArticle.getArticle(article.getId()).getAmount();
            int id = article.getId();
            daoArticle.reduceAmount(amount-1,id);
        }
        cart.articlel.clear();
        cart.sum = 0;
    }

    public int calculate(ShoppingCart cart) {
        int summe = 0;

        for(Article article : cart.articlel) {
            summe += article.getPrice();
        }

        cart.sum = summe;
        return summe;
    }

    public ShoppingCart createShopCart(ArrayList<Article> articles) {
        ShoppingCart cart = new ShoppingCart(articles);
        return cart;
    }
}