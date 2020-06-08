package jpaTraining;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;

public class Application {

    public static void main(String[] args) {

	AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
	myContext.getBeanFactory().createBean(MyApp.class).run();
	myContext.close();

    }
}
