package com.company.createModel.dao;

import java.util.Date;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import com.company.createModel.entity.UserModel;

@Mapper
public interface UserDao{

    /**
     * 添加
     * @param model   实体类
     */
    @InsertProvider(type = UserDaoProvider.class, method = "create")
    Integer create(UserModel model);

    /**
     * 修改
     * @param model   实体类
     */
    @UpdateProvider(type = UserDaoProvider.class, method = "update")
    Integer update(UserModel model);

    /**
     * 查询
     * @param model   实体类
     */
    @UpdateProvider(type = UserDaoProvider.class, method = "query")
    Integer query(UserModel model);




    class UserDaoProvider{

        /**
         * 创建
         * @param model   实体类
         */
        public String create(final UserModel model){
            return new SQL(){{
            INSERT_INTO("user");
                if(model.getUid() != null){
                    VALUES("uid", "#{uid}");
                }
                if(!(model.getUname() != null || model.getUname().isEmpty())){
                    VALUES("uname", "#{uname}");
                }
                if(!(model.getUpwd() != null || model.getUpwd().isEmpty())){
                    VALUES("upwd", "#{upwd}");
                }
            }}.toString();
        }


        /**
         * 修改
         * @param model   实体类
         */
        public String update(final UserModel model){
            return new SQL(){{
            UPDATE("user");
                if(model.getUid() != null){
                    SET("uid=#{uid}");
                }
                if(!(model.getUname() != null || model.getUname().isEmpty())){
                    SET("uname=#{uname}");
                }
                if(!(model.getUpwd() != null || model.getUpwd().isEmpty())){
                    SET("upwd=#{upwd}");
                }
                    WHERE("id=#{id}");
            }}.toString();
        }


        /**
         * 查询
         * @param model   实体类
         */
        public String query(final UserModel model){
            StringBuilder sb = new StringBuilder();
            sb.append(" SELECT ");
            sb.append(" u.uid, u.uname, u.upwd");
            sb.append(" FROM User u");
            return sb.toString();
        }

    }
}
