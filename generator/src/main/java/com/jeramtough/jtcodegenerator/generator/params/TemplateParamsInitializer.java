package com.jeramtough.jtcodegenerator.generator.params;

import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.bean.EachTableInfo;
import com.jeramtough.jtcodegenerator.generator.template.JtTemplate;

import java.util.List;

/**
 * 自定义模板的自定义属性设置器，每个模板对应一个
 * <pre>
 * Created on 2022/7/4 下午5:03
 * by @author 北京瑞曦wjx
 * </pre>
 */
public interface TemplateParamsInitializer {

    /**
     * 每个数据库表都设置一遍，对应那种controller，entity这种一张表就生成一个对象
     * @param jtTemplate  jtTemplate有可能是null的
     */
    void setParamsForEachTable(
            JtTemplate jtTemplate,
            GeneratorConfigAdapter generatorConfigAdapter,
            EachTableInfo eachTableInfo);

    /**
     * 所有的数据库表都设置完了，再来设置的全局属性，对应那种一个项目就一个文件生成，比如
     * apiHandler.js，里面有所有api的请求
     */
    void setParamsForAllTable(List<EachTableInfo> eachTableInfoList);

}
