package test.spring5.spring_dep_injection.repositories;

public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository {

    @Override
    public String getGreeting() {
        return "Hello World - EN from repository";
    }
}
