package net.chimaek.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicApplication {

  public static void main(String[] args) {
    Singleton singleton1 = Singleton.getInstance();
    System.out.println("singleton1 = " + singleton1);
    Singleton singleton2 = Singleton.getInstance();
    System.out.println("singleton2 = " + singleton2);
    Singleton singleton3 = Singleton.getInstance();
    System.out.println("singleton3 = " + singleton3);

//    SpringApplication.run(BasicApplication.class, args);
  }
}
