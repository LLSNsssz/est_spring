package net.chimaek;

import net.chimaek.basic.Singleton;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BasicApplication {

  public static void main(String[] args) {
    BeanFactory beanFactory = new AnnotationConfigApplicationContext(ObjectFactory.class);
    EmailService emailService = beanFactory.getBean(EmailService.class);

    emailService.sendEmail("me", "example", "body");

//    SpringApplication.run(BasicApplication.class, args);
  }
}
