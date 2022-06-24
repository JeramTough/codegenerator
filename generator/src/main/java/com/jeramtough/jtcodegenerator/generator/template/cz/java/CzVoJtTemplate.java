package com.jeramtough.jtcodegenerator.generator.template.cz.java;

import com.jeramtough.jtcodegenerator.generator.bean.EachTableInfo;
import com.jeramtough.jtcodegenerator.generator.template.BaseJtTemplate;

/**
 * <pre>
 * Created on 2021/12/29 下午4:51
 * by @author WeiBoWen
 * </pre>
 */
public class CzVoJtTemplate extends BaseJtTemplate {

    @Override
    public String getTemplatePath() {
        return "templates/JAVA/cz/VO.java.vm";
    }

    @Override
    public String getPackageName(EachTableInfo eachTableInfo) {
        return "model.datachip.realestate.vo";
    }

    @Override
    public String getFileName(EachTableInfo eachTableInfo) {
        String tableModelName = (String) eachTableInfo.getObjectMap().get("tableModelName");
        return tableModelName + "VO.java";
    }
}
