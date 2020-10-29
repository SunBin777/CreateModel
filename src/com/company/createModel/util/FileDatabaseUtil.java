package com.company.createModel.util;

import com.company.createModel.config.DatabaseConfigs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author: 孙斌
 * @create: 2020-06-28 17:36
 **/
public class FileDatabaseUtil {

    /**
     * 生成ModeL
     * @param tableNames        表名
     * @param columnNames       列名
     * @param columnTypes       列类型
     * @param columnComments    列注释
     * @return
     */
    public static Boolean generateFileModels(String tableNames, List<String> columnNames, List<String> columnTypes, List<String> columnComments) {
        String tableName = captureName(tableNames);
        Map<String, String> columnType = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append("package com.company.createModel.entity;\n\n");
        sb.append("import java.util.Date;\n");
        sb.append("import java.math.BigDecimal;\n\n");
        sb.append("public class ");
        sb.append(tableName);
        sb.append("{\n\n");
        for (int i = 0; i < columnNames.size(); i++) {
            String type = columnType(columnTypes.get(i),columnNames.get(i));
            String littleCaptureName = littleCaptureName(columnNames.get(i));
            //注释
            sb.append("    /**\n");
            sb.append("     * 列名:" + littleCaptureName + "\n");
            sb.append("     * 数据库类型:" + columnTypes.get(i) + "\n");
            sb.append("     * 数据库注释:" + columnComments.get(i) + "\n");
            sb.append("     */\n");
            //字段
            sb.append("    private");
            sb.append(" " + type);
            sb.append(" " + littleCaptureName + ";\n\n\n");
            columnType.put(columnNames.get(i), type);
        }
        //getset方法
        for (int i = 0; i < columnNames.size(); i++) {
            //大写首字母
            String name = columnNames.get(i);
            String capName = captureName(name);
            String type = columnType.get(columnNames.get(i));
            String littleCaptureName = littleCaptureName(columnNames.get(i));
            sb.append("    public");
            sb.append(" " + type);
            sb.append(" get" + capName + "() {\n");
            sb.append("        return " + littleCaptureName + ";\n");
            sb.append("    }\n\n");
            sb.append("    public");
            sb.append(" void");
            sb.append(" set" + capName + "(" + type + " " + littleCaptureName + ") {\n");
            sb.append("        this. " + littleCaptureName + " = " + littleCaptureName + ";\n");
            sb.append("    }\n\n");
        }
        sb.append("}");
        generateFileModel(tableName, sb.toString(), DatabaseConfigs.PATHS + "entity\\" + tableName + ".java");
        return true;
    }


    /**
     * 生成Dao 创建 修改 查询单个
     * @param tableNames        表名
     * @param columnNames       列名
     * @param columnTypes       列类型
     * @param columnComments    列注释
     * @return
     */
    public static Boolean generateFileDaos(String tableNames, List<String> columnNames, List<String> columnTypes, List<String> columnComments) {
        String tableName = captureName(tableNames);
        Map<String, String> columnType = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append("package " + DatabaseConfigs.PACKAGEPATHS + ".dao;\n\n");
        sb.append("import java.util.Date;\n");
        sb.append("import java.math.BigDecimal;\n");
        sb.append("import org.apache.ibatis.annotations.*;\n");
        sb.append("import org.apache.ibatis.jdbc.SQL;\n");
        sb.append("import " + DatabaseConfigs.PACKAGEPATHS + ".entity." + tableName + ";\n\n");
        sb.append("@Mapper\n");
        sb.append("public interface " + tableName + "Dao{\n\n");
        sb.append("    /**\n");
        sb.append("     * 添加\n");
        sb.append("     * @param model   实体类\n");
        sb.append("     */\n");
        sb.append("    @InsertProvider(type = " + tableName + "DaoProvider.class, method = \"create\")\n");
        sb.append("    Integer create(" + tableName + " model);\n\n");
        sb.append("    /**\n");
        sb.append("     * 修改\n");
        sb.append("     * @param model   实体类\n");
        sb.append("     */\n");
        sb.append("    @UpdateProvider(type = " + tableName + "DaoProvider.class, method = \"update\")\n");
        sb.append("    Integer update(" + tableName + " model);\n\n");
        sb.append("    /**\n");
        sb.append("     * 查询\n");
        sb.append("     * @param model   实体类\n");
        sb.append("     */\n");
        sb.append("    @SelectProvider(type = " + tableName + "DaoProvider.class, method = \"query\")\n");
        sb.append("    Integer query(" + tableName + " model);\n\n");
        sb.append("\n\n\n");
        sb.append("    class " + tableName + "DaoProvider{\n");
        sb.append(daoCreate(tableNames,columnNames,columnTypes,columnComments));
        sb.append(daoUpdate(tableNames,columnNames,columnTypes,columnComments));
        sb.append(daoQuery(tableNames,columnNames,columnTypes,columnComments));
        sb.append("    }\n");
        sb.append("}\n");
        generateFileModel(tableNames, sb.toString(), DatabaseConfigs.PATHS + "dao\\" + tableName + "Dao.java");
        return true;
    }


