package controllers;

import com.avaje.ebean.Ebean;
import models.Order;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.OrderService;

public class OrderController extends Controller{
    private OrderService orderService = OrderService.ORDER_SERVICE;

    public Result addOrder() {
        Http.RequestBody body = request().body();
//        Order order = Order.getOrder(body.asJson());
//        order.save();
        Order order = new Order("na2me",2,2,"sad2sik","asd");
//        Ebean.save(order);
        return ok(
                Ebean.json().toJson(
                        orderService.addOrder(order)
                )
        );
    }

    public Result cancelOrder(int orderId) {
        return  ok(
                Ebean.json().toJson(
                        orderService.cancelOrder(orderId)
                )
        );
    }

    public Result getOrders(String username, int page) {
        return ok(
                Ebean.json().toJson(
                        orderService.getOrders(username,page)
                )
        );
    }

    public Result getProducts(int page) {
        return ok(Ebean.json().toJson(
                orderService.getProducts(page)
        ));
    }


}
