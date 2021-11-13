package com.tecdev;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DatabaseBean {

    private static Connection con;
    private static Statement st;
    private static ResultSet rs;        

    static //CQ Static Anonymous Block
    {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/myora");
            con = ds.getConnection();
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static ResultSet executeQuery(String sql) {
        try {
            ResultSet rs = st.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            return null;
        }
    }

    public static int executeUpdate(String sql) {
        try {
            int result = st.executeUpdate(sql);
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

}
