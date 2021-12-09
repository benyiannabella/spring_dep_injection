package test.spring5.spring_dep_injection.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"ES", "default"})
@Service("I18nService")
public class I18nSpanishMyService implements MyService{

    @Override
    public String sayGreeting() {
        return "Hola mundo - ES";
    }
}
