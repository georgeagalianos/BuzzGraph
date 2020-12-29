import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CorrectAnswer{
    private Player player;
    private int number_rounds;
    private int number_questRound;

    private JFrame frame;
    private JPanel panel;

    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;

    private JLabel label;


    /**
     *
     * @param player
     * @param number_rounds
     * @param number_questRound
     */
    public CorrectAnswer(Player player, int number_rounds, int number_questRound) throws IOException {
        //super();
        this.player = player;
        this.number_rounds = number_rounds;
        this.number_questRound = number_questRound;
        Call();
    }

    private void Call() {
        frame = new JFrame();
        frame = new JFrame("Επιλογη παικτων");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(800,500);



        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(Color.CYAN);
        frame.add(panel , BorderLayout.CENTER);
        //super.frameReturn().add(panel , BorderLayout.CENTER);

        b1 = new JButton();
        b2 = new JButton();
        b3 = new JButton();
        b4 = new JButton();

        label = new JLabel();

        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(label);

        //frame.setVisible(true);
        //panel.setVisible(true);
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