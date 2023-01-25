import java.awt.*;
public class Board {
    boolean WinningB;
    Point bMove;
    int C1;
    int C2;
    int C3;

    int xcord;
    int ycord;

    int row;
    int col;

    int tempRow;
    int tempCol;


    public Board(int PC1,int PC2, int PC3, int ptempCol,int ptempRow){
        C1=PC1;
        C2=PC2;
        C3=PC3;

        tempCol=ptempCol;
        tempRow=ptempRow;

//        xcord = pxcord;
//        ycord = pycord;

        bMove = new Point(row, col);

    }

}
