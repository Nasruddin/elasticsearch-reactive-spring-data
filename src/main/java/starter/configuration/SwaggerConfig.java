package starter.configuration;

import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi elasticOpenApi(@Value("${springdoc.version}") String appVersion) {
        String[] paths = { "/elastic-cluster/**" };
        return GroupedOpenApi.builder().
                group("elasticsearch")
                .addOpenApiCustomizer(openApi -> openApi.info(new Info().title("Elasticsearch API").version(appVersion)))
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi movieOpenApi(@Value("${springdoc.version}") String appVersion) {
        String[] paths = { "/movie/**" };
        return GroupedOpenApi.builder().
                group("movies")
                .addOpenApiCustomizer(openApi -> openApi.info(new Info().title("Movie API").version(appVersion)))
                .pathsToMatch(paths)
                .build();
    }
}
