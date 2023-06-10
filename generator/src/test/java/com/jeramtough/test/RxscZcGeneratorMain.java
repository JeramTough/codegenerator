package com.jeramtough.test;

import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.code.JavaCodeGenerator;
import com.jeramtough.jtcodegenerator.generator.code.RxscJavaCodeGenerator;

/**
 * <pre>
 * Created on 2021/12/29 下午2:55
 * by @author 北京瑞曦wjx
 * </pre>
 */
public class RxscZcGeneratorMain {

    public static void main(String[] args) {
        GeneratorConfigAdapter generatorConfigAdapter = new GeneratorConfigAdapter() {
            @Override
            public String getBasePackageName() {
                return "org.jeecg.modules.synergy";
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
                return "北京瑞曦wjx";
            }

            @Override
            public String getUrl() {
                return "jdbc:mysql://47.108.158.81:3306/irw_system_dev?" +
                        "characterEncoding=UTF-8&useUnicode=true&useSSL=false&tinyInt1isBit=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Shanghai";
            }

            @Override
            public String getDriverName() {
                return "com.mysql.jdbc.Driver";
            }

            @Override
            public String[] getUsernameAndPassword() {
                return new String[]{"irw_system", "X^7N81AEWDz_3^93kz"};
            }

        };

        RxscJavaCodeGenerator rxscJavaCodeGenerator = new RxscJavaCodeGenerator(generatorConfigAdapter);
//        JsCodeGenerator jsCodeGenerator = new JsCodeGenerator(generatorConfigAdapter);

        rxscJavaCodeGenerator.generating();
//        jsCodeGenerator.generating();
    }
}
