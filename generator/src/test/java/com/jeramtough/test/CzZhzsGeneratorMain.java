package com.jeramtough.test;

import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.code.CzJavaCodeGenerator;
import com.jeramtough.jtcodegenerator.generator.code.JavaCodeGenerator;
import com.jeramtough.jtcodegenerator.generator.code.JsCodeGenerator;

/**
 * <pre>
 * Created on 2021/12/29 下午2:55
 * by @author 北京瑞曦wjx
 * </pre>
 */
public class CzZhzsGeneratorMain {

    public static void main(String[] args) {
        GeneratorConfigAdapter generatorConfigAdapter = new GeneratorConfigAdapter() {
            @Override
            public String getBasePackageName() {
                return "synthesistaxgovernance";
            }

            @Override
            public String getBusinessPrefix() {
                return "realestate";
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
                return "北京瑞曦wjx";
            }

            @Override
            public String getUrl() {
//                return "jdbc:postgresql://127.0.0.1:5432/synthesis-tax-governance?user=postgres&password=123456&stringtype=unspecified";
                return "jdbc:postgresql://192.168.8.212:5432/synthesis-tax-governance?user=postgres&password=postgres!@#123&stringtype=unspecified";
            }

            @Override
            public String getDriverName() {
                return "org.postgresql.Driver";
            }

            @Override
            public String[] getUsernameAndPassword() {
//                return new String[]{"postgres", "123456"};
                return new String[]{"postgres", "postgres!@#123"};
            }

        };

        CzJavaCodeGenerator javaCodeGenerator = new CzJavaCodeGenerator(generatorConfigAdapter);

        javaCodeGenerator.generating();
    }
}
