package com.jeramtough.jtcodegenerator.generator.template.cz.java;

import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.bean.EachTableInfo;
import com.jeramtough.jtcodegenerator.generator.template.BaseJtTemplate;
import com.jeramtough.jtcomponent.utils.StringUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <pre>
 * Created on 2021/12/29 下午4:51
 * by @author WeiBoWen
 * </pre>
 */
public class CzAddOrUpFormJtTemplate extends BaseJtTemplate {

    public CzAddOrUpFormJtTemplate(GeneratorConfigAdapter generatorConfigAdapter) {
        super(generatorConfigAdapter);
    }

    @Override
    public String getTemplatePath() {
        return "templates/JAVA/cz/AddOrUpForm.java.vm";
    }

    @Override
    public String getPackageName(EachTableInfo eachTableInfo) {
        return "model.datachip" + (StringUtil.isEmpty(
                getGeneratorConfigAdapter().getBusinessPrefix()) ? "" :
                "." + getGeneratorConfigAdapter().getBusinessPrefix()) + ".request";
    }

    @Override
    public String getFileName(EachTableInfo eachTableInfo) {
        String tableModelName = (String) eachTableInfo.getObjectMap().get("tableModelName");
        return tableModelName + "AddOrUpForm.java";
    }

    @Override
    public void generationBefore(EachTableInfo eachTableInfo) {
        Set<String> filterImportPackagesSet = new HashSet<>(
                Arrays.asList(
                        "com.baomidou.mybatisplus.annotation.TableName" ,
                        "java.io.Serializable",
                        "com.baomidou.mybatisplus.annotation.IdType",
                        "com.baomidou.mybatisplus.annotation.TableId"
                ));


        Set<String>importPackagesSet= eachTableInfo.getTableInfo().getImportPackages();
        importPackagesSet.removeIf(filterImportPackagesSet::contains);

        //过滤不需要的字段
        Set<String> filterFieldSet = new HashSet<>(
                Arrays.asList(
                        "id" ,
                        "importYear"
                        , "importMonth"
                        , "unifiedSocialCreditIdentifier"
                        , "lotNo"
                        , "fingerprintKey"
                        , "createBy"
                        , "updateBy"
                        , "createTime"
                        , "updateTime"
                        , "activeAt"));



        List<TableField> tableFieldList =
                eachTableInfo.getTableInfo().getFields();

        tableFieldList.removeIf(tableField -> filterFieldSet.contains(tableField.getName()));
    }
}
