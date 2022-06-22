package com.jeramtough.jtcodegenerator.generator.custom;

import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.code.GeneratorTag;
import com.jeramtough.jtcodegenerator.generator.template.*;
import com.jeramtough.jtcodegenerator.generator.template.js.JsApiHandlerJtTemplate;
import com.jeramtough.jtcodegenerator.generator.template.js.JsApiJtTemplate;
import com.jeramtough.jtcodegenerator.generator.template.js.JsHttpClientV2JtTemplate;
import com.jeramtough.jtcodegenerator.generator.template.js.JsHttpConstantsJtTemplate;

import java.util.List;

/**
 * <pre>
 * Created on 2021/12/29 下午4:18
 * by @author WeiBoWen
 * </pre>
 */
public class JsCustomCodeGenerator extends BaseCustomCodeGenerator {

    public JsCustomCodeGenerator(
            GeneratorTag tag,
            GeneratorConfigAdapter generatorConfigAdapter) {
        super(tag, generatorConfigAdapter);
    }

    @Override
    protected void initTemplates(
            List<JtTemplate> jtTemplateList) {
        jtTemplateList.add(new JsApiJtTemplate());
        jtTemplateList.add(new JsApiHandlerJtTemplate());
        jtTemplateList.add(new JsHttpClientV2JtTemplate());
        jtTemplateList.add(new JsHttpConstantsJtTemplate());
    }

}