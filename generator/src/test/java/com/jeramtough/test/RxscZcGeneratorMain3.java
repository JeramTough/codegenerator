package com.jeramtough.test;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.bean.EachTableInfo;
import com.jeramtough.jtcodegenerator.generator.code.RxscJavaCodeGenerator;
import com.jeramtough.jtcodegenerator.generator.datasource.DatabasePool;
import com.jeramtough.jtcodegenerator.generator.factory.TagFrameFactory;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * Created on 2021/12/29 下午2:55
 * by @author 北京瑞曦wjx
 * </pre>
 */
public class RxscZcGeneratorMain3 {

    public static void main(String[] args) {

        //设置数据库数据源
        DataSource dataSource = DatabasePool.getDataSource(
                "jdbc:mysql://47.108.158.81:3306/irw_system_dev?" +
                        "characterEncoding=UTF-8&useUnicode=true&useSSL=false&tinyInt1isBit=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Shanghai",
                "irw_system",
                "X^7N81AEWDz_3^93kz",
                "com.mysql.jdbc.Driver");

        DataSourceConfig.Builder dataSourceConfigBuilder =
                new DataSourceConfig.Builder(dataSource);

        //MyBatisPlus的代码生成器
        FastAutoGenerator fastAutoGenerator = FastAutoGenerator.create(
                dataSourceConfigBuilder);


        //全局设置
        fastAutoGenerator.globalConfig(builder -> {
            builder.fileOverride()
                   .outputDir("/tmp/test/")
                   .author("WeiBoWen")
                   .enableSwagger()
                   .dateType(DateType.TIME_PACK)
                   .commentDate("yyyy-MM-dd HH:mm:ss");
        });

        //包名设置
        fastAutoGenerator.packageConfig(builder -> {
            builder.parent("com.xxxx.xxxx.xxxx")
                   .entity("model.entity")
                   .service("service")
                   .serviceImpl("service.impl")
                   .mapper("mapper")
                   .controller("action.controller");
        });

        //模板设置
        fastAutoGenerator.templateConfig(builder -> {
            builder
                    .entity("/templates/JAVA/rxsc/Entity.java")
                    .service("/templates/JAVA/rxsc/Service.java")
                    .serviceImpl("/templates/JAVA/rxsc/ServiceImpl.java")
                    .mapper("/templates/JAVA/rxsc/Mapper.java")
                    .controller("/templates/JAVA/rxsc/Controller.java");
        });

        //设置策略
        fastAutoGenerator.strategyConfig(builder -> {
            builder.serviceBuilder()
                   .formatServiceFileName("%sService")
                   .formatServiceImplFileName("%sServiceImpl");

            builder.enableSkipView();

            builder.controllerBuilder()
                   .enableRestStyle();
        });

        fastAutoGenerator.execute();

    }
}
