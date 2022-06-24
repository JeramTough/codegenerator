package com.jeramtough.jtcodegenerator.generator.template.cz.java;

import com.jeramtough.jtcodegenerator.generator.bean.EachTableInfo;
import com.jeramtough.jtcodegenerator.generator.template.BaseJtTemplate;

/**
 * <pre>
 * Created on 2021/12/29 下午4:51
 * by @author WeiBoWen
 * </pre>
 */
public class CzBoJtTemplate extends BaseJtTemplate {

    @Override
    public String getTemplatePath() {
        return "templates/JAVA/cz/BO.java.vm";
    }

    @Override
    public String getPackageName(EachTableInfo eachTableInfo) {
        return "model.datachip.realestate.bo";
    }

    @Override
    public String getFileName(EachTableInfo eachTableInfo) {
        String tableModelName = (String) eachTableInfo.getObjectMap().get("tableModelName");
        return tableModelName + "BO.java";
    }
}
