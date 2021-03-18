import java.util.Random;
import java.util.Scanner;

public class Vampire extends Charact implements Movable {
    private int x = 0;
    private int y = 0;
    private char name;
    private Random r;
    
    public Vampire(char name) {
        super(name);                              
        this.name = name;
        this.y = y;
        this.x = x;
        this.r = new Random();
    }

    @Override
    public void move(char[][] ch, Scanner scan) {
                 //randomizirati koordinate i mozda posle stvoriti novi objekat sa novim koordinatama
      //  this.x =
           int start = 0;
           int end = ch.length;

           this.x = r.nextInt(end - start) + start;
           this.y = r.nextInt(end - start) + start;
           ch[getX()][getY()] = getName();
        
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName() + " " +  getY() + " " + getX();
    }
}







