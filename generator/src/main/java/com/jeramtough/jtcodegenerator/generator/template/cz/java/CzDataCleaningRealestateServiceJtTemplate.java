package com.jeramtough.jtcodegenerator.generator.template.cz.java;

import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.bean.EachTableInfo;
import com.jeramtough.jtcodegenerator.generator.template.BaseJtTemplate;
import com.jeramtough.jtcomponent.utils.StringUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 * Created on 2021/12/29 下午4:51
 * by @author 北京瑞曦wjx
 * </pre>
 */
public class CzDataCleaningRealestateServiceJtTemplate extends BaseJtTemplate {

    public CzDataCleaningRealestateServiceJtTemplate(
            GeneratorConfigAdapter generatorConfigAdapter) {
        super(generatorConfigAdapter);
    }

    @Override
    public String getTemplatePath() {
        return "templates/JAVA/cz/DataCleaningRealestateService.java.vm";
    }

    @Override
    public String getPackageName(EachTableInfo eachTableInfo) {
        return "web.service.datacleaning" + (StringUtil.isEmpty(
                getGeneratorConfigAdapter().getBusinessPrefix()) ? "" :
                "." + getGeneratorConfigAdapter().getBusinessPrefix()) + ".drischool";
    }

    @Override
    public String getFileName(EachTableInfo eachTableInfo) {
        String tableModelName = (String) eachTableInfo.getObjectMap().get("tableModelName");
        return "DataCleaning" + tableModelName + "Service.java";
    }

    @Override
    public void generationBefore(EachTableInfo eachTableInfo) {
        Set<String> filterImportPackagesSet = new HashSet<>(
                Arrays.asList(
                        "com.baomidou.mybatisplus.annotation.TableName",
                        "java.io.Serializable",
                        "com.baomidou.mybatisplus.annotation.IdType",
                        "com.baomidou.mybatisplus.annotation.TableId"
                ));


        Set<String> importPackagesSet = eachTableInfo.getTableInfo().getImportPackages();
        importPackagesSet.removeIf(filterImportPackagesSet::contains);

    }
}
