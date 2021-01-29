package com.company.createModel.util;

/**
 * @author 孙斌
 * @date 2021-01-2021/1/29 16:34
 */
public class HumpName {

    /**
     * 首字母大写 如果有下划线 那么下划线之后的第一个字符大写
     *
     * @param name
     * @return
     */
    public static String captureName(String name) {
        String[] strs = null;
        if (name == null) {
            return null;
        }
        strs = name.split("_");
        if (strs == null || strs.length < 1) {
            strs = new String[]{name};
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            char[] cs = str.toCharArray();
            cs[0] -= 32;
            sb.append(String.valueOf(cs));
        }
        return sb.toString();
    }


    /**
     * 首字母小写 如果有下划线 那么下划线之后的第一个字符大写
     *
     * @param name
     * @return
     */
    public static String littleCaptureName(String name) {
        String[] strs = null;
        if (name == null) {
            return null;
        }
        strs = name.split("_");
        if (strs == null || strs.length < 1) {
            strs = new String[]{name};
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : strs) {
            if (i == 0) {
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
}
