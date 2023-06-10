package com.jeramtough.jtcodegenerator.generator.template.jt.js;

import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.bean.EachTableInfo;
import com.jeramtough.jtcodegenerator.generator.template.BaseJtTemplate;

/**
 * <pre>
 * Created on 2021/12/29 下午4:51
 * by @author 北京瑞曦wjx
 * </pre>
 */
public class JsHttpClientV2JtTemplate extends BaseJtTemplate {

    public JsHttpClientV2JtTemplate(GeneratorConfigAdapter generatorConfigAdapter) {
        super(generatorConfigAdapter);
    }

    @Override
    public String getTemplatePath() {
        return "templates/JS/jt/HttpClientV2.js.vm";
    }

    @Override
    public String getPackageName(EachTableInfo eachTableInfo) {
        return "api.base";
    }

    @Override
    public String getFileName(EachTableInfo eachTableInfo) {
        return "HttpClientV2.js";
    }
}
