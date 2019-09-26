package cn.liuyiyou.shop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@EnableSwagger2
@Slf4j
public class YiShopAdminApplication  implements InitializingBean {


    @GetMapping("/")
    public String home(){
        return "success";
    }

    public static void main(String[] args) {
        SpringApplication.run(YiShopAdminApplication.class, args);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("启动成功......................");
    }

    @Bean
    public Docket createRestApi() {
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        ticketPar.name("Authorization").description("Token")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build(); //header中的Authorization参数非必填，传空也可以

        pars.add(ticketPar.build());    //根据每个方法名也知道当前方法在设置什么参数
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(pars)
                ;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("供应链平台系统 后台接口文档")
                .description("参数类型中带有optional表示该参数可为空，如果没有表示该参数必填")
                .termsOfServiceUrl("http://localhost:10001/")
                .version("1.0")
                .build();
    }

}
