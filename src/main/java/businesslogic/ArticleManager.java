package businesslogic;

import data.H2ArticleDAO;

import data.H2FactoryDAO;
import transferobject.Article;

import java.sql.SQLException;
import java.util.ArrayList;

public class ArticleManager {

    public void createArticle(int id, String name, int price, int amount) {
        Article article = new Article(id,name,price,amount);

        H2ArticleDAO daoArticle = H2FactoryDAO.getDaoArticle();

        try  {
            daoArticle.addArticle(article);
        }
        catch (SQLException sql){
            System.out.println(sql);
        }
    }

    public void createArticleTable() {
        H2ArticleDAO daoArticle = H2FactoryDAO.getDaoArticle();
        daoArticle.createArticleTable();
    }


    public ArrayList<Article> getArticle() {
        H2ArticleDAO daoArticle = H2FactoryDAO.getDaoArticle();
        return daoArticle.getArticle();
    }

}
