package test.spring5.spring_dep_injection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import test.spring5.spring_dep_injection.repositories.EnglishGreetingRepository;
import test.spring5.spring_dep_injection.repositories.EnglishGreetingRepositoryImpl;
import test.spring5.spring_dep_injection.services.*;

@Configuration
public class GreetingServiceConfig {

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


    @Bean
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
