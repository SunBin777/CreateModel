package com.company.createModel.dao;

import java.util.Date;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import com.company.createModel.entity.CountermeasuresallModel;

@Mapper
public interface CountermeasuresallDao{

    /**
     * 添加
     * @param model   实体类
     */
    @InsertProvider(type = CountermeasuresallDaoProvider.class, method = "create")
    Integer create(CountermeasuresallModel model);

    /**
     * 修改
     * @param model   实体类
     */
    @UpdateProvider(type = CountermeasuresallDaoProvider.class, method = "update")
    Integer update(CountermeasuresallModel model);

    /**
     * 查询
     * @param model   实体类
     */
    @UpdateProvider(type = CountermeasuresallDaoProvider.class, method = "query")
    Integer query(CountermeasuresallModel model);




    class CountermeasuresallDaoProvider{

        /**
         * 创建
         * @param model   实体类
         */
        public String create(final CountermeasuresallModel model){
            return new SQL(){{
            INSERT_INTO("countermeasuresall");
                if(model.getId() != null){
                    VALUES("id", "#{id}");
                }
                if(!(model.getCompanyCode() != null || model.getCompanyCode().isEmpty())){
                    VALUES("companyCode", "#{companyCode}");
                }
                if(!(model.getCompanyName() != null || model.getCompanyName().isEmpty())){
                    VALUES("companyName", "#{companyName}");
                }
                if(!(model.getRespondID() != null || model.getRespondID().isEmpty())){
                    VALUES("respondID", "#{respondID}");
                }
                if(!(model.getCmpPresidentExplain() != null || model.getCmpPresidentExplain().isEmpty())){
                    VALUES("cmpPresidentExplain", "#{cmpPresidentExplain}");
                }
                if(!(model.getRiskCause() != null || model.getRiskCause().isEmpty())){
                    VALUES("riskCause", "#{riskCause}");
                }
                if(!(model.getRiskCauseDesp() != null || model.getRiskCauseDesp().isEmpty())){
                    VALUES("riskCauseDesp", "#{riskCauseDesp}");
                }
                if(!(model.getMeasure() != null || model.getMeasure().isEmpty())){
                    VALUES("measure", "#{measure}");
                }
                if(model.getReportDate() != null){
                    VALUES("reportDate", "#{reportDate}");
                }
                if(model.getDealWithTimeLimit() != null){
                    VALUES("dealWithTimeLimit", "#{dealWithTimeLimit}");
                }
                if(!(model.getRemarks() != null || model.getRemarks().isEmpty())){
                    VALUES("remarks", "#{remarks}");
                }
                if(model.getVersions() != null){
                    VALUES("versions", "#{versions}");
                }
                if(!(model.getCreateAt() != null || model.getCreateAt().isEmpty())){
                    VALUES("createAt", "#{createAt}");
                }
                if(model.getCreateTime() != null){
                    VALUES("createTime", "#{createTime}");
                }
                if(!(model.getUpdateAt() != null || model.getUpdateAt().isEmpty())){
                    VALUES("updateAt", "#{updateAt}");
                }
                if(model.getUpdateTime() != null){
                    VALUES("updateTime", "#{updateTime}");
                }
            }}.toString();
        }


        /**
         * 修改
         * @param model   实体类
         */
        public String update(final CountermeasuresallModel model){
            return new SQL(){{
            UPDATE("countermeasuresall");
                if(model.getId() != null){
                    SET("id=#{id}");
                }
                if(!(model.getCompanyCode() != null || model.getCompanyCode().isEmpty())){
                    SET("companyCode=#{companyCode}");
                }
                if(!(model.getCompanyName() != null || model.getCompanyName().isEmpty())){
                    SET("companyName=#{companyName}");
                }
                if(!(model.getRespondID() != null || model.getRespondID().isEmpty())){
                    SET("respondID=#{respondID}");
                }
                if(!(model.getCmpPresidentExplain() != null || model.getCmpPresidentExplain().isEmpty())){
                    SET("cmpPresidentExplain=#{cmpPresidentExplain}");
                }
                if(!(model.getRiskCause() != null || model.getRiskCause().isEmpty())){
                    SET("riskCause=#{riskCause}");
                }
                if(!(model.getRiskCauseDesp() != null || model.getRiskCauseDesp().isEmpty())){
                    SET("riskCauseDesp=#{riskCauseDesp}");
                }
                if(!(model.getMeasure() != null || model.getMeasure().isEmpty())){
                    SET("measure=#{measure}");
                }
                if(model.getReportDate() != null){
                    SET("reportDate=#{reportDate}");
                }
                if(model.getDealWithTimeLimit() != null){
                    SET("dealWithTimeLimit=#{dealWithTimeLimit}");
                }
                if(!(model.getRemarks() != null || model.getRemarks().isEmpty())){
                    SET("remarks=#{remarks}");
                }
                if(model.getVersions() != null){
                    SET("versions=#{versions}");
                }
                if(!(model.getCreateAt() != null || model.getCreateAt().isEmpty())){
                    SET("createAt=#{createAt}");
                }
                if(model.getCreateTime() != null){
                    SET("createTime=#{createTime}");
                }
                if(!(model.getUpdateAt() != null || model.getUpdateAt().isEmpty())){
                    SET("updateAt=#{updateAt}");
                }
                if(model.getUpdateTime() != null){
                    SET("updateTime=#{updateTime}");
                }
                    WHERE("id=#{id}");
            }}.toString();
        }


        /**
         * 查询
         * @param model   实体类
         */
        public String query(final CountermeasuresallModel model){
            StringBuilder sb = new StringBuilder();
            sb.append(" SELECT ");
            sb.append(" c.id, c.companyCode, c.companyName, c.respondID, c.cmpPresidentExplain,");
            sb.append(" c.riskCauseDesp, c.measure, c.reportDate, c.dealWithTimeLimit,");
            sb.append(" c.versions, c.createAt, c.createTime, c.updateAt, c.updateTime");
            sb.append(" FROM Countermeasuresall c");
            return sb.toString();
        }

    }
}
