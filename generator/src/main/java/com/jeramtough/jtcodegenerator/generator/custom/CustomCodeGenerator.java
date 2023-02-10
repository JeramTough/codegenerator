package com.jeramtough.jtcodegenerator.generator.custom;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.jeramtough.jtcodegenerator.generator.bean.EachTableInfo;

import java.util.Map;

/**
 * <pre>
 * Created on 2021/12/29 下午4:15
 * by @author WeiBoWen
 * </pre>
 */
public interface CustomCodeGenerator {

    EachTableInfo addTable(TableInfo tableInfo, Map<String, Object> objectMap);

    void execute();
}
