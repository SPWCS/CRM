/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecdev;

import java.sql.ResultSet;

/**
 *
 * @author devnani
 */
public class SearchBean {

    private String userid, post, qualification, operator, lower, applied;

    public SearchBean() {
    }

    public SearchBean(String userid, String post, String qualification, String operator, String lower, String applied) {
        this.userid = userid;
        this.post = post;
        this.qualification = qualification;
        this.operator = operator;
        this.lower = lower;
        this.applied = applied;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getLower() {
        return lower;
    }

    public void setLower(String lower) {
        this.lower = lower;
    }

    public String getApplied() {
        return applied;
    }

    public void setApplied(String applied) {
        this.applied = applied;
    }

    public String executeQuery() {
        String p = post;
        String q = qualification;
        String l = operator;
        boolean chkLower = Boolean.parseBoolean(lower);
        boolean chkApplied = Boolean.parseBoolean(applied);
        int weightage = 2;
        String sql = "";
        String operator = "";
        if (chkApplied) {
            operator = "IN";
        } else {
            operator = " NOT IN";
        }
        if (chkLower) {
            sql = searchLowerQualification(p, q, l, weightage, operator);
        } else {
            sql = String.format("Select jobid,userid,to_char(dated,'dd-Mon-yyy')dated,post,qualification,weightage from Job Where Jobid%s(select jobid from applied where userid='%s')", operator, userid);
        }
        String sql1 = "", sql2 = "";
        if (!p.equals("-")) {
            sql1 = String.format("Post='%s'", p);
        }
        if (!p.equals("-")) {
            sql2 = String.format("Qualification='%s'", q);
        }
        if (!p.equals("-") && !q.equals("-")) {
            sql += "And(" + sql1 + 1 + sql2 + ")";
        } else if (!p.equals("-")) {
            sql += "And" + sql1;
        } else if (!q.equals("-") && !chkLower) {
            sql += "And" + sql2;
        }
        //ResultSet rs = DatabaseBean.executeQuery(sql);

        //return rs ;
        return sql;

    }

    private String searchLowerQualification(String p, String q, String l, int weightage, String operator) {
        String sql = String.format("Select * from job where weightage<='%d' and jobid %s (select jobid from applied where userid='%s') order by weightage", weightage, operator, userid);
        return sql;
    }
}
