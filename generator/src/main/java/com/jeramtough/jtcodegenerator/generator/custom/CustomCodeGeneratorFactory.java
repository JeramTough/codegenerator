package com.jeramtough.jtcodegenerator.generator.custom;

import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.code.GeneratorTag;

/**
 * <pre>
 * Created on 2021/12/30 下午5:56
 * by @author WeiBoWen
 * </pre>
 */
public class CustomCodeGeneratorFactory {

    private CustomCodeGeneratorFactory() {
    }

    public static CustomCodeGenerator getCustomCodeGenerator(GeneratorTag tag,
                                                             GeneratorConfigAdapter generatorConfigAdapter) {
        return switch (tag) {
            case JAVA -> new JavaCustomCodeGenerator(tag, generatorConfigAdapter);
            case JS -> new JsCustomCodeGenerator(tag, generatorConfigAdapter);
        };
    }

}