    /**
     * 添加
     * @param tableNames
     * @param columnNames
     * @param columnTypes
     * @param columnComments
     * @return
     */
    private static String daoCreate(String tableNames, List<String> columnNames, List<String> columnTypes, List<String> columnComments){
        StringBuilder sb = new StringBuilder();
        String tableName = captureName(tableNames);
        sb.append("\n");
        sb.append("        /**\n");
        sb.append("         * 创建\n");
        sb.append("         * @param model   实体类\n");
        sb.append("         */\n");
        sb.append("        public String create(final " + tableName + " model){\n");
        sb.append("            return new SQL(){{\n");
        sb.append("            INSERT_INTO(\"" + tableNames + "\");\n");
        for (int i = 0; i < columnNames.size(); i++) {
            String name = columnNames.get(i);
            //大写首字母
            String capName = captureName(name);
            String littleCaptureName = littleCaptureName(name);
            String type = columnType(columnTypes.get(i),columnNames.get(i));
            if("String".equals(type)) {
                sb.append("                if(!(model.get" + capName + "() == null || model.get" + capName + "().isEmpty())){\n");
            }else {
                sb.append("                if(model.get" + capName + "() != null){\n");
            }
            sb.append("                    VALUES(\"" + name + "\", \"#{" + littleCaptureName + "}\");\n");
            sb.append("                }\n");
        }
        sb.append("            }}.toString();\n");
        sb.append("        }\n\n");
        return sb.toString();
    }

    /**
     * 修改
     * @param tableNames
     * @param columnNames
     * @param columnTypes
     * @param columnComments
     * @return
     */
    private static String daoUpdate(String tableNames, List<String> columnNames, List<String> columnTypes, List<String> columnComments){
        StringBuilder sb = new StringBuilder();
        String tableName = captureName(tableNames);
        sb.append("\n");
        sb.append("        /**\n");
        sb.append("         * 修改\n");
        sb.append("         * @param model   实体类\n");
        sb.append("         */\n");
        sb.append("        public String update(final " + tableName + " model){\n");
        sb.append("            return new SQL(){{\n");
        sb.append("            UPDATE(\"" + tableNames + "\");\n");
        for (int i = 0; i < columnNames.size(); i++) {
            String name = columnNames.get(i);
            //大写首字母
            String capName = captureName(name);
            String littleCaptureName = littleCaptureName(name);
            String type = columnType(columnTypes.get(i),columnNames.get(i));
            if("String".equals(type)) {
                sb.append("                if(!(model.get" + capName + "() == null || model.get" + capName + "().isEmpty())){\n");
            }else {
                sb.append("                if(model.get" + capName + "() != null){\n");
            }
            sb.append("                    SET(\"" + name + "=#{" + littleCaptureName + "}\");\n");
            sb.append("                }\n");
        }
        sb.append("                    WHERE(\"id=#{id}\");\n");
        sb.append("            }}.toString();\n");
        sb.append("        }\n\n");
        return sb.toString();
    }

    /**
     * 修改
     * @param tableNames
     * @param columnNames
     * @param columnTypes
     * @param columnComments
     * @return
     */
    private static String daoQuery(String tableNames, List<String> columnNames, List<String> columnTypes, List<String> columnComments){
        StringBuilder sb = new StringBuilder();
        String tableName = captureName(tableNames);
        //别名
        char alias = tableNames.charAt(0);
        sb.append("\n");
        sb.append("        /**\n");
        sb.append("         * 查询\n");
        sb.append("         * @param model   实体类\n");
        sb.append("         */\n");
        sb.append("        public String query(final " + tableName + " model){\n");
        sb.append("            StringBuilder sb = new StringBuilder();\n");
        sb.append("            sb.append(\" SELECT \");\n");
        sb.append("            sb.append(\"");
        for (int i = 0; i < columnNames.size(); i++) {
            if(i == 0){
                sb.append(" " + alias + "." + columnNames.get(i) + ",");
                continue;
            }
            if(i == (columnNames.size() - 1)){
                sb.append(" " + alias + "." + columnNames.get(i) + "\");\n");
                continue;
            }
            if(i % 5 == 0){
                sb.append("\");\n");
                sb.append("            sb.append(\"");
            }else {
                sb.append(" " + alias + "." + columnNames.get(i) + ",");
            }
        }
        sb.append("            sb.append(\" FROM " + tableNames + " " + alias + "\");\n");
        sb.append("            return sb.toString();\n");
        sb.append("        }\n\n");
        return sb.toString();
    }


