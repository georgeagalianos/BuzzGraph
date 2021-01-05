import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Stopwatch {
    public Player pl1;
    public Player pl2;

    private JFrame Stopwatch;
    private JPanel panel;

    private JButton answer1;
    private JButton answer2;
    private JButton answer3;
    private JButton answer4;

    private JLabel question;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;

    private JLabel rowRounds;
    private JLabel rowQuestion;
    private JLabel CurrentName;
    private JLabel Points1;

    private BufferedImage img;
    private JLabel image;

    private String row_question;
    private int number_rounds;
    private int number_questRound;
    private int currentAnswer;
    private int roundCounter;
    private int questionCounter;


    public Stopwatch(Player p1 , Player p2 , int numRounds , int questRounds) throws IOException, InterruptedException {
        this.pl1 = p1;
        this.pl2 = p2;
        this.number_rounds = numRounds;
        this.number_questRound = questRounds;

        Game();
    }


    private void Game () throws IOException, InterruptedException {

        //################################ Κυριο Frame ####################
        Stopwatch = new JFrame("Game mode : Stopwatch");
        Stopwatch.setDefaultCloseOperation(Stopwatch.EXIT_ON_CLOSE);
        Stopwatch.setResizable(false);
        Stopwatch.setSize(800 , 500);

        //################################################################

        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        image = new JLabel();
        //image.setLayout(new FlowLayout(FlowLayout.CENTER));

        //################################# Φορτωση εικονας ##############
        img = ImageIO.read(new File("images/bg2.jpg"));
        ImageIcon icon = new ImageIcon(img);
        image.setIcon(icon);
        panel.add(image);
        Stopwatch.add(panel);

        //################################################################

        //############################### Labels #########################
//        GameSingle();
        question = new JLabel("erwthsh");  //Ερωτηση
        label1 = new JLabel();  //Απαντηση
        label2 = new JLabel();  //Απαντηση
        label3 = new JLabel();  //Απαντηση
        label4 = new JLabel();  //Απαντηση

        //################################################################


        if(pl2.getName() == "null") {
            GameSingle();
        }
        else {
            GameMulti();
        }

        Stopwatch.setVisible(true);
        panel.setVisible(true);

    }

    private void GameSingle() throws InterruptedException {

        image.setLayout(null);

        Questions questions = new Questions();
        ArrayList<Question> roundQuestions;
        Question currentQuestion;

        roundCounter = 1;
        questionCounter = 1;
        rowRounds = new JLabel();
        rowQuestion = new JLabel();
        CurrentName = new JLabel();
        Points1 = new JLabel();

        CurrentName.setText("Name: " + pl1.getName());
        CurrentName.setForeground(Color.GRAY);
        CurrentName.setBounds(380 , 10 , 80 , 20);
        image.add(CurrentName);

        for(int i=0 ; i<number_rounds ; i++) {
            rowRounds.setText("Round : " + roundCounter);
            rowRounds.setForeground(Color.GRAY);
            rowRounds.setBounds(100 , 10 , 80 , 20);



            image.add(rowRounds);
            roundCounter ++;
            roundQuestions = questions.getQuestions(number_questRound);

            for(int j=0 ; j<number_questRound ; j++) {
                rowQuestion.setText("Question: " +questionCounter);
                rowQuestion.setForeground(Color.GRAY);
                rowRounds.setBounds(320 , 10 , 80 , 20);
                image.add(rowRounds);

                Points1.setText("Points" + pl1.getPoints());
                Points1.setForeground(Color.GRAY);
                Points1.setBounds(370 , 250 , 100 , 20);
                Points1.setFont(new Font("Serif", Font.PLAIN, 30));
                image.add(Points1);
                TimeUnit.SECONDS.sleep(3);
                image.remove(Points1);

                currentQuestion = roundQuestions.get(j);



            }

        }



        row_question = "ERWTHSH";  //erwthsh apo arraylist (Quesiton)
        question.setText(row_question);
        question.setBounds(400 - row_question.length()*6 , 30 , row_question.length()*100 , 20);
        question.setFont(new Font("Serif", Font.PLAIN, 20));
        question.setForeground(Color.GRAY);

        image.add(question);





        System.out.println(Stopwatch.getWidth());


        label1 = new JLabel("APANTHSH 1");
        image.setFont(null);
        image.setLayout(null);
        label1.setBounds(100 , 200 , 150 , 30);

        //label1.setFont(new Font("ans1" , Font.PLAIN , 15));
        image.add(label1);

        label2 = new JLabel("APANTHSH 2");
        label3 = new JLabel("APANTHSH 3");
        label4 = new JLabel("APANTHSH 4");




    }

    private void GameMulti() {



    }

    private void KeyPressed(KeyEvent e) {

    }

}
