package models;

import com.google.gson.Gson;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Product {
    private final String productName;
    private final String info;
    private final String photoLink;
    private final int estimatedArrivalTime;
    private final int difficultyLevel;

    /**Constructor*/
    private Product(String productName, String info,String photoLink,int estimatedArrivalTime,int difficultyLevel) {
        this.productName= productName;
        this.info = info;
        this.photoLink = photoLink;
        this.estimatedArrivalTime = estimatedArrivalTime;
        this.difficultyLevel = (difficultyLevel == 0) ? 1 : difficultyLevel;
    }

    /**Getter and Setters*/
    public String getProductName() {
        return productName;
    }

    public String getInfo() {
        return info;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public int getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public Product fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json,this.getClass());
    }
    
    public static Product[] mapToProduct(ResultSet rs) {
        ArrayList<Product> prods = new ArrayList<>();
        Product[] products = null;
        try {
            while (rs.next()) {
                String productName = rs.getString("productName");
                String info = rs.getString("info");
                String photoLink = rs.getString("photoLink");
                int estimatedArrivalTime = rs.getInt("estimatedArrivalTime");
                int difficultyLevel = rs.getInt("difficultyLevel");
                prods.add(new Product(productName,info,photoLink,estimatedArrivalTime,difficultyLevel));
            }

            products = new Product[prods.size()];
            products = prods.toArray(products);
        } catch (SQLException e) {
            // TODO: 03.12.2017 add logging
        }
        return products;
    }
}
