package test.spring5.spring_dep_injection.services;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    public SingletonBean(){
        System.out.println("Creating a Singleton bean!");
    }
    public String getMyScope(){
        return "I'm Singleton bean";
    }
}
