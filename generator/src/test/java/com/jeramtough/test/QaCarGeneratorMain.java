package com.jeramtough.test;

import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.code.JavaCodeGenerator;
import com.jeramtough.jtcodegenerator.generator.code.JsCodeGenerator;

/**
 * <pre>
 * Created on 2021/12/29 下午2:55
 * by @author WeiBoWen
 * </pre>
 */
public class QaCarGeneratorMain {

    public static void main(String[] args) {
        GeneratorConfigAdapter generatorConfigAdapter = new GeneratorConfigAdapter() {
            @Override
            public String getBasePackageName() {
                return "com.jeramtough.qacar";
            }

            @Override
            public String getBusinessPrefix() {
                return null;
            }

            @Override
            public boolean isSkipView() {
                return false;
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
                return "jdbc:mysql://39.99.51.221:3306/qacar_db?useUnicode=true" +
                        "&useSSL=false&characterEncoding=utf8";
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
