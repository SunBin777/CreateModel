package com.company.createModel.entity;

import java.util.Date;
import java.math.BigDecimal;

public class CountermeasuresallModel{

    /**
     * 列名:id
     * 数据库类型:INT
     * 数据库注释:id
     */
    private Integer id;


    /**
     * 列名:companyCode
     * 数据库类型:VARCHAR
     * 数据库注释:公司code
     */
    private String companyCode;


    /**
     * 列名:companyName
     * 数据库类型:VARCHAR
     * 数据库注释:公司名称
     */
    private String companyName;


    /**
     * 列名:respondID
     * 数据库类型:VARCHAR
     * 数据库注释:解决办法id
     */
    private String respondID;


    /**
     * 列名:cmpPresidentExplain
     * 数据库类型:VARCHAR
     * 数据库注释:总裁解释
     */
    private String cmpPresidentExplain;


    /**
     * 列名:riskCause
     * 数据库类型:VARCHAR
     * 数据库注释:风险原因
     */
    private String riskCause;


    /**
     * 列名:riskCauseDesp
     * 数据库类型:VARCHAR
     * 数据库注释:风险原因分析
     */
    private String riskCauseDesp;


    /**
     * 列名:measure
     * 数据库类型:VARCHAR
     * 数据库注释:解决办法
     */
    private String measure;


    /**
     * 列名:reportDate
     * 数据库类型:INT
     * 数据库注释:报告日期
     */
    private Integer reportDate;


    /**
     * 列名:dealWithTimeLimit
     * 数据库类型:INT
     * 数据库注释:处理时限
     */
    private Integer dealWithTimeLimit;


    /**
     * 列名:remarks
     * 数据库类型:VARCHAR
     * 数据库注释:备注
     */
    private String remarks;


    /**
     * 列名:versions
     * 数据库类型:INT
     * 数据库注释:数据版本
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


    /**
     * 列名:updateTime
     * 数据库类型:TIMESTAMP
     * 数据库注释:修改时间
     */
    private Date updateTime;


    public Integer getId() {
 return id;
    }

    public void setId(Integer id) {
 this. id = id;
    }

    public String getCompanyCode() {
 return companyCode;
    }

    public void setCompanyCode(String companyCode) {
 this. companyCode = companyCode;
    }

    public String getCompanyName() {
 return companyName;
    }

    public void setCompanyName(String companyName) {
 this. companyName = companyName;
    }

    public String getRespondID() {
 return respondID;
    }

    public void setRespondID(String respondID) {
 this. respondID = respondID;
    }

    public String getCmpPresidentExplain() {
 return cmpPresidentExplain;
    }

    public void setCmpPresidentExplain(String cmpPresidentExplain) {
 this. cmpPresidentExplain = cmpPresidentExplain;
    }

    public String getRiskCause() {
 return riskCause;
    }

    public void setRiskCause(String riskCause) {
 this. riskCause = riskCause;
    }

    public String getRiskCauseDesp() {
 return riskCauseDesp;
    }

    public void setRiskCauseDesp(String riskCauseDesp) {
 this. riskCauseDesp = riskCauseDesp;
    }

    public String getMeasure() {
 return measure;
    }

    public void setMeasure(String measure) {
 this. measure = measure;
    }

    public Integer getReportDate() {
 return reportDate;
    }

    public void setReportDate(Integer reportDate) {
 this. reportDate = reportDate;
    }

    public Integer getDealWithTimeLimit() {
 return dealWithTimeLimit;
    }

    public void setDealWithTimeLimit(Integer dealWithTimeLimit) {
 this. dealWithTimeLimit = dealWithTimeLimit;
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

    public Date getUpdateTime() {
 return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
 this. updateTime = updateTime;
    }

}