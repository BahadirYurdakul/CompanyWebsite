package models;


import com.avaje.ebean.Model;
import com.fasterxml.jackson.databind.JsonNode;
import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order extends Model {

    @Id
    @Column(name = "orderno")
    private int orderNo;

    @Constraints.Required
    @Column(name = "username")
    private String username;

    @Constraints.Required
    @Column(name = "numberoforder")
    private int numberOfOrder;

    @Constraints.Required
    @Column(name = "status")
    private int status;

    @Constraints.Required
    @Column(name = "productName")
    private String  productName;

    @Constraints.Required
    @Column(name = "desiredProperties")
    private String desiredProperties;

    public Order(String username, int numberOfOrder, int status, String productName, String desiredProperties) {
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

    public void setStatus(int status) {
        this.status = status;
    }

    public String getProductName() {
        return productName;
    }

    public String getDesiredProperties() {
        return desiredProperties;
    }

    public static Order getOrder(JsonNode jsonNode) {
        return new Order(jsonNode.get("username").asText(),jsonNode.get("numberOfOrder").asInt()
                        ,jsonNode.get("status").asInt(),jsonNode.get("productName").asText()
                        ,jsonNode.get("desiredProperties").asText());
    }

}
