package com.jeramtough.jtcodegenerator.generator.code;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.custom.CustomCodeGenerator;
import com.jeramtough.jtcodegenerator.generator.custom.JsCustomCodeGenerator;
import com.jeramtough.jtcodegenerator.generator.params.TemplateParamsInitializer;
import com.jeramtough.jtcodegenerator.generator.params.jt.JtTemplateParamsInitializer;
import com.jeramtough.jtlog.with.WithLogger;

import java.util.function.Consumer;

/**
 * <pre>
 * Created on 2021/12/29 上午11:35
 * by @author WeiBoWen
 * </pre>
 */
public class JsCodeGenerator extends BaseCodeGenerator implements CodeGenerator, WithLogger {


    public JsCodeGenerator(
            GeneratorConfigAdapter generatorConfigAdapter) {
        super(generatorConfigAdapter);
    }

    @Override
    protected GeneratorTag initTag() {
        return GeneratorTag.JS;
    }


    @Override
    protected void initFastAutoGenerator(FastAutoGenerator fastAutoGenerator) {

        //模板设置,全部不生成
        fastAutoGenerator.templateConfig(
                (Consumer<TemplateConfig.Builder>) TemplateConfig.Builder::disable);


    }
}
