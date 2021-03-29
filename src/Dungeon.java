
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Dungeon {
    private char[][] dungeon;
    private int length;
    private int width;
    private Player p;
    private Scanner scan;
    private int vampires;
    private int moves;
    private boolean vampiresMove;
    // private ArrayList<Vampire> vampirus;
    private Set<Vampire> vampirus;

    public Dungeon(int length, int width, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.width = width;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        this.dungeon = new char[length][width];
        this.p = new Player('@');
        this.vampirus = new HashSet<>();
        this.scan = new Scanner(System.in);
    }

    public void drawDungeon(char[][] dungeon) {
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

    public void makeVamp(Set<Vampire> vampirus) {
        for (int i = 0; i < this.vampires; i++) {
            Vampire v = new Vampire('v');
            vampirus.add(v);
        }
    }

    public void vampList(Set<Vampire> vampirus, Player p) {
        for (Vampire v : vampirus) {
            System.out.println(v);
        }
        killVamp(p);
    }

    public void vampMove(char[][] dungeon) {
        for (Vampire v : this.vampirus) {
            v.move(dungeon, scan);
        }
    }

    public void killVamp(Player p) {
        int px = p.getX();
        int py = p.getY();

       // ArrayList<Vampire> toBeRemoved = new ArrayList();
        this.vampirus.removeIf(v -> (v.getX() == px || v.getY() == py) || (v.getX() == px && v.getY() == py));

    }

    public void printPmoves() {
        System.out.println(this.moves);
        System.out.println();
        System.out.println(p.toString());
    }


    public void run() {

        //this method can be refactored :)
        makeVamp(vampirus);

        vampMove(dungeon);

        printPmoves();
        vampList(vampirus, p);

        //   p.move(dungeon,scan);
        p.moveStart(dungeon);
        System.out.println();
        this.moves--;
        while (this.moves >= 0) {
            if (this.vampirus.isEmpty()) {
                drawDungeon(dungeon);
                System.out.println("You won");
                break;
            }
            drawDungeon(dungeon);
            clearDungeon(dungeon);
            p.move(dungeon, scan);
            vampMove(dungeon);
            printPmoves();
            vampList(vampirus, p);
            System.out.println();
            this.moves--;

        }
        // System.out.println("You Won :)");
        //System.out.println("Kraj");
    }
}