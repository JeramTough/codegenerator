package com.jeramtough.jtcodegenerator.generator.template.rx.java;

import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.bean.EachTableInfo;
import com.jeramtough.jtcodegenerator.generator.template.BaseJtTemplate;

/**
 * <pre>
 * Created on 2021/12/29 下午4:51
 * by @author 北京瑞曦wjx
 * </pre>
 */
public class BasicServiceRxTemplate extends BaseJtTemplate {

    public BasicServiceRxTemplate(GeneratorConfigAdapter generatorConfigAdapter) {
        super(generatorConfigAdapter);
    }

    @Override
    public boolean isCreated() {
        return false;
    }

    @Override
    public String getTemplatePath() {
        return "templates/JAVA/rx/MyBaseService.java.vm";
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
