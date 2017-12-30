package models;

import com.google.gson.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Order {
    private int orderNo;
    private final String username;
    private final int numberOfOrder;
    private final int status;
    private final String  productName;
    private final String desiredProperties;

    private Order(String username, int numberOfOrder, int status, String productName, String desiredProperties) {
        this.username = username;
        this.numberOfOrder = numberOfOrder;
        this.status = status;
        this.productName = productName;
        this.desiredProperties = desiredProperties;
    }

    public int getOrderNo() {
        return orderNo;
    }

    private void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public String getUsername() {
        return username;
    }

    public int getNumberOfOrder() {
        return numberOfOrder;
    }

    public int getStatus() {
        return status;
    }

    public String getProductName() {
        return productName;
    }

    public String getDesiredProperties() {
        return desiredProperties;
    }

}
