package com.company.createModel.entity;

import java.util.Date;
import java.math.BigDecimal;

public class RedyellowallModel{

    /**
     * 列名:id
     * 数据库类型:INT
     * 数据库注释:id
     */
    private Integer id;


    /**
     * 列名:redCountermeasures
     * 数据库类型:INT
     * 数据库注释:红灯有的单位总数
     */
    private Integer redCountermeasures;


    /**
     * 列名:redNoCountermeasures
     * 数据库类型:INT
     * 数据库注释:红灯没有的单位总数
     */
    private Integer redNoCountermeasures;


    /**
     * 列名:redNumCountCompanyinfoCodeModels
     * 数据库类型:VARCHAR
     * 数据库注释:红灯有的所有单位Code
     */
    private String redNumCountCompanyinfoCodeModels;


    /**
     * 列名:redNumCountCompanyinfoModels
     * 数据库类型:VARCHAR
     * 数据库注释:红灯有的所有单位
     */
    private String redNumCountCompanyinfoModels;


    /**
     * 列名:redNothingCompanyinfoCodeModels
     * 数据库类型:VARCHAR
     * 数据库注释:红灯没有的所有单位Code
     */
    private String redNothingCompanyinfoCodeModels;


    /**
     * 列名:redNothingCompanyinfoModels
     * 数据库类型:VARCHAR
     * 数据库注释:红灯没有的所有单位
     */
    private String redNothingCompanyinfoModels;


    /**
     * 列名:yellowCountermeasures
     * 数据库类型:INT
     * 数据库注释:黄灯有的单位总数
     */
    private Integer yellowCountermeasures;


    /**
     * 列名:yellowNoCountermeasures
     * 数据库类型:INT
     * 数据库注释:黄灯没有的单位总数
     */
    private Integer yellowNoCountermeasures;


    /**
     * 列名:yellowNumCountCompanyinfoModels
     * 数据库类型:VARCHAR
     * 数据库注释:黄灯有的所有单位
     */
    private String yellowNumCountCompanyinfoModels;


    /**
     * 列名:yellowNumCountCompanyinfoCodeModels
     * 数据库类型:VARCHAR
     * 数据库注释:黄灯有的所有单位Code
     */
    private String yellowNumCountCompanyinfoCodeModels;


    /**
     * 列名:yellowNothingCompanyinfoModels
     * 数据库类型:VARCHAR
     * 数据库注释:黄灯没有的所有单位
     */
    private String yellowNothingCompanyinfoModels;


    /**
     * 列名:yellowNothingCompanyinfoCodeModels
     * 数据库类型:VARCHAR
     * 数据库注释:黄灯没有的所有单位Code
     */
    private String yellowNothingCompanyinfoCodeModels;


    /**
     * 列名:remarks
     * 数据库类型:VARCHAR
     * 数据库注释:备注
     */
    private String remarks;


    /**
     * 列名:versions
     * 数据库类型:INT
     * 数据库注释:数据版本号
     */
    private Integer versions;


    /**
     * 列名:createAt
     * 数据库类型:VARCHAR
     * 数据库注释:创建人
     */
    private String createAt;


    /**
     * 列名:createTime
     * 数据库类型:TIMESTAMP
     * 数据库注释:创建时间
     */
    private Date createTime;


    /**
     * 列名:updateAt
     * 数据库类型:VARCHAR
     * 数据库注释:修改人
     */
    private String updateAt;


    public Integer getId() {
 return id;
    }

    public void setId(Integer id) {
 this. id = id;
    }

    public Integer getRedCountermeasures() {
 return redCountermeasures;
    }

    public void setRedCountermeasures(Integer redCountermeasures) {
 this. redCountermeasures = redCountermeasures;
    }

    public Integer getRedNoCountermeasures() {
 return redNoCountermeasures;
    }

    public void setRedNoCountermeasures(Integer redNoCountermeasures) {
 this. redNoCountermeasures = redNoCountermeasures;
    }

    public String getRedNumCountCompanyinfoCodeModels() {
 return redNumCountCompanyinfoCodeModels;
    }

    public void setRedNumCountCompanyinfoCodeModels(String redNumCountCompanyinfoCodeModels) {
 this. redNumCountCompanyinfoCodeModels = redNumCountCompanyinfoCodeModels;
    }

    public String getRedNumCountCompanyinfoModels() {
 return redNumCountCompanyinfoModels;
    }

    public void setRedNumCountCompanyinfoModels(String redNumCountCompanyinfoModels) {
 this. redNumCountCompanyinfoModels = redNumCountCompanyinfoModels;
    }

    public String getRedNothingCompanyinfoCodeModels() {
 return redNothingCompanyinfoCodeModels;
    }

    public void setRedNothingCompanyinfoCodeModels(String redNothingCompanyinfoCodeModels) {
 this. redNothingCompanyinfoCodeModels = redNothingCompanyinfoCodeModels;
    }

    public String getRedNothingCompanyinfoModels() {
 return redNothingCompanyinfoModels;
    }

    public void setRedNothingCompanyinfoModels(String redNothingCompanyinfoModels) {
 this. redNothingCompanyinfoModels = redNothingCompanyinfoModels;
    }

    public Integer getYellowCountermeasures() {
 return yellowCountermeasures;
    }

    public void setYellowCountermeasures(Integer yellowCountermeasures) {
 this. yellowCountermeasures = yellowCountermeasures;
    }

    public Integer getYellowNoCountermeasures() {
 return yellowNoCountermeasures;
    }

    public void setYellowNoCountermeasures(Integer yellowNoCountermeasures) {
 this. yellowNoCountermeasures = yellowNoCountermeasures;
    }

    public String getYellowNumCountCompanyinfoModels() {
 return yellowNumCountCompanyinfoModels;
    }

    public void setYellowNumCountCompanyinfoModels(String yellowNumCountCompanyinfoModels) {
 this. yellowNumCountCompanyinfoModels = yellowNumCountCompanyinfoModels;
    }

    public String getYellowNumCountCompanyinfoCodeModels() {
 return yellowNumCountCompanyinfoCodeModels;
    }

    public void setYellowNumCountCompanyinfoCodeModels(String yellowNumCountCompanyinfoCodeModels) {
 this. yellowNumCountCompanyinfoCodeModels = yellowNumCountCompanyinfoCodeModels;
    }

    public String getYellowNothingCompanyinfoModels() {
 return yellowNothingCompanyinfoModels;
    }

    public void setYellowNothingCompanyinfoModels(String yellowNothingCompanyinfoModels) {
 this. yellowNothingCompanyinfoModels = yellowNothingCompanyinfoModels;
    }

    public String getYellowNothingCompanyinfoCodeModels() {
 return yellowNothingCompanyinfoCodeModels;
    }

    public void setYellowNothingCompanyinfoCodeModels(String yellowNothingCompanyinfoCodeModels) {
 this. yellowNothingCompanyinfoCodeModels = yellowNothingCompanyinfoCodeModels;
    }

    public String getRemarks() {
 return remarks;
    }

    public void setRemarks(String remarks) {
 this. remarks = remarks;
    }

    public Integer getVersions() {
 return versions;
    }

    public void setVersions(Integer versions) {
 this. versions = versions;
    }

    public String getCreateAt() {
 return createAt;
    }

    public void setCreateAt(String createAt) {
 this. createAt = createAt;
    }

    public Date getCreateTime() {
 return createTime;
    }

    public void setCreateTime(Date createTime) {
 this. createTime = createTime;
    }

    public String getUpdateAt() {
 return updateAt;
    }

    public void setUpdateAt(String updateAt) {
 this. updateAt = updateAt;
    }

}