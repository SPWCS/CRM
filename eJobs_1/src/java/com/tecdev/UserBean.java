package com.tecdev;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBean {

    private String userid, password, usertype;
    public UserBean(){ }

    public UserBean(String userid, String password) {
        this.userid = userid ;
        this.password = password;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

   
    public boolean exists() throws SQLException {
        String sql = String.format("Select * from users where userid='%s' and password='%s' ", userid, password);
       

        ResultSet rs = DatabaseBean.executeQuery(sql);
        this.usertype=null; //Not initialized
        if(rs.next()) //row found
        {
            this.usertype=rs.getString("usertype");
            return true;  //exists
        }
        
        return false;   //not exists
    }

}
