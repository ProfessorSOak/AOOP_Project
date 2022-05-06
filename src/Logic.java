import javax.swing.*;
import java.io.File;

public class Logic extends Sokoban {
    //private PictureComponent first = new PictureComponent();

    @Override
    public void UpPressed() {
        Check(GetCharPosX(), GetCharPosY(), -1,0,-2,0);
        System.out.println("TestUP");
    }

    @Override
    public void DownPressed() {
        Check(GetCharPosX(), GetCharPosY(),1,0,2,0);
        System.out.println("TestDOWN");
    }

    @Override
    public void LeftPressed(){
        Check(GetCharPosX(), GetCharPosY(),0,-1,0,-2);
        System.out.println("TestLEFT");
    }

    @Override
    public void RightPressed(){
        Check(GetCharPosX(), GetCharPosY(),0,1,0,2);
        System.out.println("TestRIGHT");
    }

    @Override
    public void ResetPressed(){
        System.out.println("TestRESET");
    }

    @Override
    public void UpdateBoard(File[][] Board, PictureComponent k) {
        //PictureComponent Update = new PictureComponent();
        for(int i = 0; i<Board.length; i++){
            for(int j = 0; j<Board[0].length;j++){
                //Update = new PictureComponent();
                k.UpdateField(Board);
                //k.remove(Board[0].length*i+j);
                //k.add(Update, Board[0].length*i+j);
            }
        }
    }

   /* @Override
    public JComponent createMainComponent() {
        PictureComponent test = new PictureComponent();
        return test;
    }*/


