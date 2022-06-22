package com.jeramtough.jtcodegenerator.generator.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Created on 2021/12/30 下午4:07
 * by @author WeiBoWen
 * </pre>
 */
public class DatabasePool {

    private static final Map<String, DataSource> dataSourceMap = new HashMap<>(3);

    public static DataSource getDataSource(String url, String username, String password,
                                           String driverName) {

        String key = url + username + password + driverName;
        DataSource dataSource;
        synchronized (DatabasePool.class) {
            if (!dataSourceMap.containsKey(key)) {
                HikariConfig config = new HikariConfig();
                config.setJdbcUrl(url);
                config.setUsername(username);
                config.setPassword(password);
                config.setDriverClassName(driverName);
                dataSource = new HikariDataSource(config);
                dataSourceMap.put(key, dataSource);
            }
            dataSource = dataSourceMap.get(key);
        }

        return dataSource;

    }

}
