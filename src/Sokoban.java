import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
public abstract class Sokoban extends JFrame implements KeyListener {

    private int CharXpos;
    private int CharYpos;
    private int[][] field;
    private int[][] Start;
    private int CharStartX;
    private int CharStartY;

    //Create getters and setters for later use.

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

    public int[][] GetBoard(){
        return field;
    }



    public void Level1(){
        JFrame frame = new JFrame();
        JPanel k = new JPanel();
        GridLayout gird = new GridLayout(9,8);
        k.setLayout(gird);
        k.setBackground(Color.BLACK);
        frame.setPreferredSize(new Dimension(275, 330));
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
        Start = field;
        //Crates Value = 2;
        //goals value = 4
        //character value = 3;
        CharXpos = 2;
        CharYpos = 2;
        CharStartX = CharXpos;
        CharStartY = CharYpos;
        //tile values = 1;
        for(int i = 0; i<9; i++){

            for(int j = 0; j<8; j++){
                PictureComponent first = new PictureComponent();
                //System.out.println("hej");
                first.UpdateField(field, i, j);
                k.add(first);
            }
        }

        /*KeyListener test = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_SPACE: {
                        System.out.println("k");
                        break;
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };*/

        frame.addKeyListener(this);
        frame.add(k,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE: {
                ResetPressed();
                System.out.println("RESET");
                break;
            }
            case KeyEvent.VK_UP: {
                UpPressed();
                System.out.println("UP");
                break;
            }
            case KeyEvent.VK_DOWN: {
                DownPressed();
                System.out.println("DOWN");
                break;
            }
            case KeyEvent.VK_LEFT: {
                LeftPressed();
                System.out.println("LEFT");
                break;
            }
            case KeyEvent.VK_RIGHT: {
                RightPressed();
                System.out.println("RIGHT");
                break;
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {


    }
    public static void main(String[] args) {
        Sokoban test = new Logic();
    }
}
