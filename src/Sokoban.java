import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import java.util.List;
import java.util.Observer;

public abstract class Sokoban extends JFrame{

    private int CharXpos;
    private int CharYpos;
    private int[][] field;
    private int[][] Start;
    private int CharStartX;
    private int CharStartY;
    private File[][] PicBoard;
    private PictureComponent k = new PictureComponent();
    //PictureComponent first = new PictureComponent();
    private JFrame frame = new JFrame();
    //private List<BoardObserver> observers = new ArrayList<BoardObserver>();


    //Create getters and setters for later use.

    public abstract void UpPressed();
    public abstract void DownPressed();
    public abstract void LeftPressed();
    public abstract void RightPressed();
    public abstract void ResetPressed();
    //public abstract boolean GetWinCondition();
    //public abstract void UpdateBoard(File[][] Board, PictureComponent k);
    //public abstract JComponent createMainComponent();

    public Sokoban(){
        Level1();

    }

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

    /*public JPanel GetPanel(){
        return k;
    }*/

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

    public int[][] GetStartField(){
        int[][] SetStart = new int[Start.length][Start[0].length];
        for(int i = 0; i < Start.length; i++){
            for( int j = 0; j < Start[0].length; j++){
                SetStart[i][j] = Start[i][j];
            }
        }
        return SetStart;
    }

    public int[][] CreateStart(){
        int[][] CreateStart = new int[field.length][field[0].length];
        for(int i = 0; i < field.length; i++){
            for( int j = 0; j < field[0].length; j++){
                CreateStart[i][j] = field[i][j];
            }
        }
        return CreateStart;
    }

    public void Level1(){


        //GridLayout gird = new GridLayout(9,8);
        //k.setLayout(new BorderLayout());
        //k.setBackground(Color.BLACK);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        int[][] field = new int[][]{
                {0,0,0,0,0,0,0,0},
                {0,0,0,1,1,1,0,0},
                {0,4,3,2,1,1,0,0},
                {0,0,0,1,2,4,0,0},
                {0,4,0,0,2,1,0,0},
                {0,1,0,1,4,1,0,0},
                {0,2,1,6,2,2,4,0},
                {0,1,1,1,4,1,1,0},
                {0,0,0,0,0,0,0,0}};
        //int tester[][] = {{4, 2}};
        this.field = field;
        //JComponent Painter = createMainComponent();
        Start = CreateStart();
        PicBoard = k.SetPictureBoard(field);
        //Crates Value = 2;
        //goals value = 4
        //character value = 3;
        CharXpos = 2;
        CharYpos = 2;
        CharStartX = CharXpos;
        CharStartY = CharYpos;
        k.UpdateField(PicBoard);
        //tile values = 1;


        //frame.addKeyListener(this);
        frame.add(k,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

    }
/*
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        PictureComponent test = new PictureComponent();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE: {
                ResetPressed();

                System.out.println("RESET");
                break;
            }
            case KeyEvent.VK_UP: {
                UpPressed();
                PicBoard = k.SetPictureBoard(field);
                k.UpdateField(PicBoard);
                //UpdateBoard(PicBoard, k);
                System.out.println("UP");
                break;
            }

            case KeyEvent.VK_DOWN: {
                DownPressed();
                PicBoard = k.SetPictureBoard(field);
                k.UpdateField(PicBoard);
                //UpdateBoard(PicBoard, k);
                System.out.println("DOWN");
                break;
            }
            case KeyEvent.VK_LEFT: {
                LeftPressed();
                PicBoard = k.SetPictureBoard(field);
                k.UpdateField(PicBoard);
                //UpdateBoard(PicBoard, k);
                System.out.println("LEFT");
                break;
            }
            case KeyEvent.VK_RIGHT: {
                RightPressed();
                PicBoard = k.SetPictureBoard(field);
                k.UpdateField(PicBoard);
                //UpdateBoard(PicBoard, k);
                System.out.println("RIGHT");
                break;
            }
        }
        String temp = "";
        for(int i = 0; i<9; i++){
            for(int j = 0; j<8; j++){
                temp += field[i][j] + ", ";
            }
            temp += "\n";
        }
        System.out.println(temp);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }*/
    public static void main(String[] args) {
        Logic test = new Logic();
        Sokoban Game = test;
        new ControllerStrategy(Game);
        /*Logic logic = new Logic();
        ObserverCollection test1 = new ObserverCollection();
        test1.addSignalObserver((field1, update) ->{

        });*/


        /*test1.addSignalObserver(new BoardObserver() {
            @Override
            public void UpdateBoard(int[][] field, String update) {

            }
        });
        test1.addSignalObserver(value ->{
            field, "Still"});*/
    }
}
