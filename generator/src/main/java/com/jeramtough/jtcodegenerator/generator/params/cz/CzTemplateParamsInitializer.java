package com.jeramtough.jtcodegenerator.generator.params.cz;

import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.bean.EachTableInfo;
import com.jeramtough.jtcodegenerator.generator.params.BaseTemplateParamsInitializer;
import com.jeramtough.jtcodegenerator.generator.template.JtTemplate;
import com.jeramtough.jtcomponent.utils.StringUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * <pre>
 * Created on 2022/7/4 下午5:14
 * by @author 北京瑞曦wjx
 * </pre>
 */
public class CzTemplateParamsInitializer extends BaseTemplateParamsInitializer {

    @Override
    public void setParamsForEachTable(JtTemplate jtTemplate,
                                      GeneratorConfigAdapter generatorConfigAdapter,
                                      EachTableInfo eachTableInfo) {
        super.setParamsForEachTable(jtTemplate, generatorConfigAdapter, eachTableInfo);

        TableInfo tableInfo = eachTableInfo.getTableInfo();
        Map<String, Object> objectMap = eachTableInfo.getObjectMap();
        ConfigBuilder config = (ConfigBuilder) objectMap.get("config");
        PackageConfig packageConfig = config.getPackageConfig();

        //cz的属性
        String businessPrefixPackageName = (StringUtil.isEmpty(
                generatorConfigAdapter.getBusinessPrefix()) ? "" :
                "." + generatorConfigAdapter.getBusinessPrefix());
        String voPackage =
                generatorConfigAdapter.getBasePackageName() + ".api.model.datachip" +
                        ".drischool"+
                        businessPrefixPackageName +
                        ".vo";
        objectMap.put("voPackage", voPackage);
        String boPackage =
                generatorConfigAdapter.getBasePackageName() + ".api.model.datachip" +
                        ".drischool"+
                        businessPrefixPackageName +
                        ".bo";
        objectMap.put("boPackage", boPackage);
        String requestPackage =
                generatorConfigAdapter.getBasePackageName() + ".api.model.datachip" +
                        ".drischool"+
                        businessPrefixPackageName +
                        ".request";
        objectMap.put("requestPackage", requestPackage);

        //只有创展才要这样干
        for (TableField tableField : eachTableInfo.getTableInfo().getFields()) {
            if ("id".equals(tableField.getName())) {
                try {
                    Field field = tableField.getClass().getDeclaredField("keyIdentityFlag");
                    field.setAccessible(true);
                    field.set(tableField, true);
                }
                catch (IllegalAccessException | NoSuchFieldException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
