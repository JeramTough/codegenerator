package com.jeramtough.jtcodegenerator.generator.code;

import cn.hutool.core.io.FileUtil;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.custom.CustomCodeGenerator;
import com.jeramtough.jtcodegenerator.generator.datasource.DatabasePool;
import com.jeramtough.jtcodegenerator.generator.path.PathHandler;
import com.jeramtough.jtcodegenerator.generator.util.MyIoUtil;
import com.jeramtough.jtlog.with.WithLogger;

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

        this.tag=initTag();

        //设置数据库数据源
        DataSource dataSource = initDataSource();

        DataSourceConfig.Builder builder=new DataSourceConfig.Builder(dataSource);
        //初始数据源配置
        this.initDataSourceConfig(builder);

        fastAutoGenerator = FastAutoGenerator.create(builder);

        //自定义模板生成器
        customCodeGenerator = initCustomCodeGenerator(tag,generatorConfigAdapter);

        //初始化mybatisplus的代码生成器
        initFastAutoGenerator(fastAutoGenerator);
    }

    protected abstract GeneratorTag initTag();

    protected void initDataSourceConfig(DataSourceConfig.Builder builder){

    }


    /**
     * 决定了使用哪个JtCustomCodeGenerator的生成器
     */
    protected abstract CustomCodeGenerator initCustomCodeGenerator(
            GeneratorTag tag, GeneratorConfigAdapter generatorConfigAdapter);

    protected DataSource initDataSource() {
        return DatabasePool.getDataSource(generatorConfigAdapter.getUrl(),
                generatorConfigAdapter.getUsernameAndPassword()[0],
                generatorConfigAdapter.getUsernameAndPassword()[1],
                generatorConfigAdapter.getDriverName());
    }

    /**
     * 配置Entity，Controller，Service这些生成策略之类的，具体看
     * <a href="https://baomidou.com/pages/981406/">https://baomidou.com/pages/981406/</a>
     */
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
