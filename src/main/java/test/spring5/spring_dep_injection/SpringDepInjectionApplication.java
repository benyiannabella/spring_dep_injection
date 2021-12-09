package test.spring5.spring_dep_injection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import test.spring5.spring_dep_injection.controllers.*;

import java.sql.SQLOutput;

@SpringBootApplication
public class SpringDepInjectionApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SpringDepInjectionApplication.class, args);

		MyController myController = (MyController)ctx.getBean("myController");
//		String greetings = myController.sayHello();
//		System.out.println(greetings);
		System.out.println("________Primary");
		System.out.println(myController.sayHello());

		System.out.println(" Profile annotation example - if same service bean name, use profile");
		I18nController i18nController =(I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		System.out.println("_______Property");
		PropertyInjectedController propertyInjectedController =
				(PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println(("_________Setter"));
		SetterInjectedController setterInjectedController =
				(SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("________Constructor");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());



	}

}
