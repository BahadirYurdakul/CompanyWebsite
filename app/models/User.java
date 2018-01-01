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


    @Column(name = "password")
    private String password;

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

    public User(String username, String password, String email, String telephone, String companyName, String companyAddress, String title, String nameSurname) {
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

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public String getTitle() {
        return title;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public static User getUser(JsonNode jsonNode){
        return new User(jsonNode.get("username").asText(),jsonNode.get("password").asText()
                        ,jsonNode.get("email").asText(),jsonNode.get("telephone").asText()
                        ,jsonNode.get("companyName").asText(),jsonNode.get("companyAddress").asText()
                        ,jsonNode.get("title").asText(),jsonNode.get("nameSurname").asText());
    }

}