package com.jeramtough.jtcodegenerator.generator.template.java;

import com.jeramtough.jtcodegenerator.generator.bean.EachTableInfo;
import com.jeramtough.jtcodegenerator.generator.template.BaseJtTemplate;

/**
 * <pre>
 * Created on 2021/12/29 下午4:51
 * by @author WeiBoWen
 * </pre>
 */
public class BasicServiceImplJtTemplate extends BaseJtTemplate {

    @Override
    protected String getTemplatePath() {
        return "templates/JAVA/jt/MyBaseServiceImpl.java.vm";
    }

    @Override
    protected String getPackageName(EachTableInfo eachTableInfo) {
        return "service.base.impl";
    }

    @Override
    protected String getFileName(EachTableInfo eachTableInfo) {
        return "MyBaseServiceImpl.java";
    }
}
