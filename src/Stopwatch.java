import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Stopwatch {
    public Player pl1;
    public Player pl2;

    private JFrame Stopwatch;
    private JPanel panel;

    private JButton answer1;
    private JButton answer2;
    private JButton answer3;
    private JButton answer4;

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;

    private BufferedImage img;
    private JLabel image;

    private JLabel ans1;
    private JLabel ans2;


    public Stopwatch(Player p1 , Player p2) throws IOException {
        this.pl1 = p1;
        this.pl2 = p2;

        Game();
//        if(pl2.getName() == "null") {
//            GameSingle();
//        }
//        else {
//            GameMulti();
//        }
    }


    private void Game () throws IOException {
        Stopwatch = new JFrame("Game mode : Stopwatch");
        Stopwatch.setDefaultCloseOperation(Stopwatch.EXIT_ON_CLOSE);
        Stopwatch.setResizable(false);
        Stopwatch.setSize(800 , 500);

        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        image = new JLabel();
        image.setLayout(new FlowLayout(FlowLayout.CENTER));

        //################################################################
        img = ImageIO.read(new File("images/bg2.jpg"));
        ImageIcon icon = new ImageIcon(img);
        image.setIcon(icon);
        panel.add(image);
        Stopwatch.add(panel);

        //################################################################

        GameSingle();

        Stopwatch.setVisible(true);
        panel.setVisible(true);

    }

    private void GameSingle() {
        GridBagLayout l = new GridBagLayout();
        image.setLayout(l);
        GridBagConstraints l2 = new GridBagConstraints();
        l2.fill = GridBagConstraints.HORIZONTAL;
        l2.gridx = 0;
        l2.gridy = 0;
        ans1 = new JLabel("apanthsh 1");
        image.add(ans1);

        l2.gridx = 1;
        l2.gridy = 0;
        l2.gridwidth = 5;
        ans2 = new JLabel("apanthsh 2");
        image.add(ans2);
    }

    private void GameMulti() {

    }

}
