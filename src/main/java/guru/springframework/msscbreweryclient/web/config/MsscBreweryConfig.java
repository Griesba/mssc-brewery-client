package guru.springframework.msscbreweryclient.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
@Configuration
@Data
public class MsscBreweryConfig {
    private String apihost;

}
