package com.jeramtough.jtcodegenerator.generator.code;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.custom.CustomCodeGenerator;
import com.jeramtough.jtcodegenerator.generator.custom.CzJavaCustomCodeGenerator;
import com.jeramtough.jtcodegenerator.generator.typeconvert.CzPostgreSqlTypeConvert;
import com.jeramtough.jtcomponent.utils.StringUtil;
import com.jeramtough.jtlog.with.WithLogger;

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
        return GeneratorTag.CZ_JAVA;
    }

    @Override
    protected void initDataSourceConfig(DataSourceConfig.Builder builder) {
        //类型转换器
        builder.typeConvert(new CzPostgreSqlTypeConvert());
    }

    @Override
    protected CustomCodeGenerator initCustomCodeGenerator(
            GeneratorTag tag, GeneratorConfigAdapter generatorConfigAdapter) {
        return new CzJavaCustomCodeGenerator(tag, generatorConfigAdapter);
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
                   .controller("action.controller" + businessPrefix)
                   .other("model.dto");
        });

        //模板设置
        fastAutoGenerator.templateConfig(builder -> {
            builder
                    .entity("/templates/JAVA/cz/PO.java")
                    .service("/templates/JAVA/cz/Service.java")
                    .serviceImpl("/templates/JAVA/cz/ServiceImpl.java")
                    .mapper("/templates/JAVA/cz/Mapper.java")
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
          /*  builder.addInclude("real_estate_material_price"
                    , "real_estate_register_info_2"
                    , "real_estate_material"
                    , "real_material_completed"
                    , "real_estate_material_programme_batch"
                    , "real_estate_material_programme_batch_file"
                    , "real_estate_transfer_payment");*/

            if (generatorConfigAdapter.isSkipView()) {
                builder.enableSkipView();
            }

            builder.controllerBuilder()
                   .enableRestStyle();
        });
    }

}
