package com.jeramtough.jtcodegenerator.generator.params.jt;

import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.bean.EachTableInfo;
import com.jeramtough.jtcodegenerator.generator.params.BaseTemplateParamsInitializer;
import com.jeramtough.jtcodegenerator.generator.template.JtTemplate;

import java.util.Map;

/**
 * <pre>
 * Created on 2022/7/4 下午5:14
 * by @author WeiBoWen
 * </pre>
 */
public class JtTemplateParamsInitializer extends BaseTemplateParamsInitializer {

    @Override
    public void setParamsForEachTable(JtTemplate jtTemplate,
                                      GeneratorConfigAdapter generatorConfigAdapter,
                                      EachTableInfo eachTableInfo) {
        super.setParamsForEachTable(jtTemplate,generatorConfigAdapter, eachTableInfo);

        TableInfo tableInfo = eachTableInfo.getTableInfo();
        Map<String, Object> objectMap = eachTableInfo.getObjectMap();
        ConfigBuilder config = (ConfigBuilder) objectMap.get("config");
        PackageConfig packageConfig = config.getPackageConfig();

        String lowerEntityName = (String) objectMap.get("lowerEntityName");

        String dtoPackage =
                generatorConfigAdapter.getBasePackageName() + ".model.dto";
        objectMap.put("dtoPackage", dtoPackage);

        String paramsPackage = generatorConfigAdapter.getBasePackageName() + ".model.params." + lowerEntityName;
        objectMap.put("paramsPackage", paramsPackage);

        String baseServicePackage =
                generatorConfigAdapter.getBasePackageName() + "." + packageConfig.getService() +
                        ".base";
        objectMap.put("baseServicePackage", baseServicePackage);

        String baseServiceImplPackage =
                generatorConfigAdapter.getBasePackageName() + "." + packageConfig.getService() +
                        ".base.impl";
        objectMap.put("baseServiceImplPackage", baseServiceImplPackage);

    }
}
