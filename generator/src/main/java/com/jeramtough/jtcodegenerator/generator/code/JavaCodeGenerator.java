package com.jeramtough.jtcodegenerator.generator.code;

import cn.hutool.core.io.FileUtil;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.jeramtough.jtcodegenerator.generator.custom.JavaCustomCodeGenerator;
import com.jeramtough.jtcodegenerator.generator.path.PathHandler;
import com.jeramtough.jtcodegenerator.generator.util.MyIoUtil;
import com.jeramtough.jtcomponent.io.Directory;
import com.jeramtough.jtlog.with.WithLogger;

import javax.sql.DataSource;

/**
 * <pre>
 * Created on 2021/12/29 上午11:35
 * by @author WeiBoWen
 * </pre>
 */
public class JavaCodeGenerator extends BaseCodeGenerator implements CodeGenerator, WithLogger {

    public JavaCodeGenerator(
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
                    .entity("/templates/JAVA/jt/Entity.java")
                    .service("/templates/JAVA/jt/Service.java")
                    .serviceImpl("/templates/JAVA/jt/ServiceImpl.java")
                    .mapper("/templates/JAVA/jt/Mapper.java")
                    .mapperXml("/templates/JAVA/jt/mapper.xml")
                    .controller("/templates/JAVA/jt/Controller.java");
        });

        //自定义内容
        fastAutoGenerator.injectionConfig(builder -> {
            builder.beforeOutputFile((tableInfo, objectMap) -> {
                getLogger().verbose("正在生成" + tableInfo.getEntityName() + "...");
                super.customCodeGenerator.addTable(tableInfo, objectMap);
            });
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
