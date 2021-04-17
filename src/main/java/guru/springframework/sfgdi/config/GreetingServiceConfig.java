package guru.springframework.sfgdi.config;

import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import guru.springframework.sfgdi.datasource.FakeDataSource;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.ConstructorGreetingService;
import guru.springframework.sfgdi.services.I18nEnglishGreetingService;
import guru.springframework.sfgdi.services.I18nSpanishGreetingService;
import guru.springframework.sfgdi.services.PrimaryGreetingService;
import guru.springframework.sfgdi.services.PropertyGreetingService;
import guru.springframework.sfgdi.services.SetterGreetingService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@EnableConfigurationProperties(SfgConstructorConfig.class)
@Configuration
public class GreetingServiceConfig {

//@Bean
//FakeDataSource fakeDataSource(@Value("${guru.username}") String username,
//                              @Value("${guru.password}") String password,
//                              @Value("${guru.jdbcurl}") String jdbcurl) {
//
//    FakeDataSource fakeDataSource = new FakeDataSource();
//    fakeDataSource.setUsername(username);
//    fakeDataSource.setPassword(password);
//    fakeDataSource.setJdbcurl(jdbcurl);
//    return fakeDataSource;
//}

//second way
//@Bean
//FakeDataSource fakeDataSource(SfgConfiguration sfgConfiguration) {
//
//    FakeDataSource fakeDataSource = new FakeDataSource();
//    fakeDataSource.setUsername(sfgConfiguration.getUsername());
//    fakeDataSource.setPassword(sfgConfiguration.getPassword());
//    fakeDataSource.setJdbcurl(sfgConfiguration.getJdbcurl());
//    return fakeDataSource;
//}

//third way
@Bean
FakeDataSource fakeDataSource(SfgConstructorConfig sfgConstructorConfig) {

    FakeDataSource fakeDataSource = new FakeDataSource();
    fakeDataSource.setUsername(sfgConstructorConfig.getUsername());
    fakeDataSource.setPassword(sfgConstructorConfig.getPassword());
    fakeDataSource.setJdbcurl(sfgConstructorConfig.getJdbcurl());
    return fakeDataSource;
}

@Bean
PetServiceFactory petServiceFactory() {
    return new PetServiceFactory();
}

@Profile({"dog", "default"})
@Bean
PetService dogPetService(PetServiceFactory petServiceFactory) {
    return petServiceFactory.getPetService("dog");
}

@Profile("cat")
@Bean
PetService catPetService(PetServiceFactory petServiceFactory) {
    return petServiceFactory.getPetService("cat");
}

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

