import java.util.ArrayList;
import java.util.Scanner;

public class CorrectAnswer {
    private Player player;
    private int number_rounds;
    private int number_questRound;

    /**
     *
     * @param player
     * @param number_rounds
     * @param number_questRound
     */
    public CorrectAnswer(Player player, int number_rounds, int number_questRound) {
        this.player = player;
        this.number_rounds = number_rounds;
        this.number_questRound = number_questRound;
        Game();
    }

    private void Game() {
        Questions questions = new Questions();
        ArrayList<Question> roundQuestions;

        Scanner scanner = new Scanner(System.in);

        int currentAnswer;

        Question currentQuestion;

        int roundCounter = 1;
        int questionCounter;

        for(int i=0 ; i<number_rounds ; i++) {
            roundQuestions = questions.getQuestions(number_questRound);
            System.out.println("Round " + roundCounter);
            roundCounter++;

            questionCounter = 1;

            for(int j=0 ; j<number_questRound ; j++) {
                System.out.println("Question :" + questionCounter);
                System.out.print(player.getName() + "\'s points " + player.getPoints() + "\n");

                currentQuestion = roundQuestions.get(j);

                currentQuestion.printQuestion();
                currentQuestion.printAnswers();

                System.out.println("Give an answer : ");
                currentAnswer = scanner.nextInt();

                if(currentAnswer == currentQuestion.getCorrectAnswer()) {
                    player.addPoints(1000);
                }
                else {
                    player.addPoints(-1000);
                }
                questionCounter++;
            }
        }
        //scanner.close();
        System.out.println("Your scor : " + player.getPoints());

    }
}