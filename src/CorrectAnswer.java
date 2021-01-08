import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CorrectAnswer{
    private Player pl1;
    private Player pl2;
    private int number_rounds;
    private int number_questRound;

    private JFrame frame;
    private JPanel panel;

    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JLabel label;

    private JLabel photo;

    private BufferedImage img;


    /**
     *
     * @param player1
     * @param number_rounds
     * @param number_questRound
     */
    public CorrectAnswer(Player player1 , Player player2 , int number_rounds, int number_questRound) throws IOException {
        //super();
        this.pl1 = player1;
        this.pl2 = player2;
        this.number_rounds = number_rounds;
        this.number_questRound = number_questRound;
        Call();
    }

    private void Call() throws IOException {
        frame = new JFrame();
        frame = new JFrame("Επιλογη παικτων");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(800,500);



        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.add(panel , BorderLayout.CENTER);



        b1 = new JButton("xaxaxaxa");
        b2 = new JButton();
        b3 = new JButton();
        b4 = new JButton();


        //####
        photo = new JLabel();

        img = ImageIO.read(new File("images/bg2.jpg"));
        ImageIcon icon = new ImageIcon(img);
        photo.setIcon(icon);
        panel.add(photo);
        frame.add(panel);

        //####

        photo.add(b1);
        label = new JLabel("xaxaxa");
        frame.add(label);
//        photo.add(b2);
//        photo.add(b3);
//        photo.add(b4);


        frame.setVisible(true);
        panel.setVisible(true);
        photo.setVisible(true);
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
                System.out.print(pl1.getName() + "\'s points " + pl1.getPoints() + "\n");

                currentQuestion = roundQuestions.get(j);

                currentQuestion.printQuestion();
                currentQuestion.printAnswers();

                System.out.println("Give an answer : ");
                currentAnswer = scanner.nextInt();

                if(currentAnswer == currentQuestion.getCorrectAnswer()) {
                    pl1.addPoints(1000);
                }
                else {
                    pl1.addPoints(-1000);
                }
                questionCounter++;
            }
        }
        //scanner.close();
        System.out.println("Your scor : " + pl1.getPoints());

    }
}