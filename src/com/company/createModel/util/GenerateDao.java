package com.company.createModel.util;

import com.company.createModel.config.DatabaseConfigs;

import java.util.*;

/**
 * @author: 孙斌
 * @create: 2020-06-28 17:36
 **/
public class GenerateDao {


    /**
     * 生成Dao 创建 修改 查询单个
     *
     * @param tableNames     表名
     * @param columnNames    列名
     * @param columnTypes    列类型
     * @param columnComments 列注释
     * @return
     */
    public static Boolean generateFileDaos(String tableNames, List<String> columnNames, List<String> columnTypes, List<String> columnComments) {
        String tableName = HumpName.captureName(tableNames);
        StringBuilder sb = new StringBuilder();
        sb.append("package " + DatabaseConfigs.PACKAGEPATHS + ".dao;\n\n");
        sb.append("import " + DatabaseConfigs.PACKAGEPATHS + ".entity." + tableName + ";\n");
        sb.append("import org.apache.ibatis.annotations.*;\n");
        sb.append("import org.apache.ibatis.jdbc.SQL;\n\n");
        sb.append("import java.util.Date;\n");
        sb.append("import java.util.List;\n");
        sb.append("import java.util.Map;\n");
        sb.append("import java.math.BigDecimal;\n\n");
        sb.append("/**\n");
        sb.append(" * 表名: " + tableNames + "\n");
        sb.append(" * @author: " + DatabaseConfigs.AUTHOR + "\n");
        sb.append(" * @create: " + DateUtil.SimpleDateFormatDateNoSSS(new Date()) + "\n");
        sb.append(" **/\n");
        sb.append("@Mapper\n");
        sb.append("public interface " + tableName + "Dao{\n\n");
        sb.append("    /**\n");
        sb.append("     * 添加\n");
        sb.append("     * @param model   实体类\n");
        sb.append("     */\n");
        sb.append("    @InsertProvider(type = " + tableName + "Dao." + tableName + "DaoProvider.class, method = \"create\")\n");
        sb.append("    Integer create(" + tableName + " model);\n\n");
        sb.append("    /**\n");
        sb.append("     * 修改\n");
        sb.append("     * @param model   实体类\n");
        sb.append("     */\n");
        sb.append("    @UpdateProvider(type = " + tableName + "Dao." + tableName + "DaoProvider.class, method = \"update\")\n");
        sb.append("    Integer update(" + tableName + " model);\n\n");
        sb.append("    /**\n");
        sb.append("     * 查询\n");
        sb.append("     * @param model   实体类\n");
        sb.append("     */\n");
        sb.append("    @SelectProvider(type = " + tableName + "Dao." + tableName + "DaoProvider.class, method = \"findAll\")\n");
        sb.append("    List<" + tableName + "> findAll(" + tableName + " model);\n\n");
        sb.append("    /**\n");
        sb.append("     * 批量添加\n");
        sb.append("     * @param model   实体类\n");
        sb.append("     */\n");
        sb.append("    @SelectProvider(type = " + tableName + "Dao." + tableName + "DaoProvider.class, method = \"createAll\")\n");
        sb.append("    Integer createAll(@Param(\"list\") List<" + tableName + "> model);\n\n");
        sb.append("\n\n\n");
        sb.append("    class " + tableName + "DaoProvider{\n");
        sb.append(daoCreate(tableNames, columnNames, columnTypes, columnComments));
        sb.append(daoUpdate(tableNames, columnNames, columnTypes, columnComments));
        sb.append(daoQuery(tableNames, columnNames, columnTypes, columnComments));
        sb.append(daoCreateAll(tableNames, columnNames, columnTypes, columnComments));
        sb.append("    }\n");
        sb.append("}\n");
        FileUtil.generateFileModel(tableNames, sb.toString(), DatabaseConfigs.PATHS + "dao\\" + tableName + "Dao.java");
        return true;
    }


