import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Panel extends JFrame{

    int CharXpos;
    int CharYpos;
    int[][] field;

    public Panel(){
        Level1();

    }

    public void Level1(){
        JFrame frame = new JFrame();
        JPanel k = new JPanel();
        PictureComponent first = new PictureComponent();
        GridLayout gird = new GridLayout(9,8);
        k.setLayout(gird);
        k.setBackground(Color.BLACK);
        frame.setPreferredSize(new Dimension(1000, 1000));
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
        //Crates Value = 2;
        //goals value = 4
        //character value = 3;
        CharXpos = 2;
        CharYpos = 2;
        //tile values = 1;
        for(int i = 0; i<9; i++){

            for(int j = 0; j<8; j++){

                first.UpdateField(field, i, j);
                k.add(first);

            }
        }
        frame.add(k,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

}
