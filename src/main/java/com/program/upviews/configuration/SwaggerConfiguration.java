package com.program.upviews.configuration;

import com.fasterxml.classmate.TypeResolver;
import com.program.upviews.requests.AuthenticationRequest;
import static io.swagger.models.auth.In.HEADER;
import static java.util.Collections.singletonList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import static springfox.documentation.spi.DocumentationType.SWAGGER_2;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api(TypeResolver typeResolver) {
        return new Docket(SWAGGER_2)
                .apiInfo(apiInfo())
                .securitySchemes(singletonList(new ApiKey("JWT", AUTHORIZATION, HEADER.name())))
                .securityContexts(singletonList(
                        SecurityContext.builder()
                                .securityReferences(
                                        singletonList(SecurityReference.builder()
                                                .reference("JWT")
                                                .scopes(new AuthorizationScope[0])
                                                .build()
                                        )
                                )
                                .build())
                )
                .additionalModels(typeResolver.resolve(AuthenticationRequest.class))
                .select()
                .apis(RequestHandlerSelectors.basePackage("ro.secur.auth"))
                .build();
    }


    private ApiInfo apiInfo() {
        Contact contact = new Contact("upView", "TBD", "");
        return new ApiInfoBuilder()
                .title("upView REST API")
                .description("List of available API served by upView App")
                .version("1.0")
                .license("None")
                .licenseUrl("")
                .contact(contact)
                .build();
    }
}