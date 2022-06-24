package com.jeramtough.jtcodegenerator.generator.code;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.custom.CustomCodeGenerator;
import com.jeramtough.jtcodegenerator.generator.custom.JsCustomCodeGenerator;
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
    protected CustomCodeGenerator initCustomCodeGenerator(
            GeneratorTag tag, GeneratorConfigAdapter generatorConfigAdapter) {
        return new JsCustomCodeGenerator(tag, generatorConfigAdapter);
    }


    @Override
    protected void initFastAutoGenerator(FastAutoGenerator fastAutoGenerator) {

        //模板设置
        fastAutoGenerator.templateConfig(
                (Consumer<TemplateConfig.Builder>) TemplateConfig.Builder::disable);

        //自定义内容
        fastAutoGenerator.injectionConfig(builder -> builder.beforeOutputFile(
                (tableInfo, objectMap) -> super.customCodeGenerator.addTable(tableInfo,
                        objectMap)));

    }
}
