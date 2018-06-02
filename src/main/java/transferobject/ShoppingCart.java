package transferobject;

import java.util.ArrayList;


public class ShoppingCart {

    public ArrayList<Article> articlel;
    public int sum;

    public ShoppingCart(ArrayList<Article> _articleList) {

        articlel = _articleList;
        sum = 0;

    }

    //TODO: getter und setter
    public boolean addArticle(Article _article) {
        return articlel.add(_article);
    }

}
