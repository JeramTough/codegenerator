package com.jeramtough.test;

import com.jeramtough.jtcodegenerator.generator.adapter.GeneratorConfigAdapter;
import com.jeramtough.jtcodegenerator.generator.code.RxJavaCodeGenerator;
import com.jeramtough.jtcodegenerator.generator.code.RxscJavaCodeGenerator;

/**
 * <pre>
 * Created on 2021/12/29 下午2:55
 * by @author 北京瑞曦wjx
 * </pre>
 */
public class RxGeneratorMain {

    public static void main(String[] args) {
        GeneratorConfigAdapter generatorConfigAdapter = new GeneratorConfigAdapter() {
            @Override
            public String getBasePackageName() {
                return "org.jeecg.modules.appointmentcall";
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
                return "韦博文";
            }

            @Override
            public String getUrl() {
//                return "jdbc:mysql://192.168.1.30:3304/rici-appointment-call?characterEncoding=UTF-8&useUnicode=true&useSSL=false&tinyInt1isBit=false&allowPublicKeyRetrieval=true&nullCatalogMeansCurrent=true&serverTimezone=Asia/Shanghai";
                return "jdbc:mysql://192.168.1.30:3304/rici-appointment-call?useSSL=false&serverTimezone=GMT%2B8&characterEncoding=utf-8";
            }

            @Override
            public String getDriverName() {
                return "com.mysql.cj.jdbc.Driver";
            }

            @Override
            public String[] getUsernameAndPassword() {
                return new String[]{"root", "RICI123456"};
            }

        };

        RxJavaCodeGenerator rxscJavaCodeGenerator = new RxJavaCodeGenerator(generatorConfigAdapter);
//        JsCodeGenerator jsCodeGenerator = new JsCodeGenerator(generatorConfigAdapter);

        rxscJavaCodeGenerator.generating();
//        jsCodeGenerator.generating();
    }
}
