import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Thermometer  {
    private JFrame f;
    private JPanel panel;
    private JButton u,i,o,p;

    Scanner console = new Scanner(System.in);
    private Player player;
    private int number_rounds;
    private int number_questions;
    private int pointpl1=0;
    private int pointpl2=0;


    public Thermometer (int numRounds, int numQuestions){
        //this.player = player;
        this.number_rounds = numRounds;
        this.number_questions = numQuestions;
        Game();
    }
    private void Game() {
        f=new JFrame("Welcome to Thermometer ");
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setSize(800,500);
        panel=new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setVisible(true);
        f.setVisible(true);

/**
 u= new JButton("singleplayer");
 panel.add(u);
 u.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
}
});

 i= new JButton("multiplayer");
 panel.add(i);
 i.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
}
});

 o= new JButton("multiplayer");
 panel.add(o);
 o.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
}
});

 p= new JButton("multiplayer");
 panel.add(p);
 p.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
}
});

 */
    Questions questions = new Questions();
    ArrayList<Question> roundQuestions;

    Scanner scanner = new Scanner(System.in);

    int currentAnswer;

    Question currentQuestion;

    int roundCounter = 1;
    int questionCounter;
    for (int i=0;i<number_rounds;i++){
        roundQuestions = questions.getQuestions(number_questions);
        roundCounter++;

        questionCounter = 1;
        for(int j=0 ; j<number_questions ; j++){
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
                break;
            }
        }
    }
    }
}
