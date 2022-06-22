package com.jeramtough.jtcodegenerator.generator.custom;

import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.code.GeneratorTag;
import com.jeramtough.jtcodegenerator.generator.template.JtTemplate;
import com.jeramtough.jtcodegenerator.generator.template.java.*;

import java.util.List;

/**
 * <pre>
 * Created on 2021/12/29 下午4:18
 * by @author WeiBoWen
 * </pre>
 */
public class JavaCustomCodeGenerator extends BaseCustomCodeGenerator {


    public JavaCustomCodeGenerator(
            GeneratorTag tag,
            GeneratorConfigAdapter generatorConfigAdapter) {
        super(tag, generatorConfigAdapter);
    }

    @Override
    protected void initTemplates(
            List<JtTemplate> jtTemplateList) {
        this.jtTemplateList.add(new DtoJtTemplate());
        this.jtTemplateList.add(new BasicControllerJtTemplate());
        this.jtTemplateList.add(new AddOrUpdateParamsJtTemplate());
        this.jtTemplateList.add(new CoditionParamsJtTemplate());
        this.jtTemplateList.add(new BasicServiceJtTemplate());
        this.jtTemplateList.add(new BasicServiceImplJtTemplate());
    }

}
