package models;

import com.google.gson.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompanyPhoto {
    private int id;
    private final String link;
    private final String summary;

    private CompanyPhoto(String link, String summary) {
        this.link = link;
        this.summary = summary;
    }

    public int getId() {
        return id;
    }
    private void setId(int id) { this.id = id; }

    public String getLink() {
        return link;
    }

    public String getSummary() {
        return summary;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public CompanyPhoto fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json,this.getClass());
    }

    public static CompanyPhoto[] mapToCompanyPhoto(ResultSet rs) {
        ArrayList<CompanyPhoto> cpList = new ArrayList<>();
        CompanyPhoto[] cp = null;
        try {
            while (rs.next()) {
                CompanyPhoto photo;
                int id = rs.getInt("id");
                String link = rs.getString("link");
                String summary = rs.getString("summary");
                photo = new CompanyPhoto(link,summary);
                photo.setId(id);
                cpList.add(photo);
            }
            cp = new CompanyPhoto[cpList.size()];
            cp = cpList.toArray(cp);
        } catch (SQLException e) {
            // TODO: 03.12.2017 add logging
        }
        return cp;
    }

}
