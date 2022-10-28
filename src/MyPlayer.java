import java.awt.*;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;

    public MyPlayer() {
        columns = new int[10];
        make3x3();

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
    }// comment for git
    public void make3x3() {
        for (int i =1; i < 4; i++) {
            for(int o = 0; o<4; o++) {
                for (int p=0;p<4;p++){;
                    if(i>=o && o>=p){
                        System.out.println(i+" "+o+" " +p);
                        ResultBoard(i,o,p);
                    }
                }
            }
        }
    }

    public void ResultBoard(int i, int o, int p) {
        int p1=p;
        int o1=o;
        int i1=i;
        for (int p2 = p-1 ; p2 >= 0; p2--) { // third column
            System.out.println("Result Board is " + i + " " + o + " " + p2);
            //System.out.println("Move to get there: " + );
        }
        for (int o2 = o-1; o2 >= 0; o2--) { // second column
            if(o2<p){
               p=o2;
            }
            System.out.println("Result Board is " + i + " " + o2 + " " +p);
            //p=p1;
        }
        p=p1;
        for (int i2 = i-1; i2 >= 0; i2--) { // first column
            if(i2<o){
                o=i2;
            }
            if(i2<p){
                p=i2;
            }
            System.out.println("Result Board is " + i2 + " " + o + " " +p);
           // o=o1;
        }

        System.out.println();
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
