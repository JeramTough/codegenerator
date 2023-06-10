package com.jeramtough.jtcodegenerator.generator.util;

import java.io.File;

/**
 * <pre>
 * Created on 2021/12/30 下午4:26
 * by @author 北京瑞曦wjx
 * </pre>
 */
public class MyIoUtil {

    public static String getPathByPackagePath(String packagePath) {
        String[] ss = packagePath.split("\\.");
        StringBuilder path = new StringBuilder();
        for (String s : ss) {
            path.append(s).append(File.separator);
        }
        return path.toString();
    }

    public static String getPathFromFilePathAndPackagePath(String filePath,
                                                           String packagePath) {
        String path = filePath + File.separator + getPathByPackagePath(packagePath);
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

}
