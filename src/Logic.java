//import javax.swing.*;
//import java.io.File;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Logic extends Sokoban {
    //private PictureComponent first = new PictureComponent();
    private File[][] Board = GetBoard();
    private int[][] field = GetField();
    private Boolean Win = false;
    private PictureComponent k = GetComponent();
    private List<BoardObserver> observers = new ArrayList<BoardObserver>();
    //private ObserverCollection OC = new ObserverCollection();


    public Logic(){
        observers.add(new ObserverCollection());
    }


    @Override
    public void UpPressed() {
        if(Win) {
            return;
        }
        Check(GetCharPosX(), GetCharPosY(), -1,0,-2,0);

        Board = k.SetPictureBoard(GetField());
        k.UpdateField(Board);
        /*String temp = "";
        for(int i = 0; i<9; i++){
            for(int j = 0; j<8; j++){
                temp += field[i][j] + ", ";
            }
            temp += "\n";
        }*/
        NotifyObservers(field, "Up");
        WinCondition(field);
        if(Win){
            NotifyObservers(field,"Cleared Game" );
        }
        //System.out.println(temp);
        //System.out.println("TestUP");
    }

    @Override
    public void DownPressed() {
        if(Win){
            return;
        }
        Check(GetCharPosX(), GetCharPosY(),1,0,2,0);
        /*File[][] Board = GetBoard();
        int[][] field = GetField();*/
        Board = k.SetPictureBoard(GetField());
        k.UpdateField(Board);
        NotifyObservers(field, "Down");
        WinCondition(field);
        if(Win){
           NotifyObservers(field,"Cleared Game" );
        }
        /*System.out.println("TestDOWN");
        String temp = "";
        for(int i = 0; i<9; i++){
            for(int j = 0; j<8; j++){
                temp += field[i][j] + ", ";
            }
            temp += "\n";
        }
        System.out.println(temp);*/
    }

    @Override
    public void LeftPressed(){
        if(Win){
            return;
        }
        Check(GetCharPosX(), GetCharPosY(),0,-1,0,-2);
        /*File[][] Board = GetBoard();
        int[][] field = GetField();*/
        Board = k.SetPictureBoard(GetField());
        k.UpdateField(Board);
        NotifyObservers(field, "Left");
        WinCondition(field);
        if(Win){
            NotifyObservers(field,"Cleared Game" );
        }
        /*System.out.println("TestLEFT");
        String temp = "";
        for(int i = 0; i<9; i++){
            for(int j = 0; j<8; j++){
                temp += field[i][j] + ", ";
            }
            temp += "\n";
        }
        System.out.println(temp);*/
    }

    @Override
    public void RightPressed(){
        if(Win){
            return;
        }
        Check(GetCharPosX(), GetCharPosY(),0,1,0,2);
        /*File[][] Board = GetBoard();
        int[][] field = GetField();*/
        Board = k.SetPictureBoard(GetField());
        k.UpdateField(Board);
        NotifyObservers(field, "Right");
        WinCondition(field);
        if(Win){
            NotifyObservers(field,"Cleared Game" );
        }
        /*
        System.out.println("TestRIGHT");
        String temp = "";
        for(int i = 0; i<9; i++){
            for(int j = 0; j<8; j++){
                temp += field[i][j] + ", ";
            }
            temp += "\n";
        }
        System.out.println(temp);*/
    }

    @Override
    public void ResetPressed(){


        SetCharPosX(getStartX());
        SetCharPosY(getStartY());
        SetBoard(GetStartField());
        SetPicBoard(k.SetPictureBoard(GetField()));
        Board = GetBoard();
        field = GetField();
        k.UpdateField(Board);
        Win = false;
        NotifyObservers(field, "Reset");




        /*SetPicBoard();
        SetCharPosY(x);
        SetCharPosY(y);*/
        /*SetBoard(GetStartField());
        int[][] start = GetStartField();
        field = GetField();
        SetCharPosY(getStartY());
        SetCharPosX(getStartX());
        String temp = "";
        for(int i = 0; i<9; i++){
            for(int j = 0; j<8; j++){
                temp += start[i][j] + ", ";
            }
            temp += "\n";
        }
        System.out.println(temp);
        Board = k.SetPictureBoard(GetField());
        k.UpdateField(Board);*/

        //System.out.println("TestRESET");
    }

    public void addBoardObserver(BoardObserver BO){
        observers.add(BO);
    }

    /*@Override
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
    }*/

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
        int[][] Board = GetField();
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



    public void WinCondition(int[][] field){
        int n = 0;
        for(int i = 0; i<9; i++){
            for(int j = 0; j<8; j++){
                if(field[i][j] == 2){
                    //System.out.println("hej");
                    break;
                }
                n++;
            }
        }
        if(n == field.length*field[0].length ){
            Win = true;
        }
    }
    public void NotifyObservers(int[][] field, String update){
        for(BoardObserver BO : observers){
            BO.UpdateBoard(field, update);
        }
    }

        /*public boolean getWinCondition(){
            return Win;
        }*/
    }
