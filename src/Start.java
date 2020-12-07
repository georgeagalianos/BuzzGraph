import javax.swing.*;

public class Start {
    private JButton player1;
    private JButton player2;
    private JButton submit;

    private JTextField text1;
    private JTextField text2;

    private JFrame frame;

    public void Game() {
        frame = new JFrame();
        frame.setTitle("Επιλογή παικτών");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        player1 = new JButton("Singleplayer");
        player2 = new JButton("Multiplayer");
        submit = new JButton("Submit");

        text1 = new JTextField();
        text2 = new JTextField();


    }
}
