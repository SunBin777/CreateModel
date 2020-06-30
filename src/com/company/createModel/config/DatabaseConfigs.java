package com.company.createModel.config;

/**
 * @author: 孙斌
 * @create: 2020-06-29 10:08
 **/
public class DatabaseConfigs {
    //jdbc包
    public final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    //路径
    public final static String URL = "jdbc:mysql://localhost:3306/productiondb?useUnicode=true&characterEncoding=utf8&useSSL=false";
    //用户名
    public final static String USERNAME = "root";
    //密码
    public final static String PASSWORD = "root";
    //默认路径
    public final static String PATHS = "src\\com\\company\\createModel\\";
    //包路径
    public final static String PACKAGEPATHS = "com.company.createModel";
}
