package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.ConstructorGreetingService;
import guru.springframework.sfgdi.services.I18nEnglishGreetingService;
import guru.springframework.sfgdi.services.I18nSpanishGreetingService;
import guru.springframework.sfgdi.services.PrimaryGreetingService;
import guru.springframework.sfgdi.services.PropertyGreetingService;
import guru.springframework.sfgdi.services.SetterGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

@Profile({"ES", "default"})
@Bean("i18nService")
I18nSpanishGreetingService i18nSpanishGreetingService() {
    return new I18nSpanishGreetingService();
}

@Bean
EnglishGreetingRepository englishGreetingRepository() {
    return new EnglishGreetingRepositoryImpl();
}

@Profile("EN")
@Bean("i18nService")
I18nEnglishGreetingService i18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
    return new I18nEnglishGreetingService(englishGreetingRepository);
}

@Primary
@Bean
PrimaryGreetingService primaryGreetingService() {
    return new PrimaryGreetingService();
}

@Bean
ConstructorGreetingService constructorGreetingService() {
    return new ConstructorGreetingService();
}

@Bean
SetterGreetingService setterGreetingService() {
    return new SetterGreetingService();
}

@Bean
PropertyGreetingService propertyGreetingService() {
    return new PropertyGreetingService();
}


}

