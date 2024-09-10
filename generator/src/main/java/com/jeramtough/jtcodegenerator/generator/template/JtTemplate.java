package com.jeramtough.jtcodegenerator.generator.template;

import com.jeramtough.jtcodegenerator.generator.bean.EachTableInfo;

import java.io.File;

/**
 * <pre>
 * Created on 2021/12/29 下午4:45
 * by @author 北京瑞曦wjx
 * </pre>
 */
public interface JtTemplate {

    boolean isCreated();

    void generating(EachTableInfo eachTableInfo, File outputDir);

    String getTemplatePath();

    String getPackageName(EachTableInfo eachTableInfo);

    String getFileName(EachTableInfo eachTableInfo);

    void generationBefore(EachTableInfo eachTableInfo);
}
