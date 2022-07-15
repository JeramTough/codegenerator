package com.jeramtough.jtcodegenerator.generator.template.cz.java;

import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.bean.EachTableInfo;
import com.jeramtough.jtcodegenerator.generator.template.BaseJtTemplate;

import java.util.*;

/**
 * <pre>
 * Created on 2021/12/29 下午4:51
 * by @author WeiBoWen
 * </pre>
 */
public class CzAnalyseMapperJtTemplate extends BaseJtTemplate {

    public CzAnalyseMapperJtTemplate(GeneratorConfigAdapter generatorConfigAdapter) {
        super(generatorConfigAdapter);
    }

    @Override
    public String getTemplatePath() {
        return "templates/JAVA/cz/AnalyseMapper.java.vm";
    }

    @Override
    public String getPackageName(EachTableInfo eachTableInfo) {
        return "datasource.mapper.analyse";
    }

    @Override
    public String getFileName(EachTableInfo eachTableInfo) {
        String tableModelName = (String) eachTableInfo.getObjectMap().get("tableModelName");
        return "Analyse"+tableModelName + "Mapper.java";
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
