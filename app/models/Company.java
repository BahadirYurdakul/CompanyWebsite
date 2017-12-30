package models;

import com.google.gson.Gson;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Company {
    private final String companyName;
    private final String address;
    private final int telNo;
    private final String companyInfo;
    private final long longitude;
    private final long latitude;

    private Company(String companyName, String address, int telNo, String companyInfo, long longitude, long latitude) {
        this.companyName = companyName;
        this.address = address;
        this.telNo = telNo;
        this.companyInfo = companyInfo;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    public int getTelNo() {
        return telNo;
    }

    public long getLongitude() {
        return longitude;
    }

    public String getCompanyInfo() {
        return companyInfo;
    }

    public long getLatitude() {
        return latitude;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public Company fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json,this.getClass());
    }

    public static Company[] mapToCompany(ResultSet rs) {
        ArrayList<Company> comps = new ArrayList<>();
        Company[] company = null;
        try {
            while(rs.next()){
                String companyName = rs.getString("companyName");
                String address = rs.getString("address");
                int telNo = rs.getInt("telNo");
                String companyInfo = rs.getString("companyInfo");
                long longitude = rs.getLong("longitude");
                long latitude = rs.getLong("latitude");

                comps.add(new Company(companyName,address,telNo,companyInfo,longitude,latitude));
            }
            company = new Company[comps.size()];
            company = comps.toArray(company);
        } catch (SQLException e) {
            // TODO: 03.12.2017 add logging
        }
        return company;
    }
}
