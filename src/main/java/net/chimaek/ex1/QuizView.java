package net.chimaek.ex1;

import java.util.Scanner;

public class QuizView {

  public void displayQuestion(String question) {
    System.out.println("문제: " + question);
  }

  public String getUserAnswer() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("답변: ");
    return scanner.nextLine();
  }

  public void displayResult(boolean isCorrect) {
    if (isCorrect) {
      System.out.println("정답입니다!");
    } else {
      System.out.println("오답입니다.");
    }
  }
}
