import java.util.Scanner;

public class Player extends Charact implements Movable{
    private int x = 0;
    private int y = 0;
    private char name;
    public Player(char name) {
        super(name);
        this.name = name;
    }
    public void moveDown(char[][] ch) {
        if(getX() < ch.length) {
            setX(x+=1);
        }
    }
    public void moveUp() {
        if(getX() > 0) {
            setX(x-=1);
        }
    }
    public void moveLeft() {
        if(getY() > 0) {
            setY(y -= 1);
        }
    }
    public void moveRight(char[][] ch) {
        if (getY() < ch.length) {
            setY(y += 1);
        }
    }
   @Override
   public void move(char[][] ch, Player pl, Scanner scan) {
       // user input directs player
           System.out.println("Pritisni gumb: ");
           String key = scan.nextLine();
           char[] cha = key.toCharArray();
           for(char c : cha) {

             //maybe try polymorph here instead of switch
              switch (c) {
                  case 's':
                      moveDown(ch);
                      break;
                  case 'a':
                      moveLeft();
                      break;
                  case 'w':
                      moveUp();
                      break;
                  case 'd':
                      moveRight(ch);
                      break;
                  default:
                      break;
              }
           }
       ch[getX()][getY()] = pl.getName();
   }
    public char getName() {
        return name;
    }
    public void setName(char name) {
        this.name = name;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    @Override
    public String toString() {
        return "Player pos: {" + "x = " + x + ", y = " + y + '}';
    }
}
