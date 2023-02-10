package com.jeramtough.test;

import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.code.CodeGenerator;
import com.jeramtough.jtcodegenerator.generator.code.CzHupuJavaCodeGenerator;
import com.jeramtough.jtcodegenerator.generator.code.CzJavaCodeGenerator;

/**
 * <pre>
 * Created on 2021/12/29 下午2:55
 * by @author WeiBoWen
 * </pre>
 */
public class CzGeneratorMain2 {

    public static void main(String[] args) {
        GeneratorConfigAdapter generatorConfigAdapter = new GeneratorConfigAdapter() {
            @Override
            public String getBasePackageName() {
                return "synthesistaxgovernance";
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
//                return "jdbc:postgresql://127.0.0.1:5432/synthesis-tax-governance?user=postgres&password=123456&stringtype=unspecified";
                return "jdbc:mysql://127.0.0.1:3306/test_db" +
                        "?useUnicode=true" +
                        "&useSSL=false&characterEncoding=utf8";
            }

            @Override
            public String getDriverName() {
                return "com.mysql.jdbc.Driver";
            }

            @Override
            public String[] getUsernameAndPassword() {
//                return new String[]{"postgres", "123456"};
                return new String[]{"root", "123456"};
            }

        };

        CodeGenerator javaCodeGenerator = new CzJavaCodeGenerator(generatorConfigAdapter);

        javaCodeGenerator.generating();
    }
}
