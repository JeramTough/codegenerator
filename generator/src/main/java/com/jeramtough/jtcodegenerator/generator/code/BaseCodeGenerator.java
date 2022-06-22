package com.jeramtough.jtcodegenerator.generator.code;

import cn.hutool.core.io.FileUtil;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.custom.CustomCodeGenerator;
import com.jeramtough.jtcodegenerator.generator.custom.CustomCodeGeneratorFactory;
import com.jeramtough.jtcodegenerator.generator.datasource.DatabasePool;
import com.jeramtough.jtcodegenerator.generator.path.PathHandler;
import com.jeramtough.jtcodegenerator.generator.util.MyIoUtil;
import com.jeramtough.jtlog.with.WithLogger;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

/**
 * <pre>
 * Created on 2021/12/30 下午3:52
 * by @author WeiBoWen
 * </pre>
 */
public abstract class BaseCodeGenerator implements CodeGenerator, WithLogger {

    protected FastAutoGenerator fastAutoGenerator;
    protected final GeneratorConfigAdapter generatorConfigAdapter;
    protected final PathHandler pathHandler;
    protected GeneratorTag tag;
    protected CustomCodeGenerator customCodeGenerator;

    protected BaseCodeGenerator(
            GeneratorConfigAdapter generatorConfigAdapter) {
        this.generatorConfigAdapter = generatorConfigAdapter;
        pathHandler = new PathHandler(generatorConfigAdapter.getOutputDir());

        init();
    }

    protected void init() {
        tag = initTag();

        //设置数据库数据源
        DataSource dataSource = initDataSource();
        fastAutoGenerator = FastAutoGenerator.create(new DataSourceConfig.Builder(dataSource));

        //自定义模板生成器
        customCodeGenerator = CustomCodeGeneratorFactory.getCustomCodeGenerator(tag,
                generatorConfigAdapter);

        //初始化mybatisplus的代码生成器
        initFastAutoGenerator(fastAutoGenerator);
    }

    protected abstract GeneratorTag initTag();

    protected DataSource initDataSource() {
        return DatabasePool.getDataSource(generatorConfigAdapter.getUrl(),
                generatorConfigAdapter.getUsernameAndPassword()[0],
                generatorConfigAdapter.getUsernameAndPassword()[1],
                generatorConfigAdapter.getDriverName());
    }

    protected abstract void initFastAutoGenerator(FastAutoGenerator fastAutoGenerator);

    @Override
    public void generating() {
        //把历史文件删除
        String path =
                MyIoUtil.getPathFromFilePathAndPackagePath(pathHandler.getOutputPath(tag),
                        generatorConfigAdapter.getBasePackageName());
        getLogger().debug("清空文件夹：" + path);
        FileUtil.clean(path);

        fastAutoGenerator.execute();
        customCodeGenerator.execute();

        getLogger().info("生成自定义模板【%s】代码完成", tag.name());
    }

}
