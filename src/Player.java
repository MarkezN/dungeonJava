import java.util.Scanner;

public class Player extends Charact implements Movable{
    private int x = 0;
    private int y = 0;
    private char name;
   // private int dx;
    //private int dy;

    public Player(char name) {
        super(name);
        this.name = name;
    }
    public void moveDown() {

        setX(x+=1);
    }
    public void moveUp() {
        setX(x-=1);
    }
    public void moveLeft() {
        setY(y-=1);
    }
    public void moveRight() {
        setY(y+=1);
    }
   @Override
   public void move(char[][] ch, Player pl, Scanner scan) {
       // user input directs player

       while(true) {
           System.out.println("Pritisni gumb: ");
           String key = scan.nextLine();
           //    moveDown(ch, pl, 0, 1);
           if(key.equals("s")) moveDown();
           if(key.equals("w")){
               moveUp();       
           }
           if(key.equals("a")){
              moveLeft();
           }
           if(key.equals("d")){
              moveRight();
           }
           if(key.equals("q")) {
               break;
           }
       }
       ch[getX()][getY()] = pl.getName();
       //System.out.println(toString());
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
        return "Player pos: {" +
                "x = " + x +
                ", y = " + y +
                '}';
    }
}
