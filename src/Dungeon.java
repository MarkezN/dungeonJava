/* import java.util.Scanner; */

import java.util.Scanner;

public class Dungeon {
    private char[][] dungeon;
    private int length;
    private int width;
    private Player p;
    private Scanner scan;
    private int vampires;
    private int moves;
    private boolean vampiresMove;

    public Dungeon(int length, int width, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.width = width;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        this.dungeon = new char[length][width];
        this.p = new Player('@');
        this.scan = new Scanner(System.in);
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

    public int getLength() {
        return length;
    }

    public void run() {
        System.out.println(this.moves);
        System.out.println(p.toString());
        p.moveStart(dungeon);
        this.moves--;
        while (this.moves >= 0) {
            drawDungeon(dungeon);
            clearDungeon(dungeon);
            p.move(dungeon, scan);
            System.out.println(this.moves);
            this.moves--;
        }
        System.out.println("You LOOOOOSE :)");
    }
}