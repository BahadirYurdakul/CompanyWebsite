package DAO;

import com.avaje.ebean.Ebean;
import models.Article;

import java.util.Date;
import java.util.List;

import static com.avaje.ebean.Model.db;

public enum Repository {
    REPOSITORY;

    public Article addArticle(Article article) {
        article.setDate(new Date().toString());
        article.save();
        List<Article> list = Ebean.find(Article.class)
                .where()
                .eq("title", article.getTitle())
                .findList();
        return list.get(0);
    }

    public Article getArticle(int articleId) {
        return db().find(Article.class,articleId);
    }

    public List<Article> getArticles(int page) {
        int pageSize = 10;
        return
                db().find(Article.class).where()
                        .order().desc("articleId")
                        .findPagedList(page, pageSize)
                        .getList();
    }

}