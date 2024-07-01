package net.chimaek.ex1;

public class QuizController {
  private Quiz quiz;
  private QuizView quizView;

  public QuizController(Quiz quiz, QuizView quizView) {
    this.quiz = quiz;
    this.quizView = quizView;
  }

  public void startQuiz() {
    quizView.displayQuestion(quiz.getQuestion());
    String userAnswer = quizView.getUserAnswer();
    boolean isCorrect = checkAnswer(userAnswer);
    quizView.displayResult(isCorrect);
  }

  private boolean checkAnswer(String userAnswer) {
    return userAnswer.equalsIgnoreCase(quiz.getAnswer());
  }
}
