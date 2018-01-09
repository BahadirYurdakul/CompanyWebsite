package services;

import models.Order;
import DataAccessObject.Repository;
import models.Product;

import java.util.List;

public enum  OrderService {
    ORDER_SERVICE;
    private static Repository repository = Repository.REPOSITORY;

    public Order addOrder(Order order) {
       return repository.addOrder(order);
    }

    public Order cancelOrder(int orderId) {
        return repository.cancelOrder(orderId);
    }

    public List<Order> getOrders(String username, int page) {
        return repository.getOrders(username,page);
    }

    public List<Product> getProducts(int page) {
        return repository.getProducts(page);
    }
}
