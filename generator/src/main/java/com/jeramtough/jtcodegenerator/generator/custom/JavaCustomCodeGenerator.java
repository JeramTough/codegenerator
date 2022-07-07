package com.jeramtough.jtcodegenerator.generator.custom;

import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.code.GeneratorTag;
import com.jeramtough.jtcodegenerator.generator.params.TemplateParamsInitializer;
import com.jeramtough.jtcodegenerator.generator.params.jt.JtTemplateParamsInitializer;
import com.jeramtough.jtcodegenerator.generator.template.JtTemplate;
import com.jeramtough.jtcodegenerator.generator.template.jt.java.*;

import java.util.List;

/**
 * <pre>
 * Created on 2021/12/29 下午4:18
 * by @author WeiBoWen
 * </pre>
 */
public class JavaCustomCodeGenerator extends BaseCustomCodeGenerator {


    public JavaCustomCodeGenerator(GeneratorTag tag,
                                   GeneratorConfigAdapter generatorConfigAdapter,
                                   TemplateParamsInitializer templateParamsInitializer) {
        super(tag, generatorConfigAdapter,templateParamsInitializer);
    }

    @Override
    protected void initTemplates(List<JtTemplate> jtTemplateList) {
        this.jtTemplateList.add(new DtoJtTemplate(super.generatorConfigAdapter));
        this.jtTemplateList.add(new BasicControllerJtTemplate(super.generatorConfigAdapter));
        this.jtTemplateList.add(new AddOrUpdateParamsJtTemplate(super.generatorConfigAdapter));
        this.jtTemplateList.add(new CoditionParamsJtTemplate(super.generatorConfigAdapter));
        this.jtTemplateList.add(new BasicServiceJtTemplate(super.generatorConfigAdapter));
        this.jtTemplateList.add(new BasicServiceImplJtTemplate(super.generatorConfigAdapter));
    }

}
