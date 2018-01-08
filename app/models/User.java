package models;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.databind.JsonNode;
import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User extends Model{
    @Id
    @Constraints.Required
    @Column(name = "username")
    private String username;


    @Constraints.Required
    @Column(name = "password")
    private String password;

    @Constraints.Required
    @Column(name = "email")
    private String email;

    @Constraints.Required
    @Column(name = "telephone")
    private String telephone;

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "companyAddress")
    private String companyAddress;

    @Column(name = "title")
    private String title;

    @Constraints.Required
    @Column(name = "nameSurname")
    private String nameSurname;

    private User(String username, String password, String email, String telephone, String companyName, String companyAddress, String title, String nameSurname) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.telephone = telephone;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.title = title;
        this.nameSurname = nameSurname;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public static User getUser(JsonNode jsonNode){
        return new User(jsonNode.get("username").asText(),jsonNode.get("password").asText()
                        ,jsonNode.get("email").asText(),jsonNode.get("telephone").asText()
                        ,jsonNode.get("companyName").asText(),jsonNode.get("companyAddress").asText()
                        ,jsonNode.get("title").asText(),jsonNode.get("nameSurname").asText());
    }

}