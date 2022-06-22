package com.jeramtough.jtcodegenerator.generator.template.js;

import com.jeramtough.jtcodegenerator.generator.bean.EachTableInfo;
import com.jeramtough.jtcodegenerator.generator.template.BaseJtTemplate;

/**
 * <pre>
 * Created on 2021/12/29 下午4:51
 * by @author WeiBoWen
 * </pre>
 */
public class JsHttpConstantsJtTemplate extends BaseJtTemplate {

    @Override
    protected String getTemplatePath() {
        return "templates/JS/HttpConstants.js.vm";
    }

    @Override
    protected String getPackageName(EachTableInfo eachTableInfo) {
        return "api.base";
    }

    @Override
    protected String getFileName(EachTableInfo eachTableInfo) {
        return "HttpConstants.js";
    }
}