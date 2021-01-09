import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.util.concurrent.TimeUnit;

public class BET  {
    Scanner console = new Scanner(System.in);
    private Player player;
    private final int number_rounds,number_questions,points=0;
    private int bider,currentAnswer,roundCounter,questionCounter,keybet,keysingl,key2;

    private String currentQ;

    private Question currentQuestion;
    private ArrayList<String> answers;

    private boolean flag1,flag2;

    private JFrame frame;

    private JLabel photo,round,question,lbet,bet1,bet2,bet3,bet4,ans1,ans2,ans3,ans4,CorrectA,row_question,score;

    private ImageIcon img;

    public BET(Player player, int numRounds, int numQuestions)throws IOException,InterruptedException{
        this.player = player;
        this.number_rounds = numRounds;
        this.number_questions = numQuestions;
        Call();
    }

    private void Call() throws IOException,InterruptedException {
        frame = new JFrame("BET");
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(800, 500);

        img = new ImageIcon(ImageIO.read(new File("img.jpg")));
        photo = new JLabel(img);
        photo.setSize(800 , 500);
        frame.add(photo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        round = new JLabel();
        question = new JLabel();
        lbet = new JLabel();
        bet1=new JLabel();
        bet2=new JLabel();
        bet3=new JLabel();
        bet4=new JLabel();
        ans1=new JLabel();
        ans2=new JLabel();
        ans3=new JLabel();
        ans4=new JLabel();
        score=new JLabel();

        CorrectA=new JLabel();

        frame.setVisible(false);
        answers = new ArrayList<>();
        row_question = new JLabel();
        Questions questions = new Questions();
        ArrayList<Question> roundQuestions;

        Game();
    }


    private void Game()throws InterruptedException {
        Questions questions = new Questions();
        ArrayList<Question> roundQuestions;

        roundCounter = 1;
        System.out.println("round");
        for(int i=0 ; i<number_rounds ; i++) {
            roundQuestions = questions.getQuestions(number_questions);

            frame.setVisible(true);
            //###############EMFANISEI ROUND##########################
            round.setText("Round: " + roundCounter);
            round.setBounds(360 , 20 , 200 , 30);
            round.setForeground(Color.BLACK);
            round.setFont(new Font("ROUND" , Font.PLAIN , 25));
            photo.add(round);
            TimeUnit.SECONDS.sleep(3);
            photo.updateUI();
            roundCounter ++;
            //###############################################
            int questCounter = 1;
            for(int j=0 ; j<number_questions ; j++) {

                //#####################BET#################################################
                flag1 = false;
                flag2 = false;
                //###############EMFANIzEI ARITHMO ERVTHSEIS##########################
                question.setText("Question: " + questionCounter);
                question.setBounds(350 , 50 , 200 , 30);
                question.setForeground(Color.black);
                question.setFont(new Font("QUEST" , Font.PLAIN , 25));
                photo.add(question);
                photo.updateUI();
                photo.remove(question);photo.updateUI();
                questionCounter ++;
                //###############################################
                //###################DIEYKRINISEIS################
                lbet.setText("YOU HAVE FOR BATE:");
                lbet.setBounds(330,170,800,50);
                lbet.setFont(new Font("" , Font.PLAIN , 22));
                lbet.setForeground(Color.black);
                photo.add(lbet);
                photo.updateUI();

                bet1.setText("1=250" );
                bet1.setBounds(350 , 210 , 300 , 30);
                bet1.setForeground(Color.BLACK);
                bet1.setFont(new Font("BET" , Font.PLAIN , 20));
                photo.add(bet1);

                bet2.setText("2=500 ");
                bet2.setBounds(450 , 210 , 300 , 30);
                bet2.setForeground(Color.black);
                bet2.setFont(new Font("BET" , Font.PLAIN , 20));
                photo.add(bet2);

                bet3.setText("3=750 ");
                bet3.setBounds(350 , 260 , 300 , 30);
                bet3.setForeground(Color.black);
                bet3.setFont(new Font("BET" , Font.PLAIN , 20));
                photo.add(bet3);

                bet4.setText("4=1000 ");
                bet4.setBounds(450 , 260 , 300 , 30);
                bet4.setForeground(Color.black);
                bet4.setFont(new Font("BET" , Font.PLAIN , 20));
                photo.add(bet4);
                photo.updateUI();
                TimeUnit.SECONDS.sleep(1);
//                photo.remove(bet1);
//                photo.remove(bet2);
//                photo.remove(bet3);
//                photo.remove(bet4);
 //               photo.remove(lbet);
 //               photo.updateUI();
                //####################################################
                //##################BET###############################
                //while (flag1==false){
                //do{
                keybet=0;
                frame.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {}
                    public void keyPressed(KeyEvent e) {
                        keybet = e.getKeyCode();
                    }
                    @Override
                    public void keyReleased(KeyEvent e) {}
                });
                while (keybet == 0 ) {
                    TimeUnit.SECONDS.sleep(1);
                }
                photo.remove(bet1);
                photo.remove(bet2);
                photo.remove(bet3);
                photo.remove(bet4);
                photo.remove(lbet);
                photo.updateUI();
                if (keybet==49) {
                    player.setBid(250);
                }
                else if (keybet==50) {
                    player.setBid(500);
                }
                else if (keybet==51) {
                    player.setBid(750);
                }
                else
                if(keybet==52) {
                    player.setBid(1000);
                }
                //}//while (key2!=0);
                //#######################################
                //######################################################################

                //###################ERVTHSHS KAI APANTHSEIS####################
                currentQuestion = roundQuestions.get(j);
                String currentQ = currentQuestion.printQuestion();
                answers = currentQuestion.printAnswers();

                row_question.setText(currentQuestion.printQuestion());
                row_question.setBounds(390 - currentQ.length()*6 , 100 , 800 , 30);
                row_question.setForeground(Color.CYAN);
                row_question.setFont(new Font("QUEST" , Font.PLAIN , 25));
                photo.add(row_question);

                ans1.setText("1: " + answers.get(0));
                ans1.setBounds(150 , 210 , 300 , 30);
                ans1.setForeground(Color.CYAN);
                ans1.setFont(new Font("ANS" , Font.PLAIN , 20));
                photo.add(ans1);

                ans2.setText("2: " + answers.get(1));
                ans2.setBounds(500 , 210 , 300 , 30);
                ans2.setForeground(Color.CYAN);
                ans2.setFont(new Font("ANS" , Font.PLAIN , 20));
                photo.add(ans2);

                ans3.setText("3: " + answers.get(2));
                ans3.setBounds(150 , 260 , 300 , 30);
                ans3.setForeground(Color.CYAN);
                ans3.setFont(new Font("ANS" , Font.PLAIN , 20));
                photo.add(ans3);

                ans4.setText("4: " + answers.get(3));
                ans4.setBounds(500 , 260 , 300 , 30);
                ans4.setForeground(Color.CYAN);
                ans4.setFont(new Font("ANS" , Font.PLAIN , 20));
                photo.add(ans4);
                photo.updateUI();
                TimeUnit.SECONDS.sleep(1);
//                photo.remove(ans1);
//                photo.remove(ans2);
//                photo.remove(ans3);
//                photo.remove(ans4);
//                photo.remove(row_question);
//                photo.updateUI();
                keysingl=0;
                key2=0;
                frame.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {}
                    @Override
                    public void keyPressed(KeyEvent e) {
                        keysingl = e.getKeyCode();
                        System.out.println(keysingl);
                    }
                    @Override
                    public void keyReleased(KeyEvent e) {}
                });
                while (keysingl == 0 ) {
                    TimeUnit.SECONDS.sleep(1);
                }
                photo.remove(ans1);
                photo.remove(ans2);
                photo.remove(ans3);
                photo.remove(ans4);
                photo.remove(row_question);
                photo.updateUI();
                key2=keysingl-48;
                System.out.println(key2);
                if(key2 == currentQuestion.getCorrectAnswer()) {
                    player.addPoints(player.getBid());
                }

                if(currentAnswer == currentQuestion.getCorrectAnswer()) {
                    player.addPoints(player.getBid());
                }
                else if(key2 != currentQuestion.getCorrectAnswer()) {
                    player.addPoints(-player.getBid());
                }
                //##################################################################################
            }
            photo.removeAll();
            photo.updateUI();

        }
        score.setText("Your scor:" + player.getPoints());
        score.setBounds(350 , 200 , 200 , 30);
        score.setForeground(Color.black);
        score.setFont(new Font("SCORE" , Font.PLAIN , 25));
        photo.add(score);
        photo.updateUI();
        TimeUnit.SECONDS.sleep(5);
        photo.remove(score);
        photo.updateUI();
        System.out.println("Your scor : " + player.getPoints());
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        Player pl1 = new Player();
        pl1.setName("george");
        new BET(pl1 ,1 , 3);
    }

}
