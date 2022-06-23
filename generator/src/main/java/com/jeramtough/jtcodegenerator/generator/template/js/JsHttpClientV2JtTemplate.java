package com.jeramtough.jtcodegenerator.generator.template.js;

import com.jeramtough.jtcodegenerator.generator.bean.EachTableInfo;
import com.jeramtough.jtcodegenerator.generator.template.BaseJtTemplate;

/**
 * <pre>
 * Created on 2021/12/29 下午4:51
 * by @author WeiBoWen
 * </pre>
 */
public class JsHttpClientV2JtTemplate extends BaseJtTemplate {

    @Override
    protected String getTemplatePath() {
        return "templates/JS/jt/HttpClientV2.js.vm";
    }

    @Override
    protected String getPackageName(EachTableInfo eachTableInfo) {
        return "api.base";
    }

    @Override
    protected String getFileName(EachTableInfo eachTableInfo) {
        return "HttpClientV2.js";
    }
}
