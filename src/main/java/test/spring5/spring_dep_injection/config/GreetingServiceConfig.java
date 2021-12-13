package test.spring5.spring_dep_injection.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import test.spring5.spring_dep_injection.datasource.FakeDataSource;
import test.spring5.spring_dep_injection.repositories.EnglishGreetingRepository;
import test.spring5.spring_dep_injection.repositories.EnglishGreetingRepositoryImpl;
import test.spring5.spring_dep_injection.services.*;

//@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:xmlExample.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${test.username}")String userName,
                                  @Value("${test.password}")String password,
                                  @Value("${test.jdbcurl}")String jdbcurl){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUserName(userName);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcurl(jdbcurl);
        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean("petService")
    PetService getDogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean("petService")
    PetService getCatPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18nSpanishMyService i18nSpanishMyService(){
        return new I18nSpanishMyService();
    }
    @Profile("EN")
    @Bean
    I18nEnglishMyService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishMyService(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryMyService primaryMyService(){
        return new PrimaryMyService();
    }


//    @Bean
    ConstructorMyService constructorMyService(){
        return new ConstructorMyService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedMyService setterInjectedMyService(){
        return new SetterInjectedMyService();
    }

}
