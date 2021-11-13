package com.tecdev;
//Entity Bean  For Customer Table

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerBean {

    private String userid, name, dob, qualification;
    private int weightage;
    private boolean found;

    public CustomerBean() {
        found = false;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public CustomerBean(String userid, String name, String dob, String qualification, int weightage) {
        this.userid = userid;
        this.name = name;
        this.dob = dob;
        this.qualification = qualification;
        this.weightage = weightage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getUserid() {
        return userid;
    }

    public int getWeightage() {
        return weightage;
    }

    public void setWeightage(int weightage) {
        this.weightage = weightage;
    }

    public boolean exists() throws SQLException {
        String sql = String.format("Select name, to_char(dob,'dd-Mon-yy') dob, qualification,weightage from customer where userid='%s' ", userid);
//String sql = String.format("Select * from customer where userid='%s' ", userid);
        ResultSet rs = DatabaseBean.executeQuery(sql);

        if (rs.next()) //row found
        {
            this.name = rs.getString("name");
            this.dob = rs.getString("dob");

            this.qualification = rs.getString("qualification");
            this.weightage = rs.getInt("weightage");
            this.found = true;
            return true;  //exists
        }

        return false;   //not exists

    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    //12-Jul-2019 
    public int executeUpdate() {

        String sql = "";
        if (found) {
            sql = String.format("Update Customer set name='%s' , qualification='%s' , weightage='%d' where userid='%s'", name, qualification, weightage, userid);
        } else {
            sql = String.format("Insert into Customer values('%s' , '%s' , '%s', '%s' , '%d')", userid, name, dob, qualification, weightage);
        }
        int result = DatabaseBean.executeUpdate(sql);
        return result;

    }

}
