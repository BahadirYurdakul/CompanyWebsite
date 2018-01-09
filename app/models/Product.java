package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product extends Model {

    @Id
    @Column(name = "productName")
    private final String productName;

    @Constraints.Required
    @Column(name = "info")
    private final String info;

    @Constraints.Required
    @Column(name = "photoLink")
    private final String photoLink;

    @Constraints.Required
    @Column(name = "estimatedArrivalTime")
    private final int estimatedArrivalTime;

    @Constraints.Required
    @Column(name = "difficultyLevel")
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


}
