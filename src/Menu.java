import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Menu {
    private Player pl1 = new Player();
    private Player pl2 = new Player();
    private int rounds;
    private int quests;

    private JFrame fmenu;
    private JPanel pmenu;

    private JButton correct;
    private JButton bet;
    private JButton stopwatch;
    private JButton thermometer;
    private JButton back;

    private JLabel image;
    private BufferedImage img;

    public Menu(Player pl1 , Player pl2 , int rounds , int quests) throws IOException{
        this.pl1 = pl1;
        this.pl2 = pl2;
        this.rounds = rounds;
        this.quests = quests;

        fmenu = new JFrame("Menu");
        fmenu.setSize(800 , 500);
        fmenu.setDefaultCloseOperation(fmenu.EXIT_ON_CLOSE);
        fmenu.setResizable(false);

        pmenu = new JPanel();

        //##        image
        img = ImageIO.read(new File("images/bg2.jpg"));
        ImageIcon icon = new ImageIcon(img);
        image = new JLabel();
        image.setIcon(icon);
        pmenu.add(image);
        fmenu.add(pmenu);
        //###

        //##        make buttons
        correct = new JButton("Correct Answer");
        correct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fmenu.setVisible(false);
                try {
                    new CorrectAnswer(pl1 , pl2 , rounds , quests);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });

        bet = new JButton("Bet");
        bet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fmenu.setVisible(false);
                try {
                    new BET(pl1 , pl2 , rounds , quests);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });

        stopwatch = new JButton("Stopwatch");
        stopwatch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fmenu.setVisible(false);
                try {
                    new Stopwatch(pl1 , pl2 , rounds , quests);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });

        thermometer = new JButton("Thermometer");
        thermometer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fmenu.setVisible(false);
                try {
                    new Thermometer(pl1 , pl2 , rounds , quests);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });

        back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fmenu.setVisible(false);
                try {
                    new a();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        //###



        //##        layout for buttons
        GridBagLayout l = new GridBagLayout();
        image.setLayout(l);

        GridBagConstraints l2 = new GridBagConstraints();
        l2.fill = GridBagConstraints.HORIZONTAL;

        //1st button
        l2.gridx = 0;
        l2.gridy = 0;
        image.add(correct , l2);

        //2nd button
        l2.gridx = 0;
        l2.gridy = 1;
        image.add(bet , l2);

        //3d button
        l2.gridx = 0;
        l2.gridy = 2;
        image.add(stopwatch , l2);

        //4th button
        l2.gridx = 0;
        l2.gridy = 3;
        image.add(thermometer , l2);

        //5th button
        l2.gridx = 0;
        l2.gridy = 4;
        image.add(back , l2);

        //###


        fmenu.setVisible(true);
        pmenu.setVisible(true);
    }
}
