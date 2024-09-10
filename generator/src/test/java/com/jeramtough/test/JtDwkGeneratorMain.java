package com.jeramtough.test;

import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.code.JavaCodeGenerator;
import com.jeramtough.jtcodegenerator.generator.code.JsCodeGenerator;

/**
 * <pre>
 * Created on 2021/12/29 下午2:55
 * by @author 北京瑞曦wjx
 * </pre>
 */
public class JtDwkGeneratorMain {

    public static void main(String[] args) {
        GeneratorConfigAdapter generatorConfigAdapter = new GeneratorConfigAdapter() {
            @Override
            public String getBasePackageName() {
                return "com.jeramtough.dwk.mobileapp";
            }

            @Override
            public String getBusinessPrefix() {
                return null;
            }

            @Override
            public boolean isSkipView() {
                return true;
            }

            @Override
            public String getOutputDir() {
                return "/developer/Codes/IdeaCodes/jtcodegenerator/template";
//                return "/developer/Codes/IdeaCodes/jtcodegenerator/generator/codes/im";
            }

            @Override
            public String getAuthor() {
                return "WeiBoWen";
            }

            @Override
            public String getUrl() {
                return "jdbc:mysql://47.107.113" +
                        ".233:3306/dwk_db?useSSL=false&serverTimezone=GMT%2B8" +
                        "&characterEncoding=utf-8";
            }

            @Override
            public String getDriverName() {
                return "com.mysql.jdbc.Driver";
            }

            @Override
            public String[] getUsernameAndPassword() {
                return new String[]{"root", "Aa73979901995"};
            }

        };

        JavaCodeGenerator javaCodeGenerator = new JavaCodeGenerator(generatorConfigAdapter);

        JsCodeGenerator jsCodeGenerator = new JsCodeGenerator(generatorConfigAdapter);

        javaCodeGenerator.generating();
        jsCodeGenerator.generating();
    }
}
