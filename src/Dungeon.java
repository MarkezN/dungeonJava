/* import java.util.Scanner; */

import java.util.ArrayList;
import java.util.Scanner;

public class Dungeon {
    private char[][] dungeon;
    private int length;
    private int width;
    private Player p;
    //private Vampire v;
    private Scanner scan;
    private int vampires;
    private int moves;
    private boolean vampiresMove;
    private ArrayList<Vampire> vampirus;

    public Dungeon(int length, int width, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.width = width;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        this.dungeon = new char[length][width];
        this.p = new Player('@');
        this.vampirus = new ArrayList(this.vampires);
        this.scan = new Scanner(System.in);
    }

    public boolean vampMove(boolean vampiresMove) {

        for (Vampire v : this.vampirus) {
            if (!vampiresMove) {
                v.setX(0);
                v.setY(0);
                return true;
            }
        }
        return false;
    }

    public void drawDungeon(char[][] dungeon) {
        //char[][] d = new char[length][width];
        // dungeon[0][0] = p.getName();
        for (char[] c : dungeon) {
            for (char i : c) {
                if (i == 0) {
                    System.out.print("." + " ");
                } else {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
    }

    public void clearDungeon(char[][] dungeon) {
        for (int i = 0; i < dungeon.length; i++) {
            for (int j = 0; j < dungeon[0].length; j++) {
                dungeon[i][j] = '.';
            }
        }
    }

    public void makeVamp(ArrayList<Vampire> vampirus) {
        for (int i = 0; i < this.vampires; i++) {
            Vampire v = new Vampire('v');
            vampirus.add(v);
        }
    }

    public void vampList(ArrayList<Vampire> vampirus) {
        for (Vampire v : vampirus) {
            System.out.println(v);
        }
    }

    public void vampMove(char[][] dungeon) {
        for (Vampire v : this.vampirus) {
            v.move(dungeon, scan);
        }
    }

    public void run() {

        //this method can be way refactored :)
        makeVamp(vampirus);

        vampMove(dungeon);

        System.out.println(this.moves);
        System.out.println();
        System.out.println(p.toString());
        vampList(vampirus);
        p.moveStart(dungeon);
        System.out.println();
        this.moves--;
        while (this.moves >= 0) {
            drawDungeon(dungeon);
            clearDungeon(dungeon);
            p.move(dungeon, scan);
            vampMove(dungeon);
            System.out.println(this.moves);
            System.out.println();
            System.out.println(p.toString());
            vampList(vampirus);
            System.out.println();
            this.moves--;
        }
        System.out.println("You LOOOOOSE :)");
    }
}