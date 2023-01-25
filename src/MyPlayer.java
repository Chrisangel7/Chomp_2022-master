import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;


    public ArrayList<Board> LBoards = new ArrayList<>();
    public ArrayList<Board> WBoards= new ArrayList<>();
    public ArrayList<Board> RBoards = new ArrayList<>();
    public ArrayList<Board[]> ResultBoards = new ArrayList<>();
    public ArrayList<Board> CurrentBoards = new ArrayList<>();
    //public boolean IsLosing;
    //   public int CurrentBoard[];


    public MyPlayer() {
        columns = new int[10];

        make3x3();


        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
    }// comment for git

    public void make3x3() {
        for (int i = 1; i < 4; i++) {
            for (int o = 0; o < 4; o++) {
                for (int p = 0; p < 4; p++) {
                    if (i >= o && o >= p) {
                        System.out.println(i + " " + o + " " + p);
                        ResultBoard(i, o, p);
                        // int CurrentBoard[] = {i, o, p,};

                        if (i == 1 && o == 0 && p == 0) {
                            LBoards.add(new Board(i,o,p,0,0));
                        }

                        //  WorL(ResultBoards,CBoard);


                    }
                }
            }
        }
    }

    public void ResultBoard(int i, int o, int p) {
        int tRow = 0;
        int tCol = 0;
        boolean foundWinner  = false;
        int CurrentResult[] = {i, o, p};
        //     Board cur=new Board(i,o,p,0,0);

        int p1 = p;
        int o1 = o;
        int i1 = i;


        for (int p2 = p - 1; p2 >= 0; p2--) { // third column
            for (int x = 0; x < LBoards.size(); x++) {
                if (i == LBoards.get(x).C1 && o == LBoards.get(x).C2 && p2 == LBoards.get(x).C3) {

                   // RBoards.add(i,o,p2,tRow,tCol);
                    System.out.println("Winner board");
                    foundWinner = true;
                    tRow = p2;
                    tCol = 2;
                    System.out.println("Result Board is " + i + " " + o + " " + p2 + " (" + tRow + "," + tCol + ")");

                    System.out.println();


                }


            }
//            if(foundWinner!=true){
//                LBoards.add(new Board(i,o,p2, tRow,tCol));
//
//            }
        }

        for (int o2 = o - 1; o2 >= 0; o2--) { // second column
            if (o2 < p) {
                p = o2;
            }

            for (int y = 0; y < LBoards.size(); y++) {

                if (i == LBoards.get(y).C1 && o2 == LBoards.get(y).C2 && p == LBoards.get(y).C3) {

                    System.out.println("Winner board");
                    foundWinner = true;
                    tRow = o2;
                    tCol = 1;
                    System.out.println("Result Board is " + i + " " + o2 + " " + p + " (" + tRow + "," + tCol + ")");
                    System.out.println();


                }

            }
//            if (foundWinner!=true){
//                LBoards.add(new Board(i,o,p, tRow,tCol));
//
//            }
        }
        p = p1;
        for (int i2 = i - 1; i2 >= 0; i2--) { // first column
            if (i2 < o) {
                o = i2;
            }
            if (i2 < p) {
                p = i2;
            }
            if(i2!=0) {
                //System.out.println("Result Board is " + i2 + " " + o + " " + p + " (" + i2 + "," + o + ")");
            }
            if (i2!= 0) {
                for (int z = 0; z < LBoards.size(); z++) {


                    if (i2 == LBoards.get(z).C1 && o == LBoards.get(z).C2 && p == LBoards.get(z).C3) {

                        System.out.println("Winner board");
                        foundWinner = true;
                        tRow = i2;
                        tCol = 0;
                        System.out.println("Result Board is " + i2 + " " + o + " " + p + " (" + tRow + "," + tCol + ")");


                        System.out.println();


                    }


                }



            }
        }

        if (foundWinner != true) {


            LBoards.add(new Board(i1, o1, p1,0, 0));
        }
        else{
            WBoards.add(new Board(i1,o1,p1,tRow,tCol));
            System.out.println("THis board is a winner");
        }
        System.out.println("______________________");

//                        cur.tempRow = tRow;
//                        cur.tempCol = tCol;

    }






    public Point move (Chip[][]pBoard) {

        System.out.println("MyPlayer Move");

        gameBoard = pBoard;
        columns = checkChips(gameBoard);
        int column = 0;
        int row = 0;

        row = 3;
        column = 1;

        for (int x = 0; x < WBoards.size(); x++) {

        if (columns[0] == WBoards.get(x).C1 && WBoards.get(x).C2 == columns[1] && WBoards.get(x).C3 == columns[2]) {
            row = WBoards.get(x).tempCol;
            column = WBoards.get(x).tempRow;

            System.out.println(row +" " +column);
        }
    }
        for (int x = 0; x < LBoards.size(); x++) {

            if (columns[0] == LBoards.get(x).C1 && LBoards.get(x).C2 == columns[1] && LBoards.get(x).C3 == columns[2]) {
                row = LBoards.get(x).tempCol;
                column = LBoards.get(x).tempRow;

                System.out.println(row +" " +column);
            }
        }

        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */




        Point myMove = new Point(row, column);
        return myMove;
    }

    public int[] checkChips (Chip[][]gameBoard){

        int[] cols = new int[10];
        System.out.println(gameBoard.length);
        System.out.println(gameBoard[1].length);


        for (int c = 0; c < gameBoard.length; c++) {
            for (int r = 0; r < gameBoard[c].length; r++) {///what is the stop condition?
                if (gameBoard[r][c].isAlive == true) {
                    cols[c] = cols[c] + 1;
                }
            }
        }

        System.out.println(Arrays.toString(cols));

        return cols;
    }

    public void PlayGame(){

    }


}

