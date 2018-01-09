package services;

import DataAccessObject.Repository;
import models.Article;
import java.util.List;

/**
 * Service layer has all the business layer
 * -> It calls DAO functions to connect repository
 * -> It gets Article object input from Controller layer and does given task to
 * Repository.
 */
public  enum  ArticleService {
    ARTICLE_SERVICE;

    private Repository repository = Repository.REPOSITORY;


    /**
     *Adding article object to db
     * @param article object
     * @return article object from database which is added.
     */
    public Article addArticle(Article article) {
            return repository.addArticle(article);
    }

    /**
     * Gets all titles of the articles of the given page
     * @param page page number
     * @return title list
     */
    public List<Article> getArticles(int page) {
        return repository.getArticles(page);
    }

    /**
     * Gets a specific article
     * @param title is the unique identifier of the article
     * @return article object.
     */
    public Article getArticle(String title) {
        return repository.getArticle(title);
    }


}