    /**
     * 添加
     *
     * @param tableNames
     * @param columnNames
     * @param columnTypes
     * @param columnComments
     * @return
     */
    private static String daoCreate(String tableNames, List<String> columnNames, List<String> columnTypes, List<String> columnComments) {
        StringBuilder sb = new StringBuilder();
        String tableName = HumpName.captureName(tableNames);
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
            String capName = HumpName.captureName(name);
            String littleCaptureName = HumpName.littleCaptureName(name);
            String type = judgeFieldTypeUtil.columnType(columnTypes.get(i), columnNames.get(i));
            if ("String".equals(type)) {
                sb.append("                if(!(model.get" + capName + "() == null || model.get" + capName + "().isEmpty())){\n");
            } else {
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
     *
     * @param tableNames
     * @param columnNames
     * @param columnTypes
     * @param columnComments
     * @return
     */
    private static String daoUpdate(String tableNames, List<String> columnNames, List<String> columnTypes, List<String> columnComments) {
        StringBuilder sb = new StringBuilder();
        String tableName = HumpName.captureName(tableNames);
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
            String capName = HumpName.captureName(name);
            String littleCaptureName = HumpName.littleCaptureName(name);
            String type = judgeFieldTypeUtil.columnType(columnTypes.get(i), columnNames.get(i));
            if ("String".equals(type)) {
                sb.append("                if(!(model.get" + capName + "() == null || model.get" + capName + "().isEmpty())){\n");
            } else {
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
     * 查询
     *
     * @param tableNames
     * @param columnNames
     * @param columnTypes
     * @param columnComments
     * @return
     */
    private static String daoQuery(String tableNames, List<String> columnNames, List<String> columnTypes, List<String> columnComments) {
        StringBuilder sb = new StringBuilder();
        String tableName = HumpName.captureName(tableNames);
        //别名
        char alias = tableNames.charAt(0);
        sb.append("\n");
        sb.append("        /**\n");
        sb.append("         * 查询\n");
        sb.append("         * @param model   实体类\n");
        sb.append("         */\n");
        sb.append("        public String findAll(final " + tableName + " model){\n");
        sb.append("            StringBuilder sb = new StringBuilder();\n");
        sb.append("            sb.append(\" SELECT \");\n");
        sb.append("            sb.append(\"");
        for (int i = 0; i < columnNames.size(); i++) {
            if (i == 0) {
                sb.append(" " + alias + "." + columnNames.get(i) + ",");
                continue;
            }
            if (i == (columnNames.size() - 1)) {
                sb.append(" " + alias + "." + columnNames.get(i) + "\");\n");
                continue;
            }
            if (i % 5 == 0) {
                sb.append("\");\n");
                sb.append("            sb.append(\"");
                sb.append(" " + alias + "." + columnNames.get(i) + ",");
            } else {
                sb.append(" " + alias + "." + columnNames.get(i) + ",");
            }
        }
        sb.append("            sb.append(\" FROM " + tableNames + " " + alias + "\");\n");
        sb.append("            return sb.toString();\n");
        sb.append("        }\n\n");
        return sb.toString();
    }

    /**
     * 批量添加
     *
     * @param tableNames
     * @param columnNames
     * @param columnTypes
     * @param columnComments
     * @return
     */
    private static String daoCreateAll(String tableNames, List<String> columnNames, List<String> columnTypes, List<String> columnComments) {
        StringBuilder sb = new StringBuilder();
        String tableName = HumpName.captureName(tableNames);
        //别名
        char alias = tableNames.charAt(0);
        sb.append("\n");
        sb.append("        /**\n");
        sb.append("         * 批量添加\n");
        sb.append("         * @param map   实体类\n");
        sb.append("         */\n");
        sb.append("        public String createAll(final Map map){\n");
        sb.append("            List<" + tableName + "> model = (List<" + tableName + ">) map.get(\"list\");\n");
        sb.append("            return new SQL() {{\n");
        sb.append("                INSERT_INTO(\"" + tableNames + "\");\n");
        sb.append("                INTO_COLUMNS(");
        for (int i = 0; i < columnNames.size(); i++) {
            if (i == 0) {
                sb.append("\"" + columnNames.get(i) + "\",");
                continue;
            }
            if (i == (columnNames.size() - 1)) {
                sb.append(" \"" + columnNames.get(i) + "\");\n");
                continue;
            }
            if (i % 7 == 0) {
                sb.append("\n                       ");
            }
            sb.append(" \"" + columnNames.get(i) + "\",");
        }
        sb.append("                for (int i = 0; i < model.size(); i++) {\n");
        sb.append("                    INTO_VALUES(");
        for (int i = 0; i < columnNames.size(); i++) {
            String name = columnNames.get(i);
            String littleCaptureName = HumpName.littleCaptureName(name);
            if (i == 0) {
                sb.append("\"#{list[\" + i + \"]." + littleCaptureName + "}\",");
                continue;
            }
            if (i == (columnNames.size() - 1)) {
                sb.append("\"#{list[\" + i + \"]." + littleCaptureName + "}\");\n");
                continue;
            }
            if (i % 2 == 0) {
                sb.append("\n                           ");
            }
            sb.append(" \"#{list[\" + i + \"]." + littleCaptureName + "}\",");
        }
        sb.append("                }\n");
        sb.append("            }}.toString();\n");
        sb.append("        }\n\n");
        return sb.toString();
    }


}
