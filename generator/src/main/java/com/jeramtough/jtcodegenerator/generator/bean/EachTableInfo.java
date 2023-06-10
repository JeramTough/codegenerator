package com.jeramtough.jtcodegenerator.generator.bean;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;

import java.util.Map;

/**
 * <pre>
 * Created on 2021/12/29 下午4:24
 * by @author 北京瑞曦wjx
 * </pre>
 */
public class EachTableInfo {

    private TableInfo tableInfo;
    private Map<String, Object> objectMap;

    public EachTableInfo() {
    }

    public EachTableInfo(TableInfo tableInfo,
                         Map<String, Object> objectMap) {
        this.tableInfo = tableInfo;
        this.objectMap = objectMap;
    }

    public TableInfo getTableInfo() {
        return tableInfo;
    }

    public void setTableInfo(TableInfo tableInfo) {
        this.tableInfo = tableInfo;
    }

    public Map<String, Object> getObjectMap() {
        return objectMap;
    }

    public void setObjectMap(Map<String, Object> objectMap) {
        this.objectMap = objectMap;
    }
}
