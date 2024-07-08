package net.chimaek.basic.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Helper {

  private final Helper helper;
  private final Test1 test1;
  private final Test2 test2;
  private final Test3 test3;

  public String hello() {
    System.out.println(this.helper);
    return "Hello, Spring Boot!";
  }
}
