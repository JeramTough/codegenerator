package com.jeramtough.jtcodegenerator.generator.code;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtlog.with.WithLogger;

/**
 * <pre>
 * Created on 2021/12/29 上午11:35
 * by @author WeiBoWen
 * </pre>
 */
public class RxscJavaCodeGenerator extends BaseCodeGenerator implements CodeGenerator, WithLogger {

    public RxscJavaCodeGenerator(
            GeneratorConfigAdapter generatorConfigAdapter) {
        super(generatorConfigAdapter);
    }

    @Override
    protected GeneratorTag initTag() {
        return GeneratorTag.JAVA;
    }


    @Override
    protected void initFastAutoGenerator(FastAutoGenerator fastAutoGenerator) {

        //全局设置
        fastAutoGenerator.globalConfig(builder -> {
            builder.fileOverride()
                   .outputDir(pathHandler.getJavaOutputPath())
                   .author(generatorConfigAdapter.getAuthor())
                   .enableSwagger()
                   .dateType(DateType.TIME_PACK)
                   .commentDate("yyyy-MM-dd HH:mm:ss");
        });

        //包名设置
        fastAutoGenerator.packageConfig(builder -> {
            builder.parent(generatorConfigAdapter.getBasePackageName())
                   .entity("model.entity")
                   .service("service")
                   .serviceImpl("service.impl")
                   .mapper("mapper")
                   .controller("action.controller")
                   .other("model.dto");
        });

        //模板设置
        fastAutoGenerator.templateConfig(builder -> {
            builder
                    .entity("/templates/JAVA/rxsc/Entity.java")
                    .service("/templates/JAVA/rxsc/Service.java")
                    .serviceImpl("/templates/JAVA/rxsc/ServiceImpl.java")
                    .mapper("/templates/JAVA/rxsc/Mapper.java")
                    .mapperXml("/templates/JAVA/rxsc/mapper.xml")
                    .controller("/templates/JAVA/rxsc/Controller.java");
        });

        //设置策略
        fastAutoGenerator.strategyConfig(builder -> {
            builder.serviceBuilder()
                   .formatServiceFileName("%sService")
                   .formatServiceImplFileName("%sServiceImpl");

            if (generatorConfigAdapter.isSkipView()) {
                builder.enableSkipView();
            }

            builder.controllerBuilder()
                   .enableRestStyle();
        });
    }

}
