import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Vampire extends Charact implements Movable{
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
         int direct = r.nextInt(4);

         if(direct == 0) {
             if(this.y > 0) {
                 this.y--;
             }
         }
         if(direct == 1) {
             if(this.y < ch.length - 1) {
                 this.y ++;
             }
         }
         if(direct == 2) {
             if(this.x > 0) {
                 this.x --;
             }
         }
         if(direct == 3) {
             if(this.x < ch.length - 1) {
                 this.x ++;
             }
         }
           ch[getX()][getY()] = getName();
    }

    public void moveRandom(char[][] ch) {
        int len = ch.length;
        this.x = r.nextInt(len - 1);
        this.y = r.nextInt(len - 1);
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

   
    public String coord() {
        return this.x + "x" + this.y + "y";
    }
    @Override
    public String toString() {
        return getName() + " " +  getY() + " " + getX();
    }
}







