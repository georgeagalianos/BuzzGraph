import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;
import java.util.concurrent.TimeUnit;

public class Thermometer  {
    Scanner console = new Scanner(System.in);
    private Player player;
    private final int number_rounds,number_questions,points=0;
    private Player player1,player2;
    private int flag,bider,currentAnswer,roundCounter,questCounter,questionCounter,keyfirst,keysecond,pointpl1, pointpl2,k1,k2,flag1=1,flag2=1;

    private String currentQ;

    private Question currentQuestion;
    private ArrayList<String> answers;


    private JFrame frame;

    private JLabel photo,round,question,ans1,ans2,ans3,ans4,row_question,control1,control2,score1,score2,label1,label2,l1;

    private ImageIcon img;

    public Thermometer (Player player1,Player player2,int numRounds, int numQuestions)throws IOException,InterruptedException{
        this.player1 = player1;
        this.player2 = player2;
        this.number_rounds = numRounds;
        this.number_questions = numQuestions;
//        single();
//        multi();
        Call();
    }
    /**
     * Ολα τα γραφικα εχουν υλοποιηθει με ενα frame και αρκετα label χωρις να χρησιμοποιηθει κανενα panel
     * @throws InterruptedException
     */
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
        ans1=new JLabel();
        ans2=new JLabel();
        ans3=new JLabel();
        ans4=new JLabel();
        score1=new JLabel();
        score2=new JLabel();
        control1=new JLabel();
        control2=new JLabel();
        label1=new JLabel();
        label2=new JLabel();

        l1=new JLabel();

        frame.setVisible(false);
        answers = new ArrayList<>();
        row_question = new JLabel();
        Questions questions = new Questions();
        ArrayList<Question> roundQuestions;

