package com.company.createModel.util;

import com.company.createModel.config.DatabaseConfigs;

import java.io.*;

/**
 * 生成文件
 *
 * @author 孙斌
 * @date 2021-01-2021/1/29 16:29
 */
public class FileUtil {

    /**
     * 生成所有需要生成的文件夹
     */
    public static  void createAllFolder(){
        System.out.println("生成文件夹开始！！！");
        //创建entity文件夹
        FileUtil.createAFolder(DatabaseConfigs.PATHS + "entity");
        //创建model文件夹
        FileUtil.createAFolder(DatabaseConfigs.PATHS + "model");
        //创建dao文件夹
        FileUtil.createAFolder(DatabaseConfigs.PATHS + "dao");
        //创建service\impl文件夹
        FileUtil.createAFolder(DatabaseConfigs.PATHS + "service\\impl");
        //创建service文件夹
        FileUtil.createAFolder(DatabaseConfigs.PATHS + "service");
        //创建controller文件夹
        FileUtil.createAFolder(DatabaseConfigs.PATHS + "controller");
        System.out.println("生成文件夹结束！！！");
    }

    /**
     * 创建文件夹
     * @param path
     * @return
     */
    public static void createAFolder(String path) {
        File file = new File(path);//创建zhiFile对象
        if (!file.exists()) {//判断f 如果不存在,就创建
            try {
                file.mkdirs();
                System.out.println("生成文件夹成功！！！");
            } catch (Exception e) {
                System.out.println("生成文件夹失败，原因如下！！！");
                e.printStackTrace();
            }
        }
    }

    /**
     * 生成文件
     *
     * @return
     */
    public static Boolean generateFileModel(String tableName, String model, String path) {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(getFile(path)));
            bufferedOutputStream.write(model.getBytes());
        } catch (Exception e) {
            System.out.println("发生异常!!!" + e);
        } finally {
            try {
                bufferedOutputStream.close();
            } catch (Exception e) {
                System.out.println("关闭失败!!!" + e);
            }
        }
        return true;
    }


    /**
     * 获取文件判断是否存在
     *
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
