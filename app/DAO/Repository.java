package DAO;

import com.avaje.ebean.Ebean;
import models.Article;
import models.Order;
import models.User;

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

    public User addUser(User user) {
        user.save();
        User getUser = Ebean.find(User.class).where()
                .eq("username",user.getUsername())
                .findList().get(0);
        getUser.setPassword("");
        return getUser;
    }

    public User changeUserInfo(User user) {
        User.db().update(user);
        User getUser = Ebean.find(User.class).where()
                .eq("username",user.getUsername())
                .findList().get(0);
        getUser.setPassword("");
        return getUser;
    }

    public User getUser(String username) {
        User user = Ebean.find(User.class).where()
                .eq("username",username)
                .findList().get(0);
        user.setPassword("");
        return user;
    }

    public List<Order> getOrders(int page) {
        int pageSize = 10;
        return
                db().find(Order.class).where()
                        .order().desc("orderNo")
                        .findPagedList(page, pageSize)
                        .getList();
    }
}