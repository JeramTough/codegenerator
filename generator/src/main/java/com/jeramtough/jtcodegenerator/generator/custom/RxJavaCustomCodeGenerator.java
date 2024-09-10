package com.jeramtough.jtcodegenerator.generator.custom;

import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.code.GeneratorTag;
import com.jeramtough.jtcodegenerator.generator.params.TemplateParamsInitializer;
import com.jeramtough.jtcodegenerator.generator.template.JtTemplate;
import com.jeramtough.jtcodegenerator.generator.template.rx.java.*;

import java.util.List;

/**
 * <pre>
 * Created on 2021/12/29 下午4:18
 * by @author 北京瑞曦wjx
 * </pre>
 */
public class RxJavaCustomCodeGenerator extends BaseCustomCodeGenerator {


    public RxJavaCustomCodeGenerator(GeneratorTag tag,
                                     GeneratorConfigAdapter generatorConfigAdapter,
                                     TemplateParamsInitializer templateParamsInitializer) {
        super(tag, generatorConfigAdapter, templateParamsInitializer);
    }

    @Override
    protected void initTemplates(List<JtTemplate> jtTemplateList) {
        this.jtTemplateList.add(new DtoRxTemplate(super.generatorConfigAdapter));
        this.jtTemplateList.add(new BasicControllerRxTemplate(super.generatorConfigAdapter));
        this.jtTemplateList.add(new AddOrUpdateParamsRxTemplate(super.generatorConfigAdapter));
        this.jtTemplateList.add(new CoditionParamsRxTemplate(super.generatorConfigAdapter));
        this.jtTemplateList.add(new BasicServiceRxTemplate(super.generatorConfigAdapter));
        this.jtTemplateList.add(new BasicServiceImplRxTemplate(super.generatorConfigAdapter));
    }

}
