package com.vue.api;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.Predicate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@ComponentScan
@EnableSwagger2
@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any()) // 현재 RequestMapping으로 할당된 모든 URL 리스트를 추출
                /*.paths(PathSelectors.ant("/*")) // 해당 URL들 필터링*/
                .paths(PathSelectors.any())	// 모든 맵핑한걸 다잡는거같아요~!
                .build();
    }
    
//    public Docket config(String groupName, Predicate path) {
//        return new Docket(DocumentationType.SWAGGER_2).groupName(groupName).useDefaultResponseMessages(false)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.vue.api.controller"))
//                .paths(path)
////                .paths(PathSelectors.ant("/**"))
//                .build().directModelSubstitute(LocalDate.class, String.class)
//                .globalResponseMessage(RequestMethod.GET,
//                        Arrays.asList(new ResponseMessageBuilder()
//                                        .code(500)
//                                        .message("서버 오류!")
//                                        .build(),
//                                new ResponseMessageBuilder()
//                                        .code(401)
//                                        .message("인증정보가 필요합니다 !")
//                                        .build()))
//                .globalResponseMessage(RequestMethod.POST,
//                        Arrays.asList(new ResponseMessageBuilder()
//                                        .code(500)
//                                        .message("서버 오류!")
//                                        .build(),
//                                new ResponseMessageBuilder()
//                                        .code(401)
//                                        .message("인증정보가 필요합니다 !")
//                                        .build()))
//                .genericModelSubstitutes(ResponseEntity.class)
//                .securitySchemes(Arrays.asList(apiKey()))
//                .securityContexts(Arrays.asList(securityContext()));
//
//    }
//
//    private ApiKey apiKey() {
//        return new ApiKey("apiKey", "Authorization", "header");
//    }
//
//    private SecurityContext securityContext() {
//        return SecurityContext.builder().securityReferences(defaultAuth())
//                .forPaths(PathSelectors.any()).build();
//    }
//
//
//    private List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope = new AuthorizationScope(
//                "global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        return Arrays.asList(new SecurityReference("apiKey",
//                authorizationScopes));
//    }
    
}
