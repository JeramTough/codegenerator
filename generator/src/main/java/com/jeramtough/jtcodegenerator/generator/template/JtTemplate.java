package com.jeramtough.jtcodegenerator.generator.template;

import com.jeramtough.jtcodegenerator.generator.bean.EachTableInfo;

import java.io.File;

/**
 * <pre>
 * Created on 2021/12/29 下午4:45
 * by @author WeiBoWen
 * </pre>
 */
public interface JtTemplate {

    void generating(EachTableInfo eachTableInfo, File outputDir);

}
