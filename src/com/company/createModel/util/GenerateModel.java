package com.company.createModel.util;

import com.company.createModel.config.DatabaseConfigs;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 孙斌
 * @date 2021-01-2021/1/29 16:36
 */
public class GenerateModel {

    /**
     * 生成ModeL
     *
     * @param tableNames     表名
     * @param columnNames    列名
     * @param columnTypes    列类型
     * @param columnComments 列注释
     * @return
     */
    public static Boolean generateFileModels(String tableNames, List<String> columnNames, List<String> columnTypes, List<String> columnComments) {
        String tableName = HumpName.captureName(tableNames);
        Map<String, String> columnType = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append("package " + DatabaseConfigs.PACKAGEPATHS + ".entity;\n\n");
        sb.append("import java.util.Date;\n");
        sb.append("import java.math.BigDecimal;\n\n");
        sb.append("/**\n");
        sb.append(" * " + tableNames + "\n");
        sb.append(" * @author: " + DatabaseConfigs.AUTHOR + "\n");
        sb.append(" * @create: " + DateUtil.SimpleDateFormatDateNoSSS(new Date()) + "\n");
        sb.append(" **/\n");
        sb.append("public class ");
        sb.append(tableName);
        sb.append("{\n\n");
        for (int i = 0; i < columnNames.size(); i++) {
            String type = judgeFieldTypeUtil.columnType(columnTypes.get(i), columnNames.get(i));
            String littleCaptureName = HumpName.littleCaptureName(columnNames.get(i));
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
            String capName = HumpName.captureName(name);
            String type = columnType.get(columnNames.get(i));
            String littleCaptureName = HumpName.littleCaptureName(columnNames.get(i));
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
        FileUtil.generateFileModel(tableName, sb.toString(), DatabaseConfigs.PATHS + "entity\\" + tableName + ".java");
        return true;
    }
}