        Game();
        //Gamesingl();
        //Gamemulti();
    }

    private void Game()throws IOException,InterruptedException {
        Questions questions = new Questions();
        ArrayList<Question> roundQuestions;
        roundCounter = 1;
        /**
         * Εμφανιση των πληκτρων του καθε παιχτη
         */
        //#####################CONTROLER######################
        frame.setVisible(true);
        label1.setText("THE FASTER WINNER");
        label1.setBounds(350, 190, 200, 30);
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("CONTROL", Font.PLAIN, 17));
        photo.add(label1);
        photo.updateUI();
        TimeUnit.SECONDS.sleep(2);
        photo.remove(label1);
        photo.updateUI();

        control1.setText("CONTROL PL1:1 2 3 4");
        control1.setBounds(350, 190, 200, 30);
        control1.setForeground(Color.BLACK);
        control1.setFont(new Font("CONTROL", Font.PLAIN, 17));
        photo.add(control1);
        photo.updateUI();

        control2.setText("CONTROL PL2:6 7 8 9");
        control2.setBounds(350, 220, 200, 30);
        control2.setForeground(Color.BLACK);
        control2.setFont(new Font("CONTROL", Font.PLAIN, 17));
        photo.add(control2);

        TimeUnit.SECONDS.sleep(3);
        photo.updateUI();
        photo.remove(control1);
        photo.remove(control2);
        photo.updateUI();
        //####################################################

        pointpl1 = 0;
        pointpl2 = 0;
        flag = 1;
        for (int i = 0; i < number_rounds; i++) {
            roundQuestions = questions.getQuestions(number_questions);
            frame.setVisible(true);
            /**
             * Εμφανιση του γυρου που βρισκομαστε,ο οποιος συνεχιζει να  παραμενει πανω για καλητερη κατανοησει μεχρι
             *να τελειωσει το παιχνιδι.
             */
            //###############EMFANISEI ROUND##########################
            round.setText("Round: " + roundCounter);
            round.setBounds(360, 20, 200, 30);
            round.setForeground(Color.BLACK);
            round.setFont(new Font("ROUND", Font.PLAIN, 25));
            photo.add(round);
            photo.updateUI();
            TimeUnit.SECONDS.sleep(2);
            roundCounter++;
            //###############################################
            questCounter = 1;
            for (int j = 0; j < number_questions; j++) {
                /**
                 * Εμφανιση του αριθμου της ερωτησεις η οποια παραμενει πανω μεχρι να τελειωσει το παιχνιδι ,για
                 *καλυτερη κατανοησει του παιχνιδιου
                 */
                //###############EMFANIzEI ARITHMO ERVTHSEIS##########################
                question.setText("Question: " + questCounter);
                question.setBounds(350, 50, 200, 30);
                question.setForeground(Color.black);
                question.setFont(new Font("QUEST", Font.PLAIN, 25));
                photo.add(question);
                photo.updateUI();
                TimeUnit.SECONDS.sleep(2);
                //photo.remove(question);
                //photo.updateUI();
                questCounter++;
                //###############################################
                currentQuestion = roundQuestions.get(j);
                String currentQ = currentQuestion.printQuestion();
                answers = currentQuestion.printAnswers();

                /**
                 * Εμφανιση των ερωτησεων και των πιθανων απαντησεων που εχουν επιλεχθει ωστε να επιλεχθει η σωστη
                 */
                row_question.setText(currentQuestion.printQuestion());
                row_question.setBounds(390 - currentQ.length() * 6, 100, 800, 30);
                row_question.setForeground(Color.CYAN);
                row_question.setFont(new Font("QUEST", Font.PLAIN, 25));
                photo.add(row_question);

                ans1.setText("" + answers.get(0));
                ans1.setBounds(150, 210, 300, 30);
                ans1.setForeground(Color.CYAN);
                ans1.setFont(new Font("ANS", Font.PLAIN, 20));
                photo.add(ans1);

                ans2.setText("" + answers.get(1));
                ans2.setBounds(500, 210, 300, 30);
                ans2.setForeground(Color.CYAN);
                ans2.setFont(new Font("ANS", Font.PLAIN, 20));
                photo.add(ans2);

                ans3.setText("" + answers.get(2));
                ans3.setBounds(150, 260, 300, 30);
                ans3.setForeground(Color.CYAN);
                ans3.setFont(new Font("ANS", Font.PLAIN, 20));
                photo.add(ans3);

                ans4.setText("" + answers.get(3));
                ans4.setBounds(500, 260, 300, 30);
                ans4.setForeground(Color.CYAN);
                ans4.setFont(new Font("ANS", Font.PLAIN, 20));
                photo.add(ans4);
                photo.updateUI();
                /**
                 * Δυο KEYLISTENER ωστε να παιρνωνται οι απαντησεις απο τους παιχτες,ενω με δυο while ελενχουμε αν εχει
                 * πληκτρολογηθει απο τον χρηστη καποια απαντηση.
                 */
                keyfirst = 0;
                frame.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {}
                    @Override
                    public void keyPressed(KeyEvent e) {
                        keyfirst = e.getKeyCode();
                        //System.out.println(keyfirst);
                    }
                    @Override
                    public void keyReleased(KeyEvent e) {}
                });
                while (keyfirst == 0) {
                    TimeUnit.SECONDS.sleep(1);
                }
                System.out.println(keyfirst);
                k1=keyfirst-48;
                keysecond = 0;
                frame.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {}
                @Override
                public void keyPressed(KeyEvent e) {
                    keysecond = e.getKeyCode();
                    //System.out.println(keysecond);
                }
                @Override
                public void keyReleased(KeyEvent e) {}
                });
                while (keysecond == 0) {
                    TimeUnit.SECONDS.sleep(1);
                }
                System.out.println(keysecond);
                k2=keysecond-48;
                photo.remove(ans1);
                photo.remove(ans2);
                photo.remove(ans3);
                photo.remove(ans4);
                photo.remove(row_question);
                //################################KEYFIRST################################
                /**
                 *Η εντολη ελενχου IF χρησιμοποιειται για να:
                 *Οι εξωτερικες εντολες IF ελενχουν σε ποιον παιχτη ανηκει η πιο γρηγορη απαντηση
                 *Η πρωτη εμφωλευμενη IF ελενχει αν η απαντηση που δοθηκε απο τον χρηστη αν ειναι η σωστη
                 *Ενω η δευτερη εμφωλευμενη IF ελενχει αν καποιος απα τους δυο παιχτες (που απαντησε πρωτος σωστα)
                 *εφτασε πρωτος τις 5 σωστες απαντησεις ωστε να τελειωσει το παιχνιδι και αυτο επιτυνχανεται με την
                 *εντολη break
                 */
                if (k1==1 || k1==2 || k1==3 || k1==4){
                    if (k1== currentQuestion.getCorrectAnswer()) {
                        pointpl1++;
                    }
                    if (pointpl1==5) {
                        player1.addPoints(5000);
                        System.out.println("You  win Player1");
                        flag1=0;
                        break;
                    }
                }
                if (k1==6 || k1==7 || k1==8 || k1==9) {
                    if (k2-5 == currentQuestion.getCorrectAnswer()) {
                        pointpl2++;
                    }
                    if (pointpl2==5) {
                        player2.addPoints(5000);
                        System.out.println("You  win Player2");
                        flag2 = 0;
                        break;
                    }
                }
                //#######################################################################
                //##############################KEYSECOND#################################
                /**
                 * Η εντολη ελενχου IF χρησιμοποιειται για να:
                 * Οι εξωτερικες εντολες IF ελενχουν απο ποιον παιχτη δοθηκε η δευτερη απαντησει
                 * Η πρωτη εμφωλευμενη IF ελενχει αν η απαντηση που δοθηκε απο τον χρηστη αν ειναι η σωστη
                 * Ενω η δευτερη εμφωλευμενη IF ελενχει αν καποιος απα τους δυο παιχτες εφτασε πρωτος τις 5 σωστες
                 * απαντησεις ωστε να τελειωσει το παιχνιδι και αυτο επιτυνχανεται με την
                 * εντολη break
                 */

                if (k2==1|| k2==2 || k2==3 || k2==4) {
                    if (k2==currentQuestion.getCorrectAnswer()) {
                        pointpl1++;
                    }
                    if (pointpl1==5) {
                        player2.addPoints(5000);
                        System.out.println("You  win Player1");
                        flag1 = 0;
                        break;
                    }
                }
                if (k2==6 || k2==7 || k2==8 || k2==9) {
                    if (k2-5==currentQuestion.getCorrectAnswer()) {
                        pointpl2++;
                    }
                    if (pointpl2==5) {
                        player2.addPoints(5000);
                        System.out.println("You  win Player2");
                        flag2 = 0;
                        break;
                    }
                }
                //################################################################################
            }
            photo.remove(question);
            photo.updateUI();
        }
        photo.removeAll();
        photo.updateUI();
        /**
         * Ελεχνω ποιος απο τους δυο παιχτες ειναι ο νικητης με τις βοηθητικες μεταβλητες flag,οι οποιες ειναι
         * αρχικοποιημενες με την τιμη 1 και παιρνουν την τιμη 0 οταν τουλαχιστον ενας απο τους δυο παιχτες φτασει
         * τις 5 σωστες απαντησεις.Η τιμη 0 παιρνεται Πριν την τερματικη εντολη break
         *Ενω αν δεν νικησει κανενας απο τους δυο τοτε εμφανιζεται καταλληολο μυνημα
         */
        if (flag1 == 0 ) {
            label1.setText(player1.getName() + " scor:" + player1.getPoints());
            label1.setBounds(350, 200, 200, 30);
            label1.setForeground(Color.black);
            label1.setFont(new Font("SCORE", Font.PLAIN, 20));
            photo.add(label1);
            photo.updateUI();
            TimeUnit.SECONDS.sleep(5);
            photo.remove(label1);
            photo.updateUI();
        }else if (flag2 == 0 ) {
            label2.setText(player2.getName() + " scor:" + player2.getPoints());
            label2.setBounds(350, 200, 200, 30);
            label2.setForeground(Color.black);
            label2.setFont(new Font("SCORE", Font.PLAIN, 20));
            photo.add(label2);
            photo.updateUI();
            TimeUnit.SECONDS.sleep(5);
            photo.remove(label2);
            photo.updateUI();
        }
        else{
            l1.setText("ΔΕΝ ΝΙΚΕΙΣΕ ΚΑΝΕΝΑΣ");
            l1.setBounds(350, 200, 200, 30);
            l1.setForeground(Color.black);
            l1.setFont(new Font("SCORE", Font.PLAIN, 16));
            photo.add(l1);
            photo.updateUI();
            TimeUnit.SECONDS.sleep(5);
            photo.remove(l1);
            photo.updateUI();

        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Player pl1 = new Player();
        Player pl2 = new Player();
        pl1.setName("nik");
        pl2.setName("george");
        //new  Thermometer(pl1 ,null,1 , 3);
        new Thermometer(pl1 ,pl2,1 , 3);
    }

}
  /*
    private void single()throws IOException,InterruptedException {

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
    */

