package guru.springframework.sfgdi.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@ConfigurationProperties("guru")
public class SfgConstructorConfig {
private final String username;
private final String password;
private final String jdbcurl;

public SfgConstructorConfig(String username, String password, String jdbcurl) {
    this.username = username;
    this.password = password;
    this.jdbcurl = jdbcurl;
}
}
