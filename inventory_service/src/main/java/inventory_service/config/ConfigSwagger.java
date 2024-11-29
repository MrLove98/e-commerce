package inventory_service.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                    title = "REST API for Inventory_Service", version = "1.0",
                    description = "REST API description...  => For Inventory_Service",
                    contact = @Contact(name = "mr.nquangtinh@gmail.com")
                    )
        )
public class ConfigSwagger {


    /**
     * Link using springdoc-openapi
     *  link: https://springdoc.org/#Introduction
     *
     * */


    /**
     * Why Swagger 2 Needs Configuration
     * Swagger 2 is a general-purpose API documentation framework that doesn't automatically know how your Spring Boot application is structured. The Docket bean acts as a bridge between Swagger and your application's controllers, enabling Swagger to:
     * <p>
     * Locate controllers and their endpoints.
     * Include only the desired endpoints.
     * Exclude unwanted paths or APIs.
     * Enrich the documentation with metadata.
     * Without this configuration, Swagger cannot determine how to document your APIs, leading to an incomplete or absent API documentation interface.
     */


//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2) /** 1 -sets the Swagger version being used (Swagger 2 in this case). */
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("src/main/java/service_profile/controller"))  /** 2- The .select() method allows you to specify which packages, classes, or methods Swagger should include in the API documentation.*/
//                .paths(PathSelectors.any()) // Document all paths
//                .build()
//                .apiInfo(new ApiInfoBuilder()                      /** 3- Customizing API Behavior:The Docket bean allows additional customizations,
//                                                                    such as setting API information (title, version, license), controlling which paths are documented, and applying security configurations.
//                                                                    */
//                        .title("Service Profile API")
//                        .description("API for Service_Profile")
//                        .version("1.0.0")
//                        .build());
//    }
//
//    /** 4 - Integration with Spring:
//
//     Spring Boot uses the Docket bean to wire Swagger into the application context. Without this configuration, Swagger wouldn't know which endpoints to document.
//     * */
}
