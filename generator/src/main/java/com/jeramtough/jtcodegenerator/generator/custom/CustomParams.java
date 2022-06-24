package com.jeramtough.jtcodegenerator.generator.custom;

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

        String basePackName = generatorConfigAdapter.getBasePackageName();
        objectMap.put("basePackName", basePackName);

        String tableModelName = StringUtil.lineToHump(eachTableInfo.getTableInfo().getName(),
                true);
        objectMap.put("tableModelName", tableModelName);

        String lowerEntityName = tableInfo.getEntityName().toLowerCase();
        objectMap.put("lowerEntityName", lowerEntityName);

        String firstLowerEntityName = tableInfo.getEntityName();
        String firstChar = firstLowerEntityName.charAt(0) + "";
        firstChar = firstChar.toLowerCase();
        firstLowerEntityName = firstLowerEntityName.substring(1);
        firstLowerEntityName = firstChar + firstLowerEntityName;
        objectMap.put("firstLowerEntityName", firstLowerEntityName);

        //cz的属性
        String voPackage =
                generatorConfigAdapter.getBasePackageName() + ".api.model.datachip" +
                        ".realestate" +
                        ".vo";
        objectMap.put("voPackage", voPackage);
        String boPackage =
                generatorConfigAdapter.getBasePackageName() + ".api.model.datachip" +
                        ".realestate.bo";
        objectMap.put("boPackage", boPackage);

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

        //只有创展才要这样干
        for (TableField tableField : eachTableInfo.getTableInfo().getFields()) {
            if ("id".equals(tableField.getName())){
                try {
                    Field field=tableField.getClass().getDeclaredField("keyIdentityFlag");
                    field.setAccessible(true);
                    field.set(tableField,true);
                }
                catch (IllegalAccessException | NoSuchFieldException e) {
                    throw new RuntimeException(e);
                }
            }
        }
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


    public static void setJtTemplateParams(JtTemplate jtTemplate,
                                           EachTableInfo eachTableInfo) {

        String templatePackageName=
                jtTemplate.getPackageName(eachTableInfo);
        String basePackName = (String) eachTableInfo.getObjectMap().get("basePackName");
        String customModulePackageName = basePackName + "." + templatePackageName;
        eachTableInfo.getObjectMap().put("customModulePackageName", customModulePackageName);
    }
}
