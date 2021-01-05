import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Thermometer  {
    /**
     private JFrame f;
     private JPanel panel;
     private JFrame frame;
     private JButton button1,button2;
     private JButton u,i,o,p;
     private JTextField pl1,pl2;
     */
    Scanner console = new Scanner(System.in);
    private Player player;
    private int number_rounds;
    private int number_questions;

    private int pointpl1=0;
    private int pointpl2=0;


    public Thermometer (int numRounds, int numQuestions)throws IOException {
        //this.player = player;
        this.number_rounds = numRounds;
        this.number_questions = numQuestions;
//        single();
        multi();
    }


    private void Game (){
/**
 f=new JFrame("Welcome to Thermometer ");
 f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
 f.setResizable(false);
 f.setSize(800,500);
 panel=new JPanel();
 panel.setLayout(new FlowLayout(FlowLayout.CENTER));
 */

    }
    private void single(){

        Questions questions = new Questions();
        ArrayList<Question> roundQuestions;

        Scanner scanner = new Scanner(System.in);

        int currentAnswer;
        JComponent component=null;

        Question currentQuestion;
        int flag=1;
        int roundCounter = 1;
        int questionCounter;
        for (int i=0;i<number_rounds && flag==1;i++){
            roundQuestions = questions.getQuestions(number_questions);
            roundCounter++;
            questionCounter = 1;
            for(int j=0 ; j<number_questions && flag==1; j++){
                System.out.println("Question :" + questionCounter);


                currentQuestion = roundQuestions.get(j);
                currentQuestion.printCategory();
                currentQuestion.printQuestion();
                currentQuestion.printAnswers();
                System.out.println("Give an answer : ");
                currentAnswer = scanner.nextInt();


                if(currentAnswer == currentQuestion.getCorrectAnswer()) {

                    pointpl1++;
                }
                if (pointpl1==5){
                    player.addPoints(5000);
                    System.out.println("You  Win ");
                    flag=0;
                }
            }
        }
        if (flag==1);
        {
            System.out.println("You did not win");
        }
        if (flag==0)
        {
            System.out.println("You  Win ");
        }

    }

    private void multi(){
        Questions questions = new Questions();
        ArrayList<Question> roundQuestions;

        Scanner scanner = new Scanner(System.in);

        int flag1=1,flag2=1,temp;
        int first,second;
        JComponent component=null;

        Question currentQuestion;

        int roundCounter = 1;
        int questionCounter;
        for (int i=0;i<number_rounds && flag1==1 && flag2==1;i++){
            roundQuestions = questions.getQuestions(number_questions);
            roundCounter++;
            questionCounter = 1;
            for(int j=0 ; j<number_questions && flag1==1 && flag2==1; j++){
                System.out.println("Question :" + questionCounter);


                currentQuestion = roundQuestions.get(j);
                currentQuestion.printCategory();
                currentQuestion.printQuestion();
                currentQuestion.printAnswers();
                System.out.println("Give an answer : ");
                first = scanner.nextInt();
                second = scanner.nextInt();

                if (first==1 ||first==2 || first==3 || first==4)
                {
                    temp=0;
                    if (first==1){
                        temp=1;
                    }
                    if(first==2){
                        temp=2;
                    }
                    if(first==3){
                        temp=3;
                    }
                    if(first==4){
                        temp=4;
                    }
                    if(temp== currentQuestion.getCorrectAnswer()) {
                        pointpl1++;
                    }
                }

                if (first==6 ||first==7 || first==8 || first==9)
                {
                    temp=0;
                    if (first==6){
                        temp=1;
                    }
                    if(first==7){
                        temp=2;
                    }
                    if(first==8){
                        temp=3;
                    }
                    if(first==9){
                        temp=4;
                    }

                    if(temp== currentQuestion.getCorrectAnswer()) {
                        pointpl2++;
                    }
                }

                if (pointpl1==5){
                    //player.addPoints(5000);
                    System.out.println("You  win Player1");
                    flag1=0;
                }

                if (pointpl2==5){
                    //player.addPoints(5000);
                    System.out.println("You  win Player2");
                    flag2=0;
                }
            }
        }
        if (flag1==1);
        {
            System.out.println("You did not win Player1");
        }

        if (flag2==1);
        {
            System.out.println("You did not win Player2");
        }
    }
}

