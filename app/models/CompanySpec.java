package models;

import com.google.gson.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanySpec {
    private final String photoLink;
    private final String specName;
    private final String description;

    private CompanySpec(String photoLink, String specName, String description) {
        this.photoLink = photoLink;
        this.specName = specName;
        this.description = description;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public String getSpecName() {
        return specName;
    }

    public String getDescription() {
        return description;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public CompanySpec fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json,this.getClass());
    }

    public static CompanySpec mapToCompanySpec(ResultSet rs) {
        CompanySpec cs = null;

        try {
            while (rs.next()) {
                String photoLink = rs.getString("photoLink");
                String specName = rs.getString("specName");
                String description = rs.getString("description");

                cs = new CompanySpec(photoLink,specName,description);
            }
        } catch (SQLException e) {
            // TODO: 03.12.2017 add logging
        }
        return cs;
    }
}
