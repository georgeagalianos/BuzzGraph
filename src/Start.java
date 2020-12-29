import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start {
    private JButton player1;
    private JButton player2;
    private JButton submit;

    private JTextField text1;
    private JTextField text2;

    private JFrame frame;
    private JPanel panel;

    private Player pl1;
    private Player pl2;

    public void Game() {
        frame = new JFrame();
        frame.setTitle("Επιλογή παικτών");
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));

//        panel = new JPanel();
//        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
//        panel.setBackground(Color.BLACK);
//        frame.add(panel , BorderLayout.PAGE_START);

        text1 = new JTextField();
        //text1.setLayout(new FlowLayout());
        text1.setBounds(180,100,100,20);
        //text1.setBounds(200,100,100,20);

        text2 = new JTextField();
        //text2.setLayout(new FlowLayout());
        text2.setBounds(290,100,100,20);
        //text2.setBounds(300,100,100,20);

        player1 = new JButton("Singleplayer");
        player1.setLayout(new FlowLayout());
        player1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setLayout(null);
                pl1 = new Player();

                player1.setVisible(false);
                player2.setVisible(false);

                text1.setText("Give yout name");

                frame.add(text1);
                frame.add(submit);
            }
        });
        player2 = new JButton("Multiplayer");
        player2.setLayout(new FlowLayout());
        player2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setLayout(null);
                pl1 = new Player();
                pl2 = new Player();

                player1.setVisible(false);
                player2.setVisible(false);

                text1.setText("Give name for player 1");
                text2.setText("Give name for player 2");

                frame.add(text1);
                frame.add(text2);
                frame.add(submit);
            }
        });
        submit = new JButton("Submit");
        //submit.setLayout(new FlowLayout());
        submit.setBounds(400,100,100,20);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text1.setVisible(false);
                text2.setVisible(false);
                submit.setVisible(false);
            }
        });

        frame.add(player1);
        frame.add(player2);

        frame.setVisible(true);
        //panel.setVisible(true);
    }

    public static void main(String[] args) {
        Start s = new Start();
        s.Game();
    }
}
