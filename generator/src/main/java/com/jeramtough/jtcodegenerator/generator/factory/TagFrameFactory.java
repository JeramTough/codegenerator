package com.jeramtough.jtcodegenerator.generator.factory;

import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.code.GeneratorTag;
import com.jeramtough.jtcodegenerator.generator.custom.CustomCodeGenerator;
import com.jeramtough.jtcodegenerator.generator.custom.CzJavaCustomCodeGenerator;
import com.jeramtough.jtcodegenerator.generator.custom.JavaCustomCodeGenerator;
import com.jeramtough.jtcodegenerator.generator.custom.JsCustomCodeGenerator;
import com.jeramtough.jtcodegenerator.generator.params.TemplateParamsInitializer;
import com.jeramtough.jtcodegenerator.generator.params.cz.CzTemplateParamsInitializer;
import com.jeramtough.jtcodegenerator.generator.params.jt.JtTemplateParamsInitializer;

/**
 * <pre>
 * Created on 2022/7/7 下午5:28
 * by @author WeiBoWen
 * </pre>
 */
public class TagFrameFactory {

    public static TemplateParamsInitializer getTemplateParamsInitializer(GeneratorTag tag) {
        return switch (tag) {
            case JAVA, JS -> new JtTemplateParamsInitializer();
            case CZ_JAVA -> new CzTemplateParamsInitializer();
        };
    }

    /**
     * 决定了使用哪个JtCustomCodeGenerator的生成器
     */
    public static CustomCodeGenerator getCustomCodeGenerator(
            GeneratorTag tag, GeneratorConfigAdapter generatorConfigAdapter,
            TemplateParamsInitializer templateParamsInitializer) {
        return switch (tag) {
            case JAVA -> new JavaCustomCodeGenerator(tag, generatorConfigAdapter,
                    templateParamsInitializer);
            case CZ_JAVA -> new CzJavaCustomCodeGenerator(tag, generatorConfigAdapter,
                    templateParamsInitializer);
            case JS -> new JsCustomCodeGenerator(tag, generatorConfigAdapter,
                    templateParamsInitializer);
        };
    }
}
