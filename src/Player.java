import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    Scanner read = new Scanner(System.in);
    private String name;
    private int points;
    private int bid;
    private int wins;


    public Player() {
        System.out.print("Enter your name : ");
        this.name = read.nextLine();
        System.out.println("hello " + name + "\n" + "Welcome to the BuzzGame.");
        this.points = 0;
        this.wins = 0;
        getName();
    }

    public String getName() { return this.name; }

    public int getPoints() { return this.points; }

    /**
     *Μία μέθοδος η οποία ανήκει στην κλάσση player η οποία αυξάνει και μειώνει κατάλληλα τους πόντους του παίχτη
     ανάλογα με το αν έχει απαντήσει σωστά ή λάθος στην ερώτηση
     */
    public int addPoints(int point) {
        return this.points += point;
    }

    public void setBid(int bid) { this.bid = bid; }

    public int getBid() { return this.bid; }
}