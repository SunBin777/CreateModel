package com.company.createModel.entity;

import java.util.Date;
import java.math.BigDecimal;

public class UserModel{

    /**
     * 列名:uid
     * 数据库类型:INT
     * 数据库注释:
     */
    private Integer uid;


    /**
     * 列名:uname
     * 数据库类型:VARCHAR
     * 数据库注释:
     */
    private String uname;


    /**
     * 列名:upwd
     * 数据库类型:VARCHAR
     * 数据库注释:
     */
    private String upwd;


    public Integer getUid() {
 return uid;
    }

    public void setUid(Integer uid) {
 this. uid = uid;
    }

    public String getUname() {
 return uname;
    }

    public void setUname(String uname) {
 this. uname = uname;
    }

    public String getUpwd() {
 return upwd;
    }

    public void setUpwd(String upwd) {
 this. upwd = upwd;
    }

}