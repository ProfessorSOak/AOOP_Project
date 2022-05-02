import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Panel {
    public Panel(){
        Level1();

    }

    public void Level1(){
        JFrame frame = new JFrame();
        GridLayout gird = new GridLayout(9,8);
        frame.setLayout(gird);
        int[][] a = new int[gird.getRows()][gird.getColumns()];
    }

}
