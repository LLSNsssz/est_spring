package net.chimaek.ex1;

public class Main {
  public static void main(String[] args) {
    Quiz quiz = new Quiz("퀴즈", "Quiz");
    QuizView quizView = new QuizView();
    QuizController controller = new QuizController(quiz, quizView);
    controller.startQuiz();
  }
}
