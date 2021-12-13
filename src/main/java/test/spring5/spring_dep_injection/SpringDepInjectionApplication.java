package test.spring5.spring_dep_injection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import test.spring5.spring_dep_injection.controllers.*;
import test.spring5.spring_dep_injection.datasource.FakeDataSource;
import test.spring5.spring_dep_injection.services.PrototypeBean;
import test.spring5.spring_dep_injection.services.SingletonBean;

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

		System.out.println("_________Dog or Cat");
		PetController petController = (PetController) ctx.getBean("petController");
		System.out.println(petController.whichPetIsTheBest());

		System.out.println("Bean Scopes");

		SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getMyScope());
		SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getMyScope());

		PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getMyScope());
		PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean2.getMyScope());

		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUserName());
		System.out.println(fakeDataSource.getJdbcurl());
		System.out.println(fakeDataSource.getPassword());
	}

}

