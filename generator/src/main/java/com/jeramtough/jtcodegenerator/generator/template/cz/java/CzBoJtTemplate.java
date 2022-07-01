package com.jeramtough.jtcodegenerator.generator.template.cz.java;

import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.bean.EachTableInfo;
import com.jeramtough.jtcodegenerator.generator.template.BaseJtTemplate;
import com.jeramtough.jtcomponent.utils.StringUtil;

import java.util.*;

/**
 * <pre>
 * Created on 2021/12/29 下午4:51
 * by @author WeiBoWen
 * </pre>
 */
public class CzBoJtTemplate extends BaseJtTemplate {

    public CzBoJtTemplate(GeneratorConfigAdapter generatorConfigAdapter) {
        super(generatorConfigAdapter);
    }

    @Override
    public String getTemplatePath() {
        return "templates/JAVA/cz/BO.java.vm";
    }

    @Override
    public String getPackageName(EachTableInfo eachTableInfo) {
        return "model.datachip" + (StringUtil.isEmpty(
                getGeneratorConfigAdapter().getBusinessPrefix()) ? "" :
                "." + getGeneratorConfigAdapter().getBusinessPrefix()) + ".bo";
    }

    @Override
    public String getFileName(EachTableInfo eachTableInfo) {
        String tableModelName = (String) eachTableInfo.getObjectMap().get("tableModelName");
        return tableModelName + "BO.java";
    }

    @Override
    public void generationBefore(EachTableInfo eachTableInfo) {
        //过滤不需要的字段
        Set<String> filterFieldSet = new HashSet<>(
                Arrays.asList(
                        "id" ,
                        "importYear"
                        , "importMonth"
                        , "unifiedSocialCreditIdentifier"
                        , "lotNo"
                        , "fingerprintKey"
                        , "activeAt"));

        List<TableField> tableFieldList =
                eachTableInfo.getTableInfo().getFields();

        tableFieldList.removeIf(tableField -> filterFieldSet.contains(tableField.getName()));
    }
}