    /*public void CheckLeft(){
        int checkX = GetCharPosX();
        int checkY = GetCharPosY();
        int[][] Board = GetBoard();
        if(Board[checkX][checkY-1] == 0){
            return;
        }
        if(Board[checkX][checkY-1] == 1){
            Board[checkX][checkY-1] = 3;
            SetCharPosY(checkY-1);
            if(Board[checkX][checkY] == 3){
                Board[checkX][checkY] = 1;
            }
            else{
                Board[checkX][checkY] = 4;
            }
            return;
        }

        if(Board[checkX][checkY-1] == 2 || Board[checkX][checkY-1] == 6){
            if(Board[checkX][checkY-2] == 0 ||Board[checkX][checkY-2] == 2 ||Board[checkX][checkY-2] == 6){
                return;
            }
            if(Board[checkX][checkY-2] == 1){
                Board[checkX][checkY-2] = 2;
                if(Board[checkX][checkY-1] == 2){
                    Board[checkX][checkY-1] = 3;
                    SetCharPosY(checkY-1);
                }
                else{
                    Board[checkX][checkY-1] = 7;
                    SetCharPosY(checkY-1);
                }
                if(Board[checkX][checkY] == 3){
                    Board[checkX][checkY] = 1;
                }
                else{
                    Board[checkX][checkY] = 4;
                }
                return;
            }
            if(Board[checkX][checkY-2] == 4){
                Board[checkX][checkY-2] = 6;
                if(Board[checkX][checkY-1] == 2){
                    Board[checkX][checkY] = 3;
                    SetCharPosY(checkY-1);
                }
                else{
                    Board[checkX][checkY-1] = 7;
                    SetCharPosY(checkY-1);
                }
                if(Board[checkX][checkY] == 3){
                    Board[checkX][checkY] = 1;
                }
                else{
                    Board[checkX][checkY] = 4;
                }
                return;
            }
        }
        if(Board[checkX][checkY-1] == 4){
            Board[checkX][checkY-1] = 7;
            SetCharPosY(checkY-1);
            if(Board[checkX][checkY] == 3){
                Board[checkX][checkY] = 1;
            }
            else{
                Board[checkX][checkY] = 4;
            }
        }
    }
    public void CheckRight(){
        int checkX = GetCharPosX();
        int checkY = GetCharPosY();
        int[][] Board = GetBoard();
        if(Board[checkX][checkY+1] == 0){
            return;
        }
        if(Board[checkX][checkY+1] == 1){
            Board[checkX][checkY+1] = 3;
            SetCharPosY(checkY+1);
            if(Board[checkX][checkY] == 3){
                Board[checkX][checkY] = 1;
            }
            else{
                Board[checkX][checkY] = 4;
            }
            SetBoard(Board);
            return;
        }

        if(Board[checkX][checkY+1] == 2 || Board[checkX][checkY+1] == 6){
            if(Board[checkX][checkY+2] == 0 ||Board[checkX][checkY+2] == 2 ||Board[checkX][checkY+2] == 6){
                return;
            }
            if(Board[checkX][checkY+2] == 1){
                Board[checkX][checkY+2] = 2;
                if(Board[checkX][checkY+1] == 2){
                    Board[checkX][checkY+1] = 3;
                    SetCharPosY(checkY+1);
                }
                else{
                    Board[checkX][checkY+1] = 7;
                    SetCharPosY(checkY+1);
                }
                if(Board[checkX][checkY] == 3){
                    Board[checkX][checkY] = 1;
                }
                else{
                    Board[checkX][checkY] = 4;
                }
                SetBoard(Board);
                return;
            }
            if(Board[checkX][checkY+2] == 4){
                Board[checkX][checkY+2] = 6;
                if(Board[checkX][checkY+1] == 2){
                    Board[checkX][checkY+1] = 3;
                    SetCharPosY(checkY+1);
                }
                else{
                    Board[checkX][checkY+1] = 7;
                    SetCharPosY(checkY+1);
                }
                if(Board[checkX][checkY] == 3){
                    Board[checkX][checkY] = 1;
                }
                else{
                    Board[checkX][checkY] = 4;
                }
                SetBoard(Board);
                return;
            }
        }
        if(Board[checkX][checkY+1] == 4){
            Board[checkX][checkY+1] = 7;
            SetCharPosY(checkY+1);
            if(Board[checkX][checkY] == 3){
                Board[checkX][checkY] = 1;
            }
            else{
                Board[checkX][checkY] = 4;
            }
            SetBoard(Board);
        }
    }

    public void CheckUp(){
        int checkX = GetCharPosX();
        int checkY = GetCharPosY();
        int[][] Board = GetBoard();
        if(Board[checkX-1][checkY] == 0){
            return;
        }
        if(Board[checkX-1][checkY] == 1){
            Board[checkX-1][checkY] = 3;
            SetCharPosX(checkX-1);
            if(Board[checkX][checkY] == 3){
                Board[checkX][checkY] = 1;
            }
            else{
                Board[checkX][checkY] = 4;
            }
            SetBoard(Board);
            return;
        }

        if(Board[checkX-1][checkY] == 2 || Board[checkX-1][checkY] == 6){
            if(Board[checkX-2][checkY] == 0 ||Board[checkX-2][checkY] == 2 ||Board[checkX-2][checkY] == 6){
                return;
            }
            if(Board[checkX-2][checkY] == 1){
                Board[checkX-2][checkY] = 2;
                if(Board[checkX-1][checkY] == 2){
                    Board[checkX-1][checkY] = 3;
                    SetCharPosX(checkX-1);
                }
                else{
                    Board[checkX-1][checkY] = 7;
                    SetCharPosX(checkX-1);
                }
                if(Board[checkX][checkY] == 3){
                    Board[checkX][checkY] = 1;
                }
                else{
                    Board[checkX][checkY] = 4;
                }
                SetBoard(Board);
                return;
            }
            if(Board[checkX-2][checkY] == 4){
                Board[checkX-2][checkY] = 6;
                if(Board[checkX-1][checkY] == 2){
                    Board[checkX-1][checkY] = 3;
                    SetCharPosX(checkX-1);
                }
                else{
                    Board[checkX-1][checkY] = 7;
                    SetCharPosX(checkX-1);
                }
                if(Board[checkX][checkY] == 3){
                    Board[checkX][checkY] = 1;
                }
                else{
                    Board[checkX][checkY] = 4;
                }
                SetBoard(Board);
                return;
            }
        }
        if(Board[checkX-1][checkY] == 4){
            Board[checkX-1][checkY] = 7;
            SetCharPosX(checkX-1);
            if(Board[checkX][checkY] == 3){
                Board[checkX][checkY] = 1;
            }
            else{
                Board[checkX][checkY] = 4;
            }
            SetBoard(Board);
        }
    }

    public void CheckDown(){
        int checkX = GetCharPosX();
        int checkY = GetCharPosY();
        int[][] Board = GetBoard();
        if(Board[checkX+1][checkY] == 0){
            return;
        }
        if(Board[checkX+1][checkY] == 1){
            Board[checkX+1][checkY] = 3;
            SetCharPosX(checkX+1);
            if(Board[checkX][checkY] == 3){
                Board[checkX][checkY] = 1;
            }
            else{
                Board[checkX][checkY] = 4;
            }
            SetBoard(Board);
            return;
        }

        if(Board[checkX+1][checkY] == 2 || Board[checkX+1][checkY] == 6){
            if(Board[checkX+2][checkY] == 0 ||Board[checkX+2][checkY] == 2 ||Board[checkX+2][checkY] == 6){
                return;
            }
            if(Board[checkX+2][checkY] == 1){
                Board[checkX+2][checkY] = 2;
                if(Board[checkX+1][checkY] == 2){
                    Board[checkX+1][checkY] = 3;
                    SetCharPosX(checkX+1);
                }
                else{
                    Board[checkX+1][checkY] = 7;
                    SetCharPosX(checkX+1);
                }
                if(Board[checkX][checkY] == 3){
                    Board[checkX][checkY] = 1;
                }
                else{
                    Board[checkX][checkY] = 4;
                }
                SetBoard(Board);
                return;
            }
            if(Board[checkX+2][checkY] == 4){
                Board[checkX+2][checkY] = 6;
                if(Board[checkX+1][checkY] == 2){
                    Board[checkX+1][checkY] = 3;
                    SetCharPosX(checkX+1);
                }
                else{
                    Board[checkX+1][checkY] = 7;
                    SetCharPosX(checkX+1);
                }
                if(Board[checkX][checkY] == 3){
                    Board[checkX][checkY] = 1;
                }
                else{
                    Board[checkX][checkY] = 4;
                }
                SetBoard(Board);
                return;
            }
        }
        if(Board[checkX+1][checkY] == 4){
            Board[checkX+1][checkY] = 7;
            SetCharPosX(checkX+1);
            if(Board[checkX][checkY] == 3){
                Board[checkX][checkY] = 1;
            }
            else{
                Board[checkX][checkY] = 4;
            }
            SetBoard(Board);
        }
    }*/

