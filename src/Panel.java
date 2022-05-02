import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Panel {

    int CharXpos;
    int CharYpos;
    int[][] field;

    public Panel(){
        Level1();

    }

    public void Level1(){
        JFrame frame = new JFrame();
        GridLayout gird = new GridLayout(9,8);
        frame.setLayout(gird);
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
        //Crates Value = 2;
        //goals value = 4
        //character value = 3;
        CharXpos = 2;
        CharYpos = 2;
        //tile values = 1;
    }

}
