import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class a {
    int pl_num=0;

    private JButton button1;
    private JButton button2;
    private JButton enter;

    private JTextField name1;
    private JTextField name2;

    Player pl1;
    Player pl2;

    String pl_name1;
    String pl_name2;

    public a() {
        JFrame f = new JFrame();

        f.setTitle("Επιλογή παικτών");
        f.setSize(800, 800);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setResizable(true);
        f.setLayout(null);

        enter = new JButton("submit");
        enter.setBounds(400,100,100,20);
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name1.setVisible(false);
                name2.setVisible(false);
                enter.setVisible(false);

            }
        });

        name1 = new JTextField("pl1");
        name1.setBounds(200,100,100,20);

        name2 = new JTextField("pl2");
        name2.setBounds(300,100,100,20);

        button1 = new JButton("1 player");
        button1.setBounds(275,100,200,20);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pl1 = new Player();

                button1.setVisible(false);
                button2.setVisible(false);

                f.add(enter);
                f.add(name1);

            }
        });

        button2 = new JButton("2 players");
        button2.setBounds(275,125,200,20);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pl1 = new Player();
                pl2 = new Player();

                button1.setVisible(false);
                button2.setVisible(false);

                f.add(enter);
                f.add(name1);
                f.add(name2);
            }
        });

        f.add(button1);
        f.add(button2);
        f.setVisible(true);
    }
}