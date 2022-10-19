import java.awt.*;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;

    public MyPlayer() {
        columns = new int[10];
        make3x3();
        //ResultBoard();


        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
    }// comment for git
    public void make3x3() {
        for (int i =1; i < 4; i++) {
            for(int o = 0; o<4; o++) {
                for (int p=0;p<4;p++){
                    if(i>=o && o>=p){
                        System.out.println(i+" "+o+" " +p);
                        ResultBoard(i,o,p);
                    }
                }
            }
        }
    }

   public void ResultBoard(int i, int o, int p){
      for (int q=1; q<3; q++){
           System.out.println(i+" "+o+" "+(p-q));
      }
    }

    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");

        gameBoard = pBoard;
        int column = 0;
        int row = 0;

        row = 1;
        column = 1;

        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */

        Point myMove = new Point(row, column);
        return myMove;
    }




}
