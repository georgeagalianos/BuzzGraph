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
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEADING));
        panel.setBackground(Color.BLACK);
        frame.add(panel , BorderLayout.PAGE_START);

        player1 = new JButton("Singleplayer");
        player1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.remove(player1);
                panel.remove(player2);
                panel.add(submit);
                panel.add(text1);
                pl1 = new Player();
            }
        });
        player2 = new JButton("Multiplayer");
        player2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.remove(player1);
                panel.remove(player2);
                panel.add(submit);
                panel.add(text1);
                panel.add(text2);
                pl1 = new Player();
                pl2 = new Player();
            }
        });
        submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        text1 = new JTextField();
        text2 = new JTextField();

        panel.add(player1);
        panel.add(player2);
    }

    public static void main(String[] args) {

    }
}
