package pl.nullpointerexeption.restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

import static java.util.Collections.singletonList;

@Configuration
public class Config implements WebMvcConfigurer {

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .ignoredParameterTypes(UsernamePasswordAuthenticationToken.class)
                .select()
                // TODO: Upgrade to Springfox Swagger 3.0.0
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
                .paths(PathSelectors.regex("^(?!/(error).*$).*$"))
                .build()
                .securitySchemes(singletonList(createSchema()))
                .securityContexts(singletonList(createContext()));
    }

    private SecurityScheme createSchema() {
        return new ApiKey("apiKey", "Authorization", "header");
    }

    private SecurityContext createContext() {
        return SecurityContext.builder()
                .securityReferences(createRef())
                .forPaths(PathSelectors.any())
                .build();
    }

    private List<SecurityReference> createRef() {
        AuthorizationScope authorizationScope = new AuthorizationScope(
                "global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return singletonList(new SecurityReference("apiKey", authorizationScopes));
    }

    // TODO: Upgrade to Springfox Swagger 3.0.0
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
//        resourceHandlerRegistry.addResourceHandler("/swagger-ui/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
//                .resourceChain(false);
//    }
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
//        viewControllerRegistry.addViewController("/swagger-ui/")
//                .setViewName("forward:" + "/swagger-ui/index.html");
//    }
}
