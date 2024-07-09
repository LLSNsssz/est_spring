package net.chimaek.basic;

import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BasicApplicationTests {
    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.application.name}")
    private String applicationName;

    @PostConstruct
    public void printConfig() {
        System.out.println("포트번호: " + serverPort);
        System.out.println("애플리케이션 이름: " + applicationName);
    }

    @Test
    void main() {
        printConfig();
    }

}
