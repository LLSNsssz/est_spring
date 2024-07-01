package net.chimaek.ex1;

public class Quiz {
  private String question;
  private String answer;

  public String getQuestion() {
    return question;
  }

  public String getAnswer() {
    return answer;
  }

  public Quiz(String question, String answer) {
    this.question = question;
    this.answer = answer;
  }
}
