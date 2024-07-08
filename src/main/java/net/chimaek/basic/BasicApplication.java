package net.chimaek.basic;

import jakarta.servlet.ServletException;
import java.io.IOException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication(
    scanBasePackages = "net.chimaek"
)
public class BasicApplication {

  public static void main(String[] args) throws ServletException, IOException {
    DispatcherServlet dispatcherServlet = new DispatcherServlet();
    String url = "/hello";

    MockHttpServletRequest request = new MockHttpServletRequest(url);
    MockHttpServletResponse response = new MockHttpServletResponse();

    dispatcherServlet.service(request, response);

    System.out.println(response.getContentType());
    System.out.println("응답 내용" + response.getContentType());
  }
}
