package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Article extends Model {

    @Id
    @Column(name = "articleId")
    private int articleId;

    @Constraints.Required
    @Column(name = "title")
    private String  title;

    @Constraints.Required
    @Column(name = "photoLink")
    private String photoLink;

    @Constraints.Required
    @Column(name = "content")

    private String content;

    @Constraints.Required
    @Column(name = "author")
    private String author;

    @Constraints.Required
    @Column(name = "date")
    private String date;

    public Article(String title, String photoLink, String content, String author) {
        this.title = title;
        this.photoLink = photoLink;
        this.content = content;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getArticleId() {
        return articleId;
    }

}
