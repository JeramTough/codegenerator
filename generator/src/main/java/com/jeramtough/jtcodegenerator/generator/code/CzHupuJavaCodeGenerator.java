package com.jeramtough.jtcodegenerator.generator.code;

import cn.hutool.core.io.IoUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.custom.CustomCodeGenerator;
import com.jeramtough.jtcodegenerator.generator.custom.CzJavaCustomCodeGenerator;
import com.jeramtough.jtcodegenerator.generator.params.TemplateParamsInitializer;
import com.jeramtough.jtcodegenerator.generator.params.cz.CzTemplateParamsInitializer;
import com.jeramtough.jtcodegenerator.generator.typeconvert.CzPostgreSqlTypeConvert;
import com.jeramtough.jtcomponent.utils.StringUtil;
import com.jeramtough.jtlog.with.WithLogger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Created on 2021/12/29 上午11:35
 * by @author WeiBoWen
 * </pre>
 */
public class CzHupuJavaCodeGenerator extends BaseCodeGenerator
        implements CodeGenerator, WithLogger {

    public CzHupuJavaCodeGenerator(
            GeneratorConfigAdapter generatorConfigAdapter) {
        super(generatorConfigAdapter);
    }

    @Override
    protected GeneratorTag initTag() {
        return GeneratorTag.CZ_HEPU_JAVA;
    }


    @Override
    protected void initDataSourceConfig(DataSourceConfig.Builder builder) {
        //类型转换器
        builder.typeConvert(new CzPostgreSqlTypeConvert());
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

            String businessPrefix = (StringUtil.isEmpty(
                    super.generatorConfigAdapter.getBusinessPrefix()) ? "" :
                    "." + super.generatorConfigAdapter.getBusinessPrefix());
            builder.parent(generatorConfigAdapter.getBasePackageName())
                   .entity("datasource.po.datachip" + businessPrefix)
                   .service("web.service.datachip" + businessPrefix)
                   .serviceImpl("web.service.datachip" + businessPrefix + ".impl")
                   .mapper("datasource.mapper.datachip" + businessPrefix)
                   .controller("web.controller" + businessPrefix)
                   .other("model.dto");
        });

        //模板设置
        fastAutoGenerator.templateConfig(builder -> {
            builder
                    .entity("/templates/JAVA/cz/HePuPO.java")
                    .service("/templates/JAVA/cz/Service.java")
                    .serviceImpl("/templates/JAVA/cz/ServiceImpl.java")
                    .mapper("/templates/JAVA/cz/Mapper.java")
                    .mapperXml("/templates/JAVA/jt/mapper.xml")
                    .controller("/templates/JAVA/cz/Controller.java");
        });


        //设置策略
        fastAutoGenerator.strategyConfig(builder -> {
            builder.controllerBuilder()
                           .formatFileName("Hepu%sController");

            builder.serviceBuilder()
                   .formatServiceFileName("Hepu%sService")
                   .formatServiceImplFileName("Hepu%sServiceImpl");
            builder.mapperBuilder()
                           .formatMapperFileName("Hepu%sMapper");

            builder.entityBuilder()
                   .formatFileName("Hepu%sPO")
                   .addIgnoreColumns("id","lot_no" , "fingerprint_key" , "active_at" ,
                           "import_year"
                           , "import_month" , "created_by" , "updated_by" , "deleted_by" ,
                           "created_at" ,
                           "updated_at" , "deleted_at");

            //只生成这些表
           /* List<String> tableList=new ArrayList<>();
            try {
                JSONObject jsonObject=JSON.parseObject(IoUtil.read(new FileInputStream(
                        "/home/jeramtough/桌面/hepu/masterplate_basic.json"),
                        StandardCharsets.UTF_8));
                JSONArray jsonArray=jsonObject.getJSONArray("RECORDS");
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject each=jsonArray.getJSONObject(i);
                    String table=each.getString("data_object");
                    tableList.add(table);
                }
            }
            catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            builder.addInclude(tableList);*/

            if (generatorConfigAdapter.isSkipView()) {
                builder.enableSkipView();
            }

            builder.controllerBuilder()
                   .enableRestStyle();
        });
    }

}
