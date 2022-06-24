package com.jeramtough.jtcodegenerator.generator.template;

import cn.hutool.core.io.IoUtil;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.jeramtough.jtcodegenerator.generator.bean.EachTableInfo;
import com.jeramtough.jtcodegenerator.generator.template.JtTemplate;
import com.jeramtough.jtcomponent.utils.JtFileUtil;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.*;
import java.util.Map;
import java.util.Objects;

/**
 * <pre>
 * Created on 2021/12/29 下午4:38
 * by @author WeiBoWen
 * </pre>
 */
public abstract class BaseJtTemplate implements JtTemplate {

    private VelocityEngine velocityEngine;
    private Template template;

    protected BaseJtTemplate() {
        this.velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(
                VelocityEngine.RUNTIME_LOG_NAME, this.getClass().getSimpleName());
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class",
                ClasspathResourceLoader.class.getName());
        velocityEngine.init();
        template = velocityEngine.getTemplate(getTemplatePath());
    }


    @Override
    public void generating(EachTableInfo eachTableInfo, File outputDir) {
        VelocityContext context = new VelocityContext();
        for (Map.Entry<String, Object> entry : eachTableInfo.getObjectMap().entrySet()) {
            context.put(entry.getKey(), entry.getValue());
        }

        String packageName = getPackageName(eachTableInfo);
        Objects.requireNonNull(packageName);
        String[] packageNames = packageName.split("\\.");
        StringBuilder outputFilePath = new StringBuilder(outputDir.getAbsolutePath());
        for (String name : packageNames) {
            outputFilePath.append(File.separator).append(name);
        }

        String fileName = getFileName(eachTableInfo);
        outputFilePath.append(File.separator);
        outputFilePath.append(fileName);

        File outputFile = new File(outputFilePath.toString());

        if (outputFile.exists()) {
            return;
        }

        if (!outputFile.getParentFile().exists()) {
            outputFile.getParentFile().mkdirs();
        }

        try {
            StringWriter sw = new StringWriter();
            template.merge(context, sw);

            IoUtil.writeUtf8(new FileOutputStream(outputFile), true, sw.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void generationBefore(EachTableInfo eachTableInfo) {
        
    }
}
