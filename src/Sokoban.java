import java.awt.*;
import java.io.File;
import javax.swing.*;

public abstract class Sokoban extends JFrame{

    //specific variables passed in between the functions
    private int CharXpos;  //players current row position
    private int CharYpos;  //players current column position
    private int[][] field; //playing field written in numbers
    private int[][] Start; //the same field to be used for reset
    private int CharStartX; //players start row
    private int CharStartY; //players start column
    private File[][] PicBoard; //the playing field but filled with the specified pictures for each position
    private final PictureComponent k = new PictureComponent(); //main component where playing field is painted
    private final JFrame frame = new JFrame(); //the frame

    //abstract functions used in the logic class
    public abstract void UpPressed();
    public abstract void DownPressed();
    public abstract void LeftPressed();
    public abstract void RightPressed();
    public abstract void ResetPressed();

    public Sokoban(){
        Level1();

    }


    //setters ang getters for the different variables
    public void SetCharPosX(int pos){
        CharXpos = pos;
    }

    public void SetCharPosY(int pos){
        CharYpos = pos;
    }

    public int GetCharPosX(){
        return CharXpos;
    }

    public int GetCharPosY(){
        return CharYpos;
    }

    public void SetBoard(int[][] Board){
        field = Board;
    }

    public void SetPicBoard(File[][] Board){
        PicBoard = Board;
    }
    public int[][] GetField(){
        return field;
    }

    public File[][] GetBoard(){
        return PicBoard;
    }

    public PictureComponent GetComponent() {
        return k;
    }

    public JFrame getFrame(){
        return frame;
    }

    public int getStartX(){
        return CharStartX;
    }

    public int getStartY(){
        return CharStartY;
    }

    public int[][] GetStartField(){ //these two methods below are used to create and pass the start array for the reset
        int[][] SetStart = new int[Start.length][Start[0].length];
        for(int i = 0; i < Start.length; i++){
            System.arraycopy(Start[i], 0, SetStart[i], 0, Start[0].length);
        }
        return SetStart;
    }

    public int[][] CreateStart(){
        int[][] CreateStart = new int[field.length][field[0].length];
        for(int i = 0; i < field.length; i++){
            System.arraycopy(field[i], 0, CreateStart[i], 0, field[0].length);
        }
        return CreateStart;
    }

    public void Level1(){ //main function for creating the game
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        int[][] field = new int[][]{ //the playing field in numeric values
                {0,0,0,0,0,0,0,0},
                {0,0,0,1,1,1,0,0},
                {0,4,3,2,1,1,0,0},
                {0,0,0,1,2,4,0,0},
                {0,4,0,0,2,1,0,0},
                {0,1,0,1,4,1,0,0},
                {0,2,1,6,2,2,4,0},
                {0,1,1,1,4,1,1,0},
                {0,0,0,0,0,0,0,0}};
        this.field = field;
        Start = CreateStart();

        PicBoard = k.SetPictureBoard(field);

        CharXpos = 2;
        CharYpos = 2;
        CharStartX = CharXpos;
        CharStartY = CharYpos;

        k.UpdateField(PicBoard); //our repaint function

        frame.add(k,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        Sokoban Game = new Logic(); //create the game based on the game logic
        new ControllerStrategy(Game); // link the controller to the game
    }
}
