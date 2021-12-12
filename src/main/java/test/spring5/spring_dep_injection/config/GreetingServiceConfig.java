package test.spring5.spring_dep_injection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.spring5.spring_dep_injection.services.ConstructorMyService;
import test.spring5.spring_dep_injection.services.PropertyInjectedGreetingService;
import test.spring5.spring_dep_injection.services.SetterInjectedMyService;

@Configuration
public class GreetingServiceConfig {

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
