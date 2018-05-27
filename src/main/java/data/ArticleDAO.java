package data;
import transferobject.Article;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ArticleDAO {

    void addArticle(Article article) throws SQLException;
    Article getArticle(int id) throws SQLException;
    void deleteArticle(Article article);
    void reduceAmount(int amount, int id) throws SQLException;
    ArrayList<Article> getArticle();
}
