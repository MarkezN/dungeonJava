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


   public void drawDungeon(char[][]dungeon) {
      //char[][] d = new char[length][width];
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


   public void run(){
    //  Player p = new Player('@');


     // drawDungeon(dungeon);


      System.out.println(p.getName());
      p.move(dungeon, p , scan);
      drawDungeon(dungeon);

     
    //  drawDungeon(dungeon);
   }
}

