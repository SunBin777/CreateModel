package com.company;

import com.company.createModel.config.DatabaseConfigs;
import com.company.createModel.util.*;

import java.util.Date;
import java.util.List;

/**
 * 启动类
 *
 * @author: 孙斌
 * @create: 2020-06-28 17:36
 **/
public class Main {

    public static void main(String[] args) {
        Date startDate = new Date();
        List<String> tableNames = DatabaseUtil.getTableNames();
        //生成文件夹
        FileUtil.createAllFolder();
        System.out.println("开始生成表:" + tableNames);
        System.out.println("毫秒数： " + DateUtil.SimpleDateFormatDate(startDate));
        System.out.println("开始生成 ------》》》");
        for (String tableName : tableNames) {
            System.out.println("生成: " + tableName + "Model 中......");
            GenerateModel.generateFileModels(tableName, DatabaseUtil.getColumnNames(tableName), DatabaseUtil.getColumnTypes(tableName), DatabaseUtil.getColumnComments(tableName));
            System.out.println("生成: " + tableName + "Dao 中......");
            GenerateDao.generateFileDaos(tableName, DatabaseUtil.getColumnNames(tableName), DatabaseUtil.getColumnTypes(tableName), DatabaseUtil.getColumnComments(tableName));
        }
        System.out.println("生成完成 ------》》》");
        Date endDate = new Date();
        System.out.println("毫秒数： " + DateUtil.SimpleDateFormatDate(endDate));
        System.out.println("共用时间： " + (((endDate.getTime() - startDate.getTime()) % (1000 * 60)) / 1000) + "秒");
    }
}