    public void Check(int checkX, int checkY, int x1, int y1, int x2, int y2){
        //int checkX = GetCharPosX();
        //int checkY = GetCharPosY();
        int[][] Board = GetBoard();
        if(Board[checkX+x1][checkY+y1] == 0){
            return;
        }
        if(Board[checkX+x1][checkY+y1] == 1){
            Board[checkX+x1][checkY+y1] = 3;
            SetCharPosX(checkX+x1);
            SetCharPosY(checkY+y1);
            if(Board[checkX][checkY] == 3){
                Board[checkX][checkY] = 1;
            }
            else{
                Board[checkX][checkY] = 4;
            }
            SetBoard(Board);
            return;
        }

        if(Board[checkX+x1][checkY+y1] == 2 || Board[checkX+x1][checkY+y1] == 6){
            if(Board[checkX+x2][checkY+y2] == 0 ||Board[checkX+x2][checkY+y2] == 2 ||Board[checkX+x2][checkY+y2] == 6){
                return;
            }
            if(Board[checkX+x2][checkY+y2] == 1){
                Board[checkX+x2][checkY+y2] = 2;
                if(Board[checkX+x1][checkY+y1] == 2){
                    Board[checkX+x1][checkY+y1] = 3;
                    SetCharPosX(checkX+x1);
                    SetCharPosY(checkY+y1);
                }
                else{
                    Board[checkX+x1][checkY+y1] = 7;
                    SetCharPosX(checkX+x1);
                    SetCharPosY(checkY+y1);
                }
                if(Board[checkX][checkY] == 3){
                    Board[checkX][checkY] = 1;
                }
                else{
                    Board[checkX][checkY] = 4;
                }
                SetBoard(Board);
                return;
            }
            if(Board[checkX+x2][checkY+y2] == 4){
                Board[checkX+x2][checkY+y2] = 6;
                if(Board[checkX+x1][checkY+y1] == 2){
                    Board[checkX+x1][checkY+y1] = 3;
                    SetCharPosX(checkX+x1);
                    SetCharPosY(checkY+y1);
                }
                else{
                    Board[checkX+x1][checkY+y1] = 7;
                    SetCharPosX(checkX+x1);
                    SetCharPosY(checkY+y1);
                }
                if(Board[checkX][checkY] == 3){
                    Board[checkX][checkY] = 1;
                }
                else{
                    Board[checkX][checkY] = 4;
                }
                SetBoard(Board);
                return;
            }
        }
        if(Board[checkX+x1][checkY+y1] == 4){
            Board[checkX+x1][checkY+y1] = 7;
            SetCharPosX(checkX+x1);
            SetCharPosY(checkY+y1);
            if(Board[checkX][checkY] == 3){
                Board[checkX][checkY] = 1;
            }
            else{
                Board[checkX][checkY] = 4;
            }
            SetBoard(Board);
        }
    }
}
