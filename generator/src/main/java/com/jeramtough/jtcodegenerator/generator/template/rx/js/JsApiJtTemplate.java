package com.jeramtough.jtcodegenerator.generator.template.rx.js;

import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.bean.EachTableInfo;
import com.jeramtough.jtcodegenerator.generator.template.BaseJtTemplate;

/**
 * <pre>
 * Created on 2021/12/29 下午4:51
 * by @author 北京瑞曦wjx
 * </pre>
 */
public class JsApiJtTemplate extends BaseJtTemplate {

    public JsApiJtTemplate(GeneratorConfigAdapter generatorConfigAdapter) {
        super(generatorConfigAdapter);
    }

    @Override
    public String getTemplatePath() {
        return "templates/JS/jt/Api.js.vm";
    }

    @Override
    public String getPackageName(EachTableInfo eachTableInfo) {
        String projectName = (String) eachTableInfo.getObjectMap().get("projectName");

        return "api." + projectName;
    }

    @Override
    public String getFileName(EachTableInfo eachTableInfo) {
        return eachTableInfo.getTableInfo().getEntityName() + "Api.js";
    }
}
