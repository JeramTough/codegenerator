package com.jeramtough.jtcodegenerator.generator.template.jt.java;

import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.bean.EachTableInfo;
import com.jeramtough.jtcodegenerator.generator.template.BaseJtTemplate;

/**
 * <pre>
 * Created on 2021/12/29 下午4:51
 * by @author 北京瑞曦wjx
 * </pre>
 */
public class AddOrUpdateParamsJtTemplate extends BaseJtTemplate {

    public AddOrUpdateParamsJtTemplate(GeneratorConfigAdapter generatorConfigAdapter) {
        super(generatorConfigAdapter);
    }

    @Override
    public String getTemplatePath() {
        return "templates/JAVA/jt/AuParams.java.vm";
    }

    @Override
    public String getPackageName(EachTableInfo eachTableInfo) {
        String lowerEntityName= (String) eachTableInfo.getObjectMap().get("lowerEntityName");
        return "model.params."+lowerEntityName;
    }

    @Override
    public String getFileName(EachTableInfo eachTableInfo) {
        return "AddOrUpdate"+eachTableInfo.getTableInfo().getEntityName() + "Params.java";
    }
}
