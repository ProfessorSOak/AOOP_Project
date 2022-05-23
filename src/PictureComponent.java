import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PictureComponent extends JComponent implements BoardObserver{

    //variables for the different pictures used along with the array of the picture field
    private final File crate;
    private final File Character;
    private final File MarkedCrate;
    private final File Goal;
    private final File Wall;
    private final File Path;
    private File[][] Board;

    public PictureComponent(){//links specified pictures to each variable
        super();
        crate = new File("C:\\Users\\hugos\\IdeaProjects\\AOOP_Project\\src\\crate.png");
        MarkedCrate = new File("C:\\Users\\hugos\\IdeaProjects\\AOOP_Project\\src\\cratemarked.png");
        Character = new File("C:\\Users\\hugos\\IdeaProjects\\AOOP_Project\\src\\player.png");
        Goal = new File("C:\\Users\\hugos\\IdeaProjects\\AOOP_Project\\src\\blankmarked.png");
        Wall = new File("C:\\Users\\hugos\\IdeaProjects\\AOOP_Project\\src\\wall.png");
        Path = new File("C:\\Users\\hugos\\IdeaProjects\\AOOP_Project\\src\\blank.png");
    }

    public void paintComponent(Graphics g){ //the paint component function for repainting the component on the frame
        for(int i = 0; i<Board[0].length; i++) {//double for loop used to make sure every picture in the array is added to the repaint
            for (int j = 0; j < Board.length; j++) {
                File paintit = Board[j][i];

                BufferedImage Image = null;
                try {
                    Image = ImageIO.read(paintit);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Graphics2D G2 = (Graphics2D) g;
                G2.drawImage(Image, null, 32 * i, 32 * j);
            }
        }
    }

    public File[][] SetPictureBoard(int[][] field){ //this function updates the board component by adding pictures based on the fields values
        File[][] ret = new File[field.length][field[0].length];
        for(int i = 0; i<field.length; i++){
            for(int j = 0; j<field[0].length;j++){
                if(field[i][j] == 0){
                    ret[i][j] = Wall;
                }
                if(field[i][j] == 1){
                    ret[i][j] = Path;
                }
                else if(field[i][j] == 2){
                    ret[i][j] = crate;
                }
                else if(field[i][j] == 3 || field[i][j] == 7){
                    ret[i][j] = Character;
                }
                else if(field[i][j] == 4){
                    ret[i][j] = Goal;
                }
                else if(field[i][j] == 6){
                    ret[i][j] = MarkedCrate;
                }
            }
        }
        return ret;
    }

    @Override
    public void UpdateBoard(int[][] field, String update, File[][] Board) {
        this.Board = Board;
        repaint();
    }
}
