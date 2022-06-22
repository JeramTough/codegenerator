package com.jeramtough.jtcodegenerator.generator.path;

import com.jeramtough.jtcodegenerator.generator.code.GeneratorTag;

import java.io.File;

/**
 * <pre>
 * Created on 2021/12/30 下午4:50
 * by @author WeiBoWen
 * </pre>
 */
public class PathHandler {

    private final String baseOutputPath;
    private String javaOutputPath;
    private String jsOutputPath;

    public PathHandler(String baseOutputPath) {
        this.baseOutputPath = baseOutputPath;

        init();
    }

    protected void init() {
        javaOutputPath = getJavaPath(baseOutputPath);
        jsOutputPath = getJsPath(baseOutputPath);
    }

    public String getJavaOutputPath() {
        return javaOutputPath;
    }

    public String getJsOutputPath() {
        return jsOutputPath;
    }

    public String getOutputPath(GeneratorTag tag) {
        return switch (tag) {
            case JAVA -> getJavaOutputPath();
            case JS -> getJsOutputPath();
        };
    }

    //**************

    private String getJavaPath(String basePath) {
        String path = basePath + File.separator + "src" + File.separator
                + "main" + File.separator + "java";
        return path;
    }

    private String getJsPath(String basePath) {
        String path = basePath + File.separator + "src" + File.separator
                + "main" + File.separator + "resources" + File.separator + "js";
        return path;
    }

}
