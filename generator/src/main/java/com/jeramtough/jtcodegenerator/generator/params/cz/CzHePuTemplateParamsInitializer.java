package com.jeramtough.jtcodegenerator.generator.params.cz;

import cn.hutool.core.io.IoUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.bean.EachTableInfo;
import com.jeramtough.jtcodegenerator.generator.params.BaseTemplateParamsInitializer;
import com.jeramtough.jtcodegenerator.generator.template.JtTemplate;
import com.jeramtough.jtcomponent.utils.StringUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <pre>
 * Created on 2022/7/4 下午5:14
 * by @author 北京瑞曦wjx
 * </pre>
 */
public class CzHePuTemplateParamsInitializer extends BaseTemplateParamsInitializer {

    private static Map<String, List<JSONObject>> tableNameKeyParamsMap = new HashMap<>(200);
    private static Map<String, JSONObject> tableNameKeyTemplateInfoMap = new HashMap<>(200);
    private static Map<String, String> tableNameWithTemplateIdMap = new HashMap<>();
    private static Map<String, String> templateIdWithTableNameMap = new HashMap<>();

    static {
        initTemplateInfoMap();
        initTemplateParamsMap();
    }

    //

    private static void initTemplateInfoMap() {
        try {
            com.alibaba.fastjson2.JSONObject jsonObject = JSON.parseObject(
                    IoUtil.read(new FileInputStream(
                                    "/home/jeramtough/桌面/hepu/masterplate_basic.json"),
                            StandardCharsets.UTF_8));
            JSONArray jsonArray = jsonObject.getJSONArray("RECORDS");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject each = jsonArray.getJSONObject(i);
                String templateId = each.getString("id");
                String tableName = each.getString("data_object");

                tableNameWithTemplateIdMap.put(tableName, templateId);
                templateIdWithTableNameMap.put(templateId, tableName);
                tableNameKeyTemplateInfoMap.put(tableName, each);
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void initTemplateParamsMap() {
        try {
            com.alibaba.fastjson2.JSONObject jsonObject = JSON.parseObject(
                    IoUtil.read(new FileInputStream(
                                    "/home/jeramtough/桌面/hepu/masterplate_attribute.json"),
                            StandardCharsets.UTF_8));
            JSONArray jsonArray = jsonObject.getJSONArray("RECORDS");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject each = jsonArray.getJSONObject(i);
                String templateId = each.getString("basic_id");

                String tableName = templateIdWithTableNameMap.get(templateId);
                if (tableName==null){
                    continue;
                }

                List<JSONObject> params = tableNameKeyParamsMap.computeIfAbsent(tableName,
                        k -> new ArrayList<>());
                params.add(each);
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void setParamsForEachTable(JtTemplate jtTemplate,
                                      GeneratorConfigAdapter generatorConfigAdapter,
                                      EachTableInfo eachTableInfo) {
        super.setParamsForEachTable(jtTemplate, generatorConfigAdapter, eachTableInfo);

        TableInfo tableInfo = eachTableInfo.getTableInfo();
        String tableName = tableInfo.getName();
        Map<String, Object> objectMap = eachTableInfo.getObjectMap();
        ConfigBuilder config = (ConfigBuilder) objectMap.get("config");
        PackageConfig packageConfig = config.getPackageConfig();

        //cz的属性
        String businessPrefixPackageName = (StringUtil.isEmpty(
                generatorConfigAdapter.getBusinessPrefix()) ? "" :
                "." + generatorConfigAdapter.getBusinessPrefix());
        String voPackage =
                generatorConfigAdapter.getBasePackageName() + ".api.model.datachip" +
                        businessPrefixPackageName +
                        ".vo";
        objectMap.put("voPackage", voPackage);
        String boPackage =
                generatorConfigAdapter.getBasePackageName() + ".api.model.datachip" +
                        businessPrefixPackageName +
                        ".bo";
        objectMap.put("boPackage", boPackage);
        String requestPackage =
                generatorConfigAdapter.getBasePackageName() + ".api.model.datachip" +
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
