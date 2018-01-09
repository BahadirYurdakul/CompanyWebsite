package DataAccessObject;

import com.avaje.ebean.Ebean;
import models.Article;
import models.Order;
import models.Product;
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

    public Article getArticle(String title) {
        return db().find(Article.class).where()
                .eq("title",title)
                .findList().get(0);
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
        return user;
    }

    public boolean isUserExist(String username) {
        return Ebean.find(User.class).where()
                .eq("username", username)
                .findList().size() != 0;
    }

    public List<Order> getOrders(String username, int page) {
        int pageSize = 10;
        return
                db().find(Order.class).where()
                        .eq("username",username)
                        .orderBy("orderno")
                        .findPagedList(page, pageSize)
                        .getList();
    }

    public Order addOrder(Order order) {
        Ebean.createSqlUpdate("INSERT INTO `db`.`order` (`username`, `numberoforder`, `status`, `productname`," +
                " `desiredproperties`) VALUES ('"+order.getUsername()+"', '"+order.getNumberOfOrder()+"', '"
                +order.getStatus()+"', '"+order.getProductName()+"', '"+order.getDesiredProperties()+"');\n").execute();
//      return db().find(Order.class)
//                .where().eq("username",order.getUsername())
//                .order().desc("orderNo").findList().get(0);
        return db().find(Order.class,1);
    }

    public Order getOrder(int orderId) {
        return Ebean.find(Order.class).where()
                .eq("orderId",orderId)
                .findList().get(0);
    }

    public Order cancelOrder(int orderId) {
        Order order = Ebean.find(Order.class,orderId);
        assert order != null;
        order.setStatus(2);
        order.save();
        return Ebean.find(Order.class,orderId);
    }

    public List<Product> getProducts(int page) {
        int pageSize = 10;
        return
                db().find(Product.class).where()
                        .order().desc("productName")
                        .findPagedList(page, pageSize)
                        .getList();
    }
}