import java.io.File;

public class Logic extends Sokoban {
    //private PictureComponent first = new PictureComponent();

    @Override
    public void UpPressed() {
        System.out.println("TestUP");
    }

    @Override
    public void DownPressed() {
        System.out.println("TestDOWN");
    }

    @Override
    public void LeftPressed(){
        System.out.println("TestLEFT");
    }

    @Override
    public void RightPressed(){
        System.out.println("TestRIGHT");
    }

    @Override
    public void ResetPressed(){
        System.out.println("TestRESET");
    }

    public void CheckUp(){
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
    public void CheckDown(){
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
                    Board[checkX][checkY] = 3;
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

    public void CheckLeft(){
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

    public void CheckRight(){
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
    }

}
