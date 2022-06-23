package com.jeramtough.jtcodegenerator.generator.template.java;

import com.jeramtough.jtcodegenerator.generator.bean.EachTableInfo;
import com.jeramtough.jtcodegenerator.generator.template.BaseJtTemplate;

/**
 * <pre>
 * Created on 2021/12/29 下午4:51
 * by @author WeiBoWen
 * </pre>
 */
public class AddOrUpdateParamsJtTemplate extends BaseJtTemplate {

    @Override
    protected String getTemplatePath() {
        return "templates/JAVA/jt/AuParams.java.vm";
    }

    @Override
    protected String getPackageName(EachTableInfo eachTableInfo) {
        String lowerEntityName= (String) eachTableInfo.getObjectMap().get("lowerEntityName");
        return "model.params."+lowerEntityName;
    }

    @Override
    protected String getFileName(EachTableInfo eachTableInfo) {
        return "AddOrUpdate"+eachTableInfo.getTableInfo().getEntityName() + "Params.java";
    }
}
