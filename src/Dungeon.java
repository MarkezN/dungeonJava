
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
        dungeon[0][0] = p.getName();
        makeVamp(vampirus);

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

    public void makeVamp(ArrayList<Vampire> vampirus) {
        for (int i = 0; i < this.vampires; i++) {
            vampirus.add(new Vampire('v'));
        }
        for(Vampire v : this.vampirus) {
            v.moveRandom(dungeon);
        }
    }
   
    public void vampList(ArrayList<Vampire> vampirus, Player p) {
        for (Vampire v : vampirus) {
            System.out.println(v);
        }
        killVamp(p);
    }

    public void vampMove(char[][] dungeon) {
        if (this.vampiresMove) {
            for (Vampire v : this.vampirus) {
                v.move(dungeon, scan);
            }
        }
    }
    public void killVamp(Player p) {
        int px = p.getX();
        int py = p.getY();
        ArrayList<Vampire> toBeRemoved = new ArrayList();
        for(Vampire v : this.vampirus) {
            if((v.getX() == px && v.getY() == py)) {
                toBeRemoved.add(v);
            }
        }
            this.vampirus.removeAll(toBeRemoved);
    }

    public void printPmoves() {
        System.out.println(this.moves);
        System.out.println();
        System.out.println(p.toString());
    }

    public void checkPos() {
        for(int i = 0; i < this.vampirus.size() - 1; i ++) {
            for(int j = i + 1; j < this.vampirus.size(); j ++) {
                if(this.vampirus.get(i).coord().equals(this.vampirus.get(j).coord())) {
                    this.vampirus.get(i).moveRandom(dungeon);
                }
            }
        }
    }
    public void run() {

        printPmoves();
        vampList(vampirus, p);

        System.out.println();
        this.moves--;
        while (this.moves >= 0) {
            checkPos();
            if (this.vampirus.isEmpty()) {
                drawDungeon(dungeon);
                System.out.println("YOU WIN");
                break;
            }
            drawDungeon(dungeon);
            clearDungeon(dungeon);
            p.move(dungeon, scan);
            vampMove(dungeon);
            printPmoves();
            vampList(vampirus, p);
           // System.out.println();
            this.moves--;

        }
        System.out.println("YOU LOSE");
    }
}