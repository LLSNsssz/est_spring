package net.chimaek.basic;

import jakarta.annotation.PostConstruct;
import java.util.TimeZone;
import net.chimaek.day0709.ValueTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
    scanBasePackages = "net.chimaek.day0715"
)
public class BasicApplication {

    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.application.name}")
    private String applicationName;

    @PostConstruct
    public void printConfig() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
        System.out.println("포트번호: " + serverPort);
        System.out.println("애플리케이션 이름: " + applicationName);
    }


    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
    }
}
