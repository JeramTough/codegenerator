package com.jeramtough.jtcodegenerator.generator.adapter;

/**
 * <pre>
 * Created on 2020/5/23 16:25
 * by @author JeramTough
 * </pre>
 */
public interface GeneratorConfigAdapter {


    String getBasePackageName();

    String getBusinessPrefix();

    /**
     *
     */
    boolean isSkipView();


    String getOutputDir();

    String getAuthor();

    String getUrl();

    String getDriverName();

    String[] getUsernameAndPassword();

    default String getProjectName() {
        String basePackageName = getBasePackageName();
        String[] ss = basePackageName.split("\\.");
        return ss[ss.length - 1];
    }
}
