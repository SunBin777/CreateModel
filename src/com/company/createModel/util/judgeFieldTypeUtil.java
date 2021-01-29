package com.company.createModel.util;

/**
 * 判断字段类型
 * @author 孙斌
 * @date 2021-01-2021/1/29 16:30
 */
public class judgeFieldTypeUtil {



    /**
     * 将数据库类型转换为java类型
     *
     * @param dataType
     * @return
     */
    public static String columnType(String dataType, String columnName) {
        if (dataType == null) {
            return "String";
        }
        //字符串类型
        if (stringType(dataType)) {
            return "String";
        }
        //Integer类型
        if (integerType(dataType)) {
            if (dataType.length() < 2) {
                return "Integer";
            }
            if ("id".equals(columnName.substring(columnName.length() - 2)) || "Id".equals(columnName.substring(columnName.length() - 2))) {
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
        //Boolean类型
        if (boolType(dataType)) {
            return "Boolean";
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
     * 判断是否为布尔类型
     *
     * @param dataType
     * @return
     */
    private static Boolean boolType(String dataType) {
        if ("BIT".equals(dataType)) {
            return true;
        }
        return false;
    }
}
