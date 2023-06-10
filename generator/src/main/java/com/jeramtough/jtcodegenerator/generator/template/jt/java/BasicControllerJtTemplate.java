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
public class BasicControllerJtTemplate extends BaseJtTemplate {

    public BasicControllerJtTemplate(GeneratorConfigAdapter generatorConfigAdapter) {
        super(generatorConfigAdapter);
    }

    @Override
    public String getTemplatePath() {
        return "templates/JAVA/jt/MyBaseController.java.vm";
    }

    @Override
    public String getPackageName(EachTableInfo eachTableInfo) {
        return "action.controller";
    }

    @Override
    public String getFileName(EachTableInfo eachTableInfo) {
        return "MyBaseController.java";
    }
}
