package com.company;

import com.company.createModel.util.DatabaseUtil;
import com.company.createModel.util.FileDatabaseUtil;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> tableNames = DatabaseUtil.getTableNames();
        System.out.println("生成表:" + tableNames);
        System.out.println("毫秒数： " + System.currentTimeMillis());
        System.out.println("开始生成 ------》》》");
        for (String tableName : tableNames) {
            FileDatabaseUtil.generateFileModels(tableName,DatabaseUtil.getColumnNames(tableName),DatabaseUtil.getColumnTypes(tableName),DatabaseUtil.getColumnComments(tableName));
            FileDatabaseUtil.generateFileDaos(tableName,DatabaseUtil.getColumnNames(tableName),DatabaseUtil.getColumnTypes(tableName),DatabaseUtil.getColumnComments(tableName));
        }
        System.out.println("生成完成 ------》》》");
        System.out.println("毫秒数： " + System.currentTimeMillis());
    }
}
