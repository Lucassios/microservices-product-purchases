package com.productpurchases.shopkeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Created by lucascmarques on 04/06/17.
 */
@SpringBootApplication
public class ShopkeeperApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopkeeperApplication.class, args);
    }

	@Bean
	public Docket swaggerSettings() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.any())
	                .paths(PathSelectors.any())
	                .build().apiInfo(apiInfo())
	                .pathMapping("/");
	    }	
	 
 	/**
     * API Info as it appears on the swagger-ui page
     */
    private ApiInfo apiInfo() {
        	    ApiInfo apiInfo = new ApiInfo(
        	    	      "API Shopkeeper",
        	    	      "API Shopkeeper - Trabalho Final Backend",
        	    	      "1.0",
        	    	      "Terms of service",
        	    	      "a@gmail.com",
        	    	      "Apache 2.0",
        	              "http://www.apache.org/licenses/LICENSE-2.0.html");
        return apiInfo;
    }
    
}
