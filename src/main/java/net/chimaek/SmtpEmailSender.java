package net.chimaek;

public class SmtpEmailSender implements EmailSender {

  @Override
  public void sendEmail(String to, String subject, String body) {
    System.out.println("Sending SMTP email to " + to);
  }
}
