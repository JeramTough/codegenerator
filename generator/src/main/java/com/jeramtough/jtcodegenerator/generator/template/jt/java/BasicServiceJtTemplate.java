package com.jeramtough.jtcodegenerator.generator.template.jt.java;

import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.bean.EachTableInfo;
import com.jeramtough.jtcodegenerator.generator.template.BaseJtTemplate;

/**
 * <pre>
 * Created on 2021/12/29 下午4:51
 * by @author 北京瑞曦wjx
 * </pre>
 */
public class BasicServiceJtTemplate extends BaseJtTemplate {

    public BasicServiceJtTemplate(GeneratorConfigAdapter generatorConfigAdapter) {
        super(generatorConfigAdapter);
    }

    @Override
    public String getTemplatePath() {
        return "templates/JAVA/jt/MyBaseService.java.vm";
    }

    @Override
    public String getPackageName(EachTableInfo eachTableInfo) {
        return "service.base";
    }

    @Override
    public String getFileName(EachTableInfo eachTableInfo) {
        return "MyBaseService.java";
    }
}
