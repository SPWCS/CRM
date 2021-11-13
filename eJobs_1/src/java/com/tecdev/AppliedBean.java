/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecdev;


public class AppliedBean {
    private String jobid,userid,dated,appid;
    private String jobids[];
    public AppliedBean(){ jobids=new String[0];}
    public AppliedBean(String userid,String jobids[]){
    this.userid = userid;
    this.jobids = jobids;}
    public int executeUpdate(){
    int count = 0;
    String sql;
    for(String j:jobids){
        sql=String.format("Insert into Applied Values('%s','%s',sysdate,appid_seq.nextval)",j,userid);
        int result = DatabaseBean.executeUpdate(sql);
        if(result>0){   count++;    }
        
    }
    return count;
    }

    public AppliedBean(String jobid, String userid, String dated, String appid) {
        this.jobid = jobid;
        this.userid = userid;
        this.dated = dated;
        this.appid = appid;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDated() {
        return dated;
    }

    public void setDated(String dated) {
        this.dated = dated;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String[] getJobids() {
        return jobids;
    }

    public void setJobids(String[] jobids) {
        this.jobids = jobids;
    }
    
}
