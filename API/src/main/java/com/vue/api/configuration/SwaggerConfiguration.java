package com.vue.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration extends WebMvcConfigurationSupport {


	@Bean
	public Docket user() {
		  return this.config("1.회원가입", Predicates.or(
	                PathSelectors.regex("/userJoin/10.*")
	        ));
	}
	
	@Bean
	public Docket board() {
		  return this.config("4.게시판", Predicates.or(
	                PathSelectors.regex("/board/40.*")
	        ));
	}
	
	
    public Docket  config(String groupName, Predicate path) {
        return new Docket(DocumentationType.SWAGGER_2).groupName(groupName).useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vue.api.controller")) // 현재 RequestMapping으로 할당된 모든 URL 리스트를 추출
                /*.paths(PathSelectors.ant("/*")) // 해당 URL들 필터링*/
                .paths(path)	// 모든 맵핑한걸 다잡는거같아요~!
                .build();
    }
    
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    
    
}
