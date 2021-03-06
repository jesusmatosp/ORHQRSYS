package pe.gob.onp.orrhh.qr;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {                
	    return new Docket(DocumentationType.SWAGGER_2)          
	      .select()
	      .apis(RequestHandlerSelectors.basePackage("pe.gob.onp.orrhh.qr.controller"))
	      .paths(PathSelectors.any())         
	      .build()
	      .apiInfo(apiInfo());
	}
	 
	private ApiInfo apiInfo() {
	     return new ApiInfo(
	       "ONP API", 
	       "Some custom description of API.", 
	       "API Tienda", 
	       "Terms of service", 
	       new Contact("kenyoJoel903", "https://github.com/kenyoJoel903", "kenyojoel903@gmail.com"), 
	       "License of API", "API license URL", Collections.emptyList());
	}
}
