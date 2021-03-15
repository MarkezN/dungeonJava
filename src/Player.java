import java.util.Scanner;

public class Player extends Charact implements Movable{
    private int x;
    private int y;
    private char name;
    private int dx;
    private int dy;
   // private int count = 0;
  
  //  private Scanner scan;
  //  private Player pl;

    public Player(char name) {

               super(name);
               this.name = name;
       
    }
    public void moveDown() {

       // this.y += dy;
        //dx+=1;
      //  x+=1;
       // count += dx;
       // setX(dx);
        setX(x+=1);
     //  this.y = dy;

     //  ch[x][y + dy] = pl.getName();


     //   d.drawDungeon();
        //   dx = 1;
        //  dy = 0;
        // dx++;
        // this.x = x + dx;
        //this.y = y + dy;

    }
   @Override
   public void move(char[][] ch, Player pl, Scanner scan){

       
       // update koordinata konstantno

       while(true) {
           System.out.println("Pritisni gumb: ");
           String key = scan.nextLine();
           if(key.equals("s")){
             //  count++;
              // count = dx;
              // dx++;
           //    moveDown(ch, pl, 0, 1);
                 moveDown();
           }
           if(key.equals("q")) {
               break;
           }
       }
      // System.out.println(count);
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
}