    /**
     * 生成model文件
     *
     * @return
     */
    public static Boolean generateFileModel(String tableName, String model,String path) {
        OutputStream out = null;
        try {
            out = new FileOutputStream(getFile(path));
            out.write(model.getBytes());
        } catch (Exception e) {
            System.out.println("发生异常!!!" + e);
        } finally {
            try {
                out.close();
            } catch (Exception e) {
                System.out.println("关闭失败!!!" + e);
            }
        }
        return true;
    }

    /**
     * 将数据库类型转换为java类型
     *
     * @param dataType
     * @return
     */
    private static String columnType(String dataType,String columnName) {
        if (dataType == null) {
            return "String";
        }
        //字符串类型
        if (stringType(dataType)) {
            return "String";
        }
        //Integer类型
        if (integerType(dataType)) {
            if(dataType.length() < 2){
                return "Integer";
            }
            if("id".equals(columnName.substring(columnName.length()-2)) || "Id".equals(columnName.substring(columnName.length()-2))){
                return "Long";
            }
            return "Integer";
        }
        //decimal类型
        if (decimalType(dataType)) {
            return "BigDecimal";
        }
        //dates类型
        if (dateType(dataType)) {
            return "Date";
        }
        return "String";
    }

    /**
     * 判断是否为字符串类型
     *
     * @param dataType
     * @return
     */
    private static Boolean stringType(String dataType) {
        if ("CHAR".equals(dataType)) {
            return true;
        }
        if ("VARCHAR".equals(dataType)) {
            return true;
        }
        if ("TINYTEXT".equals(dataType)) {
            return true;
        }
        if ("TEXT".equals(dataType)) {
            return true;
        }
        if ("MEDIUMTEXT".equals(dataType)) {
            return true;
        }
        if ("LONGTEXT".equals(dataType)) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否为int类型
     *
     * @param dataType
     * @return
     */
    private static Boolean integerType(String dataType) {
        if ("TINYINT".equals(dataType)) {
            return true;
        }
        if ("SMALLINT".equals(dataType)) {
            return true;
        }
        if ("MEDIUMINT".equals(dataType)) {
            return true;
        }
        if ("INT".equals(dataType)) {
            return true;
        }
        if ("BIGINT".equals(dataType)) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否为多精点类型
     *
     * @param dataType
     * @return
     */
    private static Boolean decimalType(String dataType) {
        if ("FLOAT".equals(dataType)) {
            return true;
        }
        if ("DOUBLE".equals(dataType)) {
            return true;
        }
        if ("DECIMAL".equals(dataType)) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否为date类型
     *
     * @param dataType
     * @return
     */
    private static Boolean dateType(String dataType) {
        if ("DATE".equals(dataType)) {
            return true;
        }
        if ("DATETIME".equals(dataType)) {
            return true;
        }
        if ("TIMESTAMP".equals(dataType)) {
            return true;
        }
        if ("TIME".equals(dataType)) {
            return true;
        }
        return false;
    }

    /**
     * 首字母大写 如果有下划线 那么下划线之后的第一个字符大写
     * @param name
     * @return
     */
    public static String captureName(String name) {
        String[] strs = null;
        if(name == null){
            return null;
        }
        strs = name.split("_");
        if (strs == null || strs.length < 1){
            strs = new String[]{name};
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strs){
            char[] cs = str.toCharArray();
            cs[0] -= 32;
            sb.append(String.valueOf(cs));
        }
        return sb.toString();
    }


    /**
     * 首字母小写 如果有下划线 那么下划线之后的第一个字符大写
     * @param name
     * @return
     */
    public static String littleCaptureName(String name) {
        String[] strs = null;
        if(name == null){
            return null;
        }
        strs = name.split("_");
        if (strs == null || strs.length < 1){
            strs = new String[]{name};
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : strs){
            if(i == 0){
               sb.append(str);
               ++i;
               continue;
            }
            char[] cs = str.toCharArray();
            cs[0] -= 32;
            sb.append(String.valueOf(cs));
        }
        return sb.toString();
    }

    /**
     * 获取文件判断是否存在
     * @param filePath
     * @return
     */
    private static File getFile(String filePath) {//传入文件路bai径
        File file = new File(filePath);//创建zhiFile对象
        if (!file.exists()) {//判断f 如果不存在,就创建
            try {
                file.createNewFile();//创建
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;//返回File对象
    }


}
