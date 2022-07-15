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
public class BbeGeneratorMain {

    public static void main(String[] args) {
        GeneratorConfigAdapter generatorConfigAdapter = new GeneratorConfigAdapter() {
            @Override
            public String getBasePackageName() {
                return "com.icloudmap.bbe";
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
                return "jdbc:oracle:thin:@192.168.0.66:1521:ORCL";
            }

            @Override
            public String getDriverName() {
                return "oracle.jdbc.OracleDriver";
            }

            @Override
            public String[] getUsernameAndPassword() {
                return new String[]{"onemap", "salis"};
            }
        };

        JavaCodeGenerator javaCodeGenerator = new JavaCodeGenerator(generatorConfigAdapter);
        JsCodeGenerator jsCodeGenerator = new JsCodeGenerator(generatorConfigAdapter);

        javaCodeGenerator.generating();
        jsCodeGenerator.generating();
    }
}
