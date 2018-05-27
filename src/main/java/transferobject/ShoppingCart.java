package transferobject;

import java.util.ArrayList;


public class ShoppingCart {

    public ArrayList<Article> articleList;
    public int sum;

    public ShoppingCart(ArrayList<Article> _articleList) {

        articleList = _articleList;
        sum = 0;

    }

    //TODO: getter und setter
    public boolean addArticle(Article _article) {
        return articleList.add(_article);
    }

}
