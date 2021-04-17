package guru.springframework.sfgdi.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ConfigurationProperties("guru")
@Configuration
public class SfgConfiguration {
private String username;
private String password;
private String jdbcurl;
}
