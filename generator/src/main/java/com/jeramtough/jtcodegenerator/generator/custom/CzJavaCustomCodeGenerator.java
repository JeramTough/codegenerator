package com.jeramtough.jtcodegenerator.generator.custom;

import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.code.GeneratorTag;
import com.jeramtough.jtcodegenerator.generator.params.TemplateParamsInitializer;
import com.jeramtough.jtcodegenerator.generator.params.cz.CzTemplateParamsInitializer;
import com.jeramtough.jtcodegenerator.generator.template.JtTemplate;
import com.jeramtough.jtcodegenerator.generator.template.cz.java.*;

import java.util.List;

/**
 * <pre>
 * Created on 2021/12/29 下午4:18
 * by @author 北京瑞曦wjx
 * </pre>
 */
public class CzJavaCustomCodeGenerator extends BaseCustomCodeGenerator {


    public CzJavaCustomCodeGenerator(
            GeneratorTag tag,
            GeneratorConfigAdapter generatorConfigAdapter,
            TemplateParamsInitializer templateParamsInitializer) {
        super(tag, generatorConfigAdapter,templateParamsInitializer);
    }

    @Override
    protected void initTemplates(
            List<JtTemplate> jtTemplateList) {
        this.jtTemplateList.add(new CzBoJtTemplate(super.generatorConfigAdapter));
        this.jtTemplateList.add(new CzVoJtTemplate(super.generatorConfigAdapter));
        this.jtTemplateList.add(new CzAddOrUpFormJtTemplate(super.generatorConfigAdapter));
        this.jtTemplateList.add(new CzFragmentNotificationJtTemplate(super.generatorConfigAdapter));
        this.jtTemplateList.add(new CzAnalysePoJtTemplate(super.generatorConfigAdapter));
        this.jtTemplateList.add(new CzAnalyseMapperJtTemplate(super.generatorConfigAdapter));
        this.jtTemplateList.add(new CzDataCleaningRealestateServiceJtTemplate(super.generatorConfigAdapter));
        this.jtTemplateList.add(new CzAnalyseVoJtTemplate(super.generatorConfigAdapter));
    }

}
