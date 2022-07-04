package com.jeramtough.jtcodegenerator.generator.custom;

import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.code.GeneratorTag;
import com.jeramtough.jtcodegenerator.generator.params.TemplateParamsInitializer;
import com.jeramtough.jtcodegenerator.generator.params.jt.JtTemplateParamsInitializer;
import com.jeramtough.jtcodegenerator.generator.template.*;
import com.jeramtough.jtcodegenerator.generator.template.jt.js.JsApiHandlerJtTemplate;
import com.jeramtough.jtcodegenerator.generator.template.jt.js.JsApiJtTemplate;
import com.jeramtough.jtcodegenerator.generator.template.jt.js.JsHttpClientV2JtTemplate;
import com.jeramtough.jtcodegenerator.generator.template.jt.js.JsHttpConstantsJtTemplate;

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
    protected TemplateParamsInitializer initTemplateParamsInitializer() {
        return new JtTemplateParamsInitializer();
    }
    @Override
    protected void initTemplates(
            List<JtTemplate> jtTemplateList) {
        jtTemplateList.add(new JsApiJtTemplate(super.generatorConfigAdapter));
        jtTemplateList.add(new JsApiHandlerJtTemplate(super.generatorConfigAdapter));
        jtTemplateList.add(new JsHttpClientV2JtTemplate(super.generatorConfigAdapter));
        jtTemplateList.add(new JsHttpConstantsJtTemplate(super.generatorConfigAdapter));
    }

}
