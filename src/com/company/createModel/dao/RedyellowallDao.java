package com.company.createModel.dao;

import java.util.Date;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import com.company.createModel.entity.RedyellowallModel;

@Mapper
public interface RedyellowallDao{

    /**
     * 添加
     * @param model   实体类
     */
    @InsertProvider(type = RedyellowallDaoProvider.class, method = "create")
    Integer create(RedyellowallModel model);

    /**
     * 修改
     * @param model   实体类
     */
    @UpdateProvider(type = RedyellowallDaoProvider.class, method = "update")
    Integer update(RedyellowallModel model);

    /**
     * 查询
     * @param model   实体类
     */
    @UpdateProvider(type = RedyellowallDaoProvider.class, method = "query")
    Integer query(RedyellowallModel model);




    class RedyellowallDaoProvider{

        /**
         * 创建
         * @param model   实体类
         */
        public String create(final RedyellowallModel model){
            return new SQL(){{
            INSERT_INTO("redyellowall");
                if(model.getId() != null){
                    VALUES("id", "#{id}");
                }
                if(model.getRedCountermeasures() != null){
                    VALUES("redCountermeasures", "#{redCountermeasures}");
                }
                if(model.getRedNoCountermeasures() != null){
                    VALUES("redNoCountermeasures", "#{redNoCountermeasures}");
                }
                if(!(model.getRedNumCountCompanyinfoCodeModels() != null || model.getRedNumCountCompanyinfoCodeModels().isEmpty())){
                    VALUES("redNumCountCompanyinfoCodeModels", "#{redNumCountCompanyinfoCodeModels}");
                }
                if(!(model.getRedNumCountCompanyinfoModels() != null || model.getRedNumCountCompanyinfoModels().isEmpty())){
                    VALUES("redNumCountCompanyinfoModels", "#{redNumCountCompanyinfoModels}");
                }
                if(!(model.getRedNothingCompanyinfoCodeModels() != null || model.getRedNothingCompanyinfoCodeModels().isEmpty())){
                    VALUES("redNothingCompanyinfoCodeModels", "#{redNothingCompanyinfoCodeModels}");
                }
                if(!(model.getRedNothingCompanyinfoModels() != null || model.getRedNothingCompanyinfoModels().isEmpty())){
                    VALUES("redNothingCompanyinfoModels", "#{redNothingCompanyinfoModels}");
                }
                if(model.getYellowCountermeasures() != null){
                    VALUES("yellowCountermeasures", "#{yellowCountermeasures}");
                }
                if(model.getYellowNoCountermeasures() != null){
                    VALUES("yellowNoCountermeasures", "#{yellowNoCountermeasures}");
                }
                if(!(model.getYellowNumCountCompanyinfoModels() != null || model.getYellowNumCountCompanyinfoModels().isEmpty())){
                    VALUES("yellowNumCountCompanyinfoModels", "#{yellowNumCountCompanyinfoModels}");
                }
                if(!(model.getYellowNumCountCompanyinfoCodeModels() != null || model.getYellowNumCountCompanyinfoCodeModels().isEmpty())){
                    VALUES("yellowNumCountCompanyinfoCodeModels", "#{yellowNumCountCompanyinfoCodeModels}");
                }
                if(!(model.getYellowNothingCompanyinfoModels() != null || model.getYellowNothingCompanyinfoModels().isEmpty())){
                    VALUES("yellowNothingCompanyinfoModels", "#{yellowNothingCompanyinfoModels}");
                }
                if(!(model.getYellowNothingCompanyinfoCodeModels() != null || model.getYellowNothingCompanyinfoCodeModels().isEmpty())){
                    VALUES("yellowNothingCompanyinfoCodeModels", "#{yellowNothingCompanyinfoCodeModels}");
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
            }}.toString();
        }


        /**
         * 修改
         * @param model   实体类
         */
        public String update(final RedyellowallModel model){
            return new SQL(){{
            UPDATE("redyellowall");
                if(model.getId() != null){
                    SET("id=#{id}");
                }
                if(model.getRedCountermeasures() != null){
                    SET("redCountermeasures=#{redCountermeasures}");
                }
                if(model.getRedNoCountermeasures() != null){
                    SET("redNoCountermeasures=#{redNoCountermeasures}");
                }
                if(!(model.getRedNumCountCompanyinfoCodeModels() != null || model.getRedNumCountCompanyinfoCodeModels().isEmpty())){
                    SET("redNumCountCompanyinfoCodeModels=#{redNumCountCompanyinfoCodeModels}");
                }
                if(!(model.getRedNumCountCompanyinfoModels() != null || model.getRedNumCountCompanyinfoModels().isEmpty())){
                    SET("redNumCountCompanyinfoModels=#{redNumCountCompanyinfoModels}");
                }
                if(!(model.getRedNothingCompanyinfoCodeModels() != null || model.getRedNothingCompanyinfoCodeModels().isEmpty())){
                    SET("redNothingCompanyinfoCodeModels=#{redNothingCompanyinfoCodeModels}");
                }
                if(!(model.getRedNothingCompanyinfoModels() != null || model.getRedNothingCompanyinfoModels().isEmpty())){
                    SET("redNothingCompanyinfoModels=#{redNothingCompanyinfoModels}");
                }
                if(model.getYellowCountermeasures() != null){
                    SET("yellowCountermeasures=#{yellowCountermeasures}");
                }
                if(model.getYellowNoCountermeasures() != null){
                    SET("yellowNoCountermeasures=#{yellowNoCountermeasures}");
                }
                if(!(model.getYellowNumCountCompanyinfoModels() != null || model.getYellowNumCountCompanyinfoModels().isEmpty())){
                    SET("yellowNumCountCompanyinfoModels=#{yellowNumCountCompanyinfoModels}");
                }
                if(!(model.getYellowNumCountCompanyinfoCodeModels() != null || model.getYellowNumCountCompanyinfoCodeModels().isEmpty())){
                    SET("yellowNumCountCompanyinfoCodeModels=#{yellowNumCountCompanyinfoCodeModels}");
                }
                if(!(model.getYellowNothingCompanyinfoModels() != null || model.getYellowNothingCompanyinfoModels().isEmpty())){
                    SET("yellowNothingCompanyinfoModels=#{yellowNothingCompanyinfoModels}");
                }
                if(!(model.getYellowNothingCompanyinfoCodeModels() != null || model.getYellowNothingCompanyinfoCodeModels().isEmpty())){
                    SET("yellowNothingCompanyinfoCodeModels=#{yellowNothingCompanyinfoCodeModels}");
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
                    WHERE("id=#{id}");
            }}.toString();
        }


        /**
         * 查询
         * @param model   实体类
         */
        public String query(final RedyellowallModel model){
            StringBuilder sb = new StringBuilder();
            sb.append(" SELECT ");
            sb.append(" r.id, r.redCountermeasures, r.redNoCountermeasures, r.redNumCountCompanyinfoCodeModels, r.redNumCountCompanyinfoModels,");
            sb.append(" r.redNothingCompanyinfoModels, r.yellowCountermeasures, r.yellowNoCountermeasures, r.yellowNumCountCompanyinfoModels,");
            sb.append(" r.yellowNothingCompanyinfoModels, r.yellowNothingCompanyinfoCodeModels, r.remarks, r.versions,");
            sb.append(" r.createTime, r.updateAt");
            sb.append(" FROM Redyellowall r");
            return sb.toString();
        }

    }
}
