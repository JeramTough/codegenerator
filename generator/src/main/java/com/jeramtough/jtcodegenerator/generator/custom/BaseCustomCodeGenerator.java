package com.jeramtough.jtcodegenerator.generator.custom;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.bean.EachTableInfo;
import com.jeramtough.jtcodegenerator.generator.code.GeneratorTag;
import com.jeramtough.jtcodegenerator.generator.params.TemplateParamsInitializer;
import com.jeramtough.jtcodegenerator.generator.path.PathHandler;
import com.jeramtough.jtcodegenerator.generator.template.JtTemplate;
import com.jeramtough.jtcomponent.utils.StringUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * Created on 2021/12/30 下午4:57
 * by @author WeiBoWen
 * </pre>
 */
public abstract class BaseCustomCodeGenerator implements CustomCodeGenerator {

    protected final GeneratorConfigAdapter generatorConfigAdapter;
    protected final List<EachTableInfo> eachTableInfoList = new ArrayList<>();
    protected final List<JtTemplate> jtTemplateList = new ArrayList<>();
    protected final PathHandler pathHandler;
    protected final GeneratorTag tag;

    protected TemplateParamsInitializer templateParamsInitializer;

    /**
     * @param tag                    决定了哪个输出路径，{@see PathHandler}
     * @param generatorConfigAdapter 设置
     */
    protected BaseCustomCodeGenerator(
            GeneratorTag tag,
            GeneratorConfigAdapter generatorConfigAdapter) {
        this.tag = tag;
        this.generatorConfigAdapter = generatorConfigAdapter;
        pathHandler = new PathHandler(generatorConfigAdapter.getOutputDir());

        this.templateParamsInitializer = initTemplateParamsInitializer();
        initTemplates(jtTemplateList);
    }

    protected abstract TemplateParamsInitializer initTemplateParamsInitializer();

    protected abstract void initTemplates(List<JtTemplate> jtTemplateList);


    @Override
    public void addTable(TableInfo tableInfo, Map<String, Object> objectMap) {

        //config.packageConfig.parent
        EachTableInfo eachTableInfo = new EachTableInfo(tableInfo, objectMap);
        eachTableInfoList.add(eachTableInfo);
    }


    @Override
    public void execute() {

        //设置每个模板的自定义属性
        jtTemplateList
                .forEach(jtTemplate -> {
                    eachTableInfoList
                            .forEach(eachTableInfo -> {
                                //设置每个表的属性
                                templateParamsInitializer.setParamsForEachTable(
                                        jtTemplate,
                                        generatorConfigAdapter, eachTableInfo);
                            });
                });

        //设置全部属性
        templateParamsInitializer.setParamsForAllTable(eachTableInfoList);

        //真正开始生成
        jtTemplateList
                .forEach(jtTemplate -> {
                    eachTableInfoList
                            .forEach(eachTableInfo -> {

                                String outputPath = pathHandler.getOutputPath(tag);

                                //调用前置通知
                                jtTemplate.generationBefore(eachTableInfo);


                                //得出输出路径
                                StringBuilder outputDirPath = new StringBuilder(
                                        outputPath);
                                if (!StringUtil.isEmpty(
                                        generatorConfigAdapter.getBasePackageName())) {
                                    String[] ss =
                                            generatorConfigAdapter.getBasePackageName().split(
                                                    "\\.");
                                    for (String s : ss) {
                                        outputDirPath
                                                .append(File.separator)
                                                .append(s);
                                    }
                                }
                                File outputDir =
                                        new File(outputDirPath.toString());

                                //开始模板生成
                                jtTemplate.generating(eachTableInfo, outputDir);
                            });
                });
    }


}
