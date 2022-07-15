package com.jeramtough.jtcodegenerator.generator.params;

import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.bean.EachTableInfo;
import com.jeramtough.jtcodegenerator.generator.template.JtTemplate;
import com.jeramtough.jtcomponent.utils.StringUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * Created on 2022/7/4 下午5:12
 * by @author WeiBoWen
 * </pre>
 */
public class BaseTemplateParamsInitializer implements TemplateParamsInitializer {

    @Override
    public void setParamsForEachTable(JtTemplate jtTemplate,
                                      GeneratorConfigAdapter generatorConfigAdapter,
                                      EachTableInfo eachTableInfo) {
        TableInfo tableInfo = eachTableInfo.getTableInfo();
        Map<String, Object> objectMap = eachTableInfo.getObjectMap();
        ConfigBuilder config = (ConfigBuilder) objectMap.get("config");
        PackageConfig packageConfig = config.getPackageConfig();

        String templatePackageName = jtTemplate==null?"":
                jtTemplate.getPackageName(eachTableInfo);
        String basePackName = generatorConfigAdapter.getBasePackageName();

        String customModulePackageName = basePackName + "." + templatePackageName;
        eachTableInfo.getObjectMap().put("customModulePackageName" , customModulePackageName);

        String projectName = generatorConfigAdapter.getProjectName();
        objectMap.put("projectName" , projectName);


        objectMap.put("basePackName" , basePackName);

        String businessPrefix = (StringUtil.isEmpty(
                generatorConfigAdapter.getBusinessPrefix()) ? "" :
                generatorConfigAdapter.getBusinessPrefix());

        String firstUpperBusinessPrefix;
        String firstLowerBusinessPrefix;
        if (businessPrefix.length() > 0) {
            String firstChar = businessPrefix.charAt(0) + "";
            String firstUpperChar = firstChar.toUpperCase();
            String firstLowerChar = firstChar.toLowerCase();
            firstUpperBusinessPrefix = firstUpperChar + businessPrefix.substring(1);
            firstLowerBusinessPrefix = firstLowerChar + businessPrefix.substring(1);
        }
        else {
            firstUpperBusinessPrefix = businessPrefix;
            firstLowerBusinessPrefix = businessPrefix;
        }


        String tableModelName = StringUtil.lineToHump(eachTableInfo.getTableInfo().getName(),
                true);
        String firstUpperTableModelName = firstUpperBusinessPrefix + tableModelName;
        String firstLowerTableModelName = firstLowerBusinessPrefix + tableModelName;
        objectMap.put("tableModelName" , firstUpperTableModelName);


        if (businessPrefix.length() == 0) {
            String firstChar = firstUpperTableModelName.charAt(0) + "";
            firstLowerTableModelName =
                    firstChar.toLowerCase()+firstLowerTableModelName.substring(1);
            objectMap.put("firstLowerTableModelName" , firstLowerTableModelName);
        }
        else {
            objectMap.put("firstLowerTableModelName" , firstLowerTableModelName);
        }

        String lowerEntityName = tableInfo.getEntityName().toLowerCase();
        objectMap.put("lowerEntityName" , lowerEntityName);

        String firstLowerEntityName = tableInfo.getEntityName();
        String firstChar = firstLowerEntityName.charAt(0) + "";
        firstChar = firstChar.toLowerCase();
        firstLowerEntityName = firstLowerEntityName.substring(1);
        firstLowerEntityName = firstChar + firstLowerEntityName;
        objectMap.put("firstLowerEntityName" , firstLowerEntityName);


        String dtoPackage =
                generatorConfigAdapter.getBasePackageName() + ".model.dto";
        objectMap.put("dtoPackage" , dtoPackage);

        String paramsPackage = generatorConfigAdapter.getBasePackageName() + ".model.params." + lowerEntityName;
        objectMap.put("paramsPackage" , paramsPackage);

        String baseServicePackage =
                generatorConfigAdapter.getBasePackageName() + "." + packageConfig.getService() +
                        ".base";
        objectMap.put("baseServicePackage" , baseServicePackage);

        String baseServiceImplPackage =
                generatorConfigAdapter.getBasePackageName() + "." + packageConfig.getService() +
                        ".base.impl";
        objectMap.put("baseServiceImplPackage" , baseServiceImplPackage);

    }

    @Override
    public void setParamsForAllTable(List<EachTableInfo> eachTableInfoList) {
        List<Map<String, String>> eachTableNames = new ArrayList<>();

        for (EachTableInfo eachTableInfo : eachTableInfoList) {
            Map<String, String> each = new HashMap<>(2);
            String firstLowerEntityName = (String) eachTableInfo.getObjectMap().get(
                    "firstLowerEntityName");
            each.put("firstLowerEntityName" , firstLowerEntityName);
            each.put("entityName" , eachTableInfo.getTableInfo().getEntityName());
            eachTableNames.add(each);
        }

        eachTableInfoList
                .parallelStream()
                .map(EachTableInfo::getObjectMap)
                .forEach(stringObjectMap -> stringObjectMap
                        .put("eachTableNames" ,
                                eachTableNames));
    }
}
