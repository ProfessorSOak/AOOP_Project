import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ObserverCollection implements BoardObserver{

   // int SAMPLING = 500;
    @Override
    public void UpdateBoard(int[][] field, String update) {

        if(update.equals("Reset")){
            System.out.println("Game " + update + "\nCurrent Board:");
        }

        else if(update.equals("Cleared Game")){
            System.out.println(update + "\nFinal Board:");
        }
        else {
            System.out.println("Moved: " + update + "\nCurrent Board:");
        }
        String Board = "";
        for(int i = 0; i<9; i++){
            for(int j = 0; j<8; j++){
                Board += field[i][j] + ", ";
            }
            Board += "\n";
        }
        System.out.println(Board);
    }
}
