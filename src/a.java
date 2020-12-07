import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class a {
    int pl_num=0;

    private JFrame f;
    private JPanel p;

    private JButton button1;
    private JButton button2;
    private JButton enter;

    private JTextField name1;
    private JTextField name2;
    private  JTextField rounds;

    Player pl1;
    Player pl2;

    String pl_name1;
    String pl_name2;


    public a() {
        f = new JFrame("Επιλογη παικτων");
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setSize(500,300);

        p = new JPanel();
        p.setLayout(new FlowLayout(FlowLayout.CENTER));
        p.setBackground(Color.CYAN);
        f.add(p , BorderLayout.CENTER);

        button1 = new JButton("singleplayer");
        p.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name1.setText("Give name for your player");
                single();
            }
        });

        button2 = new JButton("multiplayer");
        p.add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name1.setText("Give name for player 1");
                name2.setText("Give name for player 2");
                multi();
            }
        });

        enter = new JButton("submit");
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name1.setVisible(false);
                name2.setVisible(false);
                enter.setVisible(false);
                pl_name1 = name1.getText();
                pl_name2 = name2.getText();
                //p.setVisible(false);
                System.out.println(pl_name1);
                System.out.println(pl_name2);

                rounds();
            }
        });

        name1 = new JTextField("pl1 name");
        name2 = new JTextField("pl2 name");

        f.setVisible(true);
        p.setVisible(true);

//        JPanel p2 = new JPanel();
//        p2.setLayout(new GridLayout(0,1));
//        p2.setBackground(Color.WHITE);
//        f.add(p2 , BorderLayout.CENTER);
//

    }

    public void single() {
        button1.setVisible(false);
        button2.setVisible(false);

        GridBagLayout l = new GridBagLayout();
        p.setLayout(l);
        GridBagConstraints l2 = new GridBagConstraints();
        l2.fill = GridBagConstraints.HORIZONTAL;

        l2.gridx = 0;
        l2.gridy = 1;
        l2.gridwidth = 2;
        p.add(name1 , l2);

        l2.gridx = 0;
        l2.gridy = 2;
        l2.gridwidth = 2;
        p.add(enter , l2);

    }

    public void multi() {
        button1.setVisible(false);
        button2.setVisible(false);

        GridBagLayout l = new GridBagLayout();
        p.setLayout(l);
        GridBagConstraints l2 = new GridBagConstraints();
        l2.fill = GridBagConstraints.HORIZONTAL;
        l2.gridx = 0;
        l2.gridy = 0;

        p.add(name1 , l2);
        l2.gridx = 1;
        l2.gridy = 0;
        p.add(name2 , l2);
        l2.gridx = 0;
        l2.gridy = 2;
        l2.gridwidth = 2;
        p.add(enter , l2);
    }

    public void rounds() {
        rounds = new JTextField("How many rounds do you want;");
        enter = new JButton("submit");
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("asdasdasda");
                rounds.setVisible(false);
                enter.setVisible(false);

                questions();
            }
        });

        GridBagLayout l = new GridBagLayout();
        GridBagConstraints l2 = new GridBagConstraints();

        l2.fill = GridBagConstraints.HORIZONTAL;
        l2.gridx = 0;
        l2.gridy = 1;
        l2.gridwidth = 2;
        p.add(rounds , l2);

        l2.gridx = 0;
        l2.gridy = 2;
        l2.gridwidth = 2;
        p.add(enter , l2);
    }

    public void questions() {
        rounds = new JTextField("how many questions per round;");
        enter = new JButton("submit");
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("georgeeee");
            }
        });

        GridBagLayout l = new GridBagLayout();
        GridBagConstraints l2 = new GridBagConstraints();

        l2.fill = GridBagConstraints.HORIZONTAL;
        l2.gridx = 0;
        l2.gridy = 1;
        l2.gridwidth = 2;
        p.add(rounds , l2);

        l2.gridx = 0;
        l2.gridy = 2;
        l2.gridwidth = 2;
        p.add(enter , l2);
    }

//    public a() {
//        JFrame f = new JFrame();
//
//        f.setTitle("Επιλογή παικτών");
//        f.setSize(800, 800);
//        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
//        f.setLocationRelativeTo(null);
//        f.setResizable(true);
//        f.setLayout(null);
//
//        enter = new JButton("submit");
//        enter.setBounds(400,100,100,20);
//        enter.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                name1.setVisible(false);
//                name2.setVisible(false);
//                enter.setVisible(false);
//
//            }
//        });
//
//        name1 = new JTextField("pl1");
//        name1.setBounds(200,100,100,20);
//
//        name2 = new JTextField("pl2");
//        name2.setBounds(300,100,100,20);
//
//        button1 = new JButton("1 player");
//        button1.setBounds(275,100,200,20);
//        button1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                pl1 = new Player();
//
//                button1.setVisible(false);
//                button2.setVisible(false);
//
//                f.add(enter);
//                f.add(name1);
//
//            }
//        });
//
//        button2 = new JButton("2 players");
//        button2.setBounds(275,125,200,20);
//        button2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                pl1 = new Player();
//                pl2 = new Player();
//
//                button1.setVisible(false);
//                button2.setVisible(false);
//
//                f.add(enter);
//                f.add(name1);
//                f.add(name2);
//            }
//        });
//
//        f.add(button1);
//        f.add(button2);
//        f.setVisible(true);
//    }

    public static void main(String[] args) {
        a a = new a();
    }
}