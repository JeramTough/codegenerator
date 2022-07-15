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
public class CzAnalysePoJtTemplate extends BaseJtTemplate {

    public CzAnalysePoJtTemplate(GeneratorConfigAdapter generatorConfigAdapter) {
        super(generatorConfigAdapter);
    }

    @Override
    public String getTemplatePath() {
        return "templates/JAVA/cz/AnalysePO.java.vm";
    }

    @Override
    public String getPackageName(EachTableInfo eachTableInfo) {
        return "datasource.po.analyse.drischool";
    }

    @Override
    public String getFileName(EachTableInfo eachTableInfo) {
        String tableModelName = (String) eachTableInfo.getObjectMap().get("tableModelName");
        return "Analyse"+tableModelName + "PO.java";
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

        //过滤不需要的字段
        Set<String> filterFieldSet = new HashSet<>(
                Arrays.asList(
                        "id",
                        "import_year"
                        , "import_month"
                        , "unifiedSocialCreditIdentifier"
                        , "lot_no"
                        , "status"
                        , "del_flag"
                        , "create_by"
                        , "update_by"
                        , "create_time"
                        , "update_time"
                        , "fingerprint_key"
                        , "active_at"));

        List<TableField> tableFieldList =
                eachTableInfo.getTableInfo().getFields();

        List<TableField> removedList = new ArrayList<>();
        for (int i = 0; i < tableFieldList.size(); i++) {
            TableField tableField = tableFieldList.get(i);

            if (filterFieldSet.contains(tableField.getName())) {
                removedList.add(tableField);
            }
        }

        for (TableField tableField : removedList) {
            tableFieldList.remove(tableField);
        }

    }
}
