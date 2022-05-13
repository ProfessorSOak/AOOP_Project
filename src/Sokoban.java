import java.awt.*;
import java.io.File;
import javax.swing.*;

public abstract class Sokoban extends JFrame{

    private int CharXpos;
    private int CharYpos;
    private int[][] field;
    private int[][] Start;
    private int CharStartX;
    private int CharStartY;
    private File[][] PicBoard;
    private final PictureComponent k = new PictureComponent();
    private final JFrame frame = new JFrame();


    public abstract void UpPressed();
    public abstract void DownPressed();
    public abstract void LeftPressed();
    public abstract void RightPressed();
    public abstract void ResetPressed();

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

    public void Level1(){
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
        this.field = field;
        Start = CreateStart();
        PicBoard = k.SetPictureBoard(field);
        CharXpos = 2;
        CharYpos = 2;
        CharStartX = CharXpos;
        CharStartY = CharYpos;
        k.UpdateField(PicBoard);

        frame.add(k,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        Sokoban Game = new Logic();
        new ControllerStrategy(Game);
    }
}
