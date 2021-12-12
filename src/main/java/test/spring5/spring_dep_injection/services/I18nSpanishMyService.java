package test.spring5.spring_dep_injection.services;

public class I18nSpanishMyService implements MyService{

    @Override
    public String sayGreeting() {
        return "Hola mundo - ES";
    }
}
