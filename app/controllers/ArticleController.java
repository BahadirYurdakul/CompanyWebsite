package controllers;

import com.avaje.ebean.Ebean;
import com.google.gson.Gson;
import models.Article;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.ArticleService;

/**
 * Controller layer is the connection layer between client and server.
 * This layer gets input and ;
 * -> Converts an Article object
 * -> Validates if it is an Article object
 * -> Call service layer for required operations
 * -> Returns the result to the client.
 */
public class ArticleController extends Controller {
    private ArticleService articleService = ArticleService.ARTICLE_SERVICE;
    /**
     * Checks if it is an Article object; if it isn't returns badRequest; if it is,
     * Calls ArticleService to add an article to the database
     * @return Json object of the article
     */
    public Result addArticle() {
            try {
                Http.RequestBody body = request().body();
                Article article = new Gson().fromJson(body.asText(),Article.class);
                return ok(Ebean.json().toJson(
                        articleService.addArticle(article)
                ));
            } catch (Exception e){
                System.out.println(e);
                return badRequest("Adding Article Failed! Please check all inputs!").as("text/html");
            }
       }

    /**
     * Calls ArticleService layer to get a specific article by using articleId
     * @param articleId is the unique integer number of each article
     * @return the article object of given article Id
     */
    public Result getArticle(String title) {
        try {
            Gson gson = new Gson();
            Article article = articleService.getArticle(title);
            return ok(Ebean.json().toJson(article));
        } catch (Exception e) {
            System.out.println(e);
            return notFound("Not found! Please check again!");
        }
    }

    /**
     * Calls its service layer to get the list of the titles of specific page number
     * @param page is the given page number
     * @return list of the title as String[]
     */
    public Result getArticleList(int page) {
        try {
            return ok(Ebean.json().toJson(
                    articleService.getArticles(page)
            ));
        } catch (Exception e) {
            return badRequest("invalid entry");
        }
    }


}
