package com.jeramtough.jtcodegenerator.generator.custom;

import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.bean.EachTableInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <pre>
 * Created on 2021/12/30 上午10:05
 * by @author WeiBoWen
 * </pre>
 */
public class CustomParams {

    public static void set(GeneratorConfigAdapter generatorConfigAdapter,
                           EachTableInfo eachTableInfo) {
        TableInfo tableInfo = eachTableInfo.getTableInfo();
        Map<String, Object> objectMap = eachTableInfo.getObjectMap();
        ConfigBuilder config = (ConfigBuilder) objectMap.get("config");
        PackageConfig packageConfig = config.getPackageConfig();

        String projectName = generatorConfigAdapter.getProjectName();
        objectMap.put("projectName", projectName);

        String lowerEntityName = tableInfo.getEntityName().toLowerCase();
        objectMap.put("lowerEntityName", lowerEntityName);

        String firstLowerEntityName = tableInfo.getEntityName();
        String firstChar = firstLowerEntityName.charAt(0) + "";
        firstChar = firstChar.toLowerCase();
        firstLowerEntityName = firstLowerEntityName.substring(1);
        firstLowerEntityName = firstChar + firstLowerEntityName;
        objectMap.put("firstLowerEntityName", firstLowerEntityName);

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

    public static void setAll(List<EachTableInfo> eachTableInfoList) {
        List<Map<String, String>> eachTableNames = new ArrayList<>();

        for (EachTableInfo eachTableInfo : eachTableInfoList) {
            Map<String, String> each = new HashMap<>(2);
            String firstLowerEntityName = (String) eachTableInfo.getObjectMap().get(
                    "firstLowerEntityName");
            each.put("firstLowerEntityName", firstLowerEntityName);
            each.put("entityName", eachTableInfo.getTableInfo().getEntityName());
            eachTableNames.add(each);
        }

        eachTableInfoList
                .parallelStream()
                .map(EachTableInfo::getObjectMap)
                .forEach(stringObjectMap -> stringObjectMap
                        .put("eachTableNames",
                                eachTableNames));

    }
}
