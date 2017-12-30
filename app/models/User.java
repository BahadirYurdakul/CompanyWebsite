package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User extends Model{
    @Id
    @Constraints.Required
    @Column(name = "username")
    private final String username;

    @Constraints.Min(6)
    @Column(name = "password")
    private final String password;

    @Constraints.Email
    @Column(name = "email")
    private final String email;

    @Constraints.Required
    @Column(name = "telephone")
    private final String telephone;

    @Column(name = "companyName")
    private final String companyName;

    @Column(name = "companyAddress")
    private final String companyAddress;

    @Column(name = "title")
    private final String title;

    @Constraints.Required
    @Column(name = "nameSurname")
    private final String nameSurname;

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


}