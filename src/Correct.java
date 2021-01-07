import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static java.awt.BorderLayout.*;

public class Correct {
    private Player pl1;
    private Player pl2;
    private int number_rounds;      //from player
    private int number_questRound;  //from player
    private int roundCounter;       //from program
    private int questCounter;       //from program

    private JFrame frame;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;

    private JLabel label;

    private JLabel photo;
    private BufferedImage img;
    private ImageIcon icon;

    private String row_question;


    //##       for Answers
    private JLabel b1;


    private JLabel ans1;
    private JLabel ans2;
    private JLabel ans3;
    private JLabel ans4;

    private JButton button1;

    private JLabel round;
    private JLabel question;
    private JLabel points;

    //###

    public Correct(Player player1 , Player player2 , int number_rounds, int number_questRound) throws IOException, InterruptedException {
        //super();
        this.pl1 = player1;
        this.pl2 = player2;
        this.number_rounds = number_rounds;
        this.number_questRound = number_questRound;
        Call();
    }

    private void Call() throws IOException, InterruptedException {
        icon = new ImageIcon(ImageIO.read(new File("images/bg2.jpg")));
        photo = new JLabel(icon);
        photo.setSize(800 , 500);


        frame = new JFrame("Correct Answer");
        frame.add(photo);
        frame.setSize(800 , 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);


        if(pl2.getName() == "null") {
            GameSignle();
        }
        else {
            GameMulti();
        }

//        button1 = new JButton("koumpi 1");        //leitourgei
//        button1.setForeground(Color.WHITE);
//        button1.setBounds(100 , 100 , 50 , 50);
//
//        photo.add(button1);

        //Game();
    }

    private void GameSignle() throws InterruptedException {
//        row_question = "PRWTH ERWTHSHPRWTH ERWTHSHPRWTH ERWTHSH";
//        b1 = new JLabel();
//        b1.setText(row_question);
//        b1.setForeground(Color.WHITE);
//        b1.setBounds(395 - row_question.length()*4 , 10 , row_question.length()*10 , 20);
//        photo.add(b1);
//        System.out.println(row_question.length());


        //##########################
        round = new JLabel();
        question = new JLabel();
        points = new JLabel();

        frame.setVisible(true);
        Questions questions = new Questions();
        ArrayList<Question> roundQuestions;
        Question currentQuestion;

        roundCounter = 1;
        System.out.println("round");
        for(int i=0 ; i<number_rounds ; i++) {
            roundQuestions = questions.getQuestions(number_questRound);
            round.setText("Round: " + roundCounter);
            round.setBounds(360 , 200 , 200 , 30);
            round.setForeground(Color.WHITE);
            round.setFont(new Font("ROUND" , Font.PLAIN , 25));
            photo.add(round);
            TimeUnit.SECONDS.sleep(3);
            photo.remove(round);
            photo.updateUI();
            roundCounter ++;

            questCounter = 1;
            for(int j=0 ; j<number_questRound ; j++) {
                question.setText("Question: " + questCounter);
                question.setBounds(360 , 200 , 200 , 30);
                question.setForeground(Color.WHITE);
                question.setFont(new Font("QUEST" , Font.PLAIN , 25));
                photo.add(question);
                photo.updateUI();
                TimeUnit.SECONDS.sleep(3);
                photo.remove(question);
                photo.updateUI();
                questCounter ++;

                //points edw

                //######################

                currentQuestion = roundQuestions.get(j);


            }
        }

        //##########################

        //photo.setLayout(new BoxLayout(photo.getRootPane().getContentPane(), BoxLayout.Y_AXIS));


//        roundCounter = 1;
//        round = new JLabel();
//        round.setText("round: " + roundCounter);
//        round.setFont(new Font("Round" , Font.PLAIN , 40));
//        round.setForeground(Color.WHITE);
//        //round.setAlignmentX(Component.CENTER_ALIGNMENT);
//        //round.setBounds(390 , 250 , 400 , 50);
//        photo.add(round);
//
//        photo.updateUI();
//        System.out.println(roundCounter);

//        for(int i=0 ; i<5 ; i++) {
//            roundQuestions = questions.getQuestions(number_questRound);
//
//        }


        frame.setVisible(true);
    }

    private void GameMulti() {

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Player pl1 = new Player();
        Player pl2 = new Player();
        pl1.setName("george");
        pl2.setName("null");

        new Correct(pl1 , pl2 , 2 , 2);
    }
}
