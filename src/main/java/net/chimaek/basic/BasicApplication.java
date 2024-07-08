package net.chimaek.basic;

import net.chimaek.basic.service.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
    scanBasePackages = "net.chimaek"
)
public class BasicApplication {

  public static void main(String[] args) {

    MyService myService = new MyService();
    myService.hello();
    SpringApplication.run(BasicApplication.class, args);
  }

}
