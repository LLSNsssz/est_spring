package net.chimaek;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectFactory {

  @Bean
  public EmailService emailService() {
    return new EmailService(smtpEmailSender());
  }

  @Bean
  public EmailSender smtpEmailSender() {
    return new SmtpEmailSender();
  }
}
