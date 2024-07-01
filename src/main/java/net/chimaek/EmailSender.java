package net.chimaek;

public interface EmailSender {
  void sendEmail(String to, String subject, String body);
}
