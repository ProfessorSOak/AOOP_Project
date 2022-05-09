import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
    private PictureComponent k = new PictureComponent();
    //PictureComponent first = new PictureComponent();


    //Create getters and setters for later use.

    public abstract void UpPressed();
    public abstract void DownPressed();
    public abstract void LeftPressed();
    public abstract void RightPressed();
    public abstract void ResetPressed();
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

    public void SetPicBoard(){
        PicBoard = k.SetPictureBoard(Start);
        k.UpdateField(PicBoard);
    }

    /*public JPanel GetPanel(){
        return k;
    }*/

    public int[][] GetBoard(){
        return field;
    }
    public void Level1(){
        JFrame frame = new JFrame();

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
        Start = field;
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
        Sokoban test = new Logic();
        ControllerStrategy m = new ControllerStrategy(test);
    }
}
