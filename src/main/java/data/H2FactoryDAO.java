package data;

public class H2FactoryDAO{

    public static H2ArticleDAO getDaoArticle() {
        return  new H2ArticleDAO();
    }
}
