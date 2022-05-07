import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PictureComponent extends JComponent{
    File crate;
    File Character;
    File MarkedCrate;
    File Goal;
    File Wall;
    File Path;
    File Paintit;
    //int xpos;
    //int ypos;
    File[][] Board;

    public PictureComponent(){
        super();
        crate = new File("C:\\Users\\hugos\\IdeaProjects\\AOOP_Project\\src\\crate.png");
        MarkedCrate = new File("C:\\Users\\hugos\\IdeaProjects\\AOOP_Project\\src\\cratemarked.png");
        Character = new File("C:\\Users\\hugos\\IdeaProjects\\AOOP_Project\\src\\player.png");
        Goal = new File("C:\\Users\\hugos\\IdeaProjects\\AOOP_Project\\src\\blankmarked.png");
        Wall = new File("C:\\Users\\hugos\\IdeaProjects\\AOOP_Project\\src\\wall.png");
        Path = new File("C:\\Users\\hugos\\IdeaProjects\\AOOP_Project\\src\\blank.png");
    }

    public void paintComponent(Graphics g){
        /*if(Paintit == null){
            return;
        }*/
        for(int i = 0; i<Board[0].length; i++) {
            for (int j = 0; j < Board.length; j++) {
                //first = new PictureComponent();

                //k.add(first);
                Paintit = Board[j][i];

                BufferedImage Image = null;
                try {
                    Image = ImageIO.read(Paintit);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Graphics2D G2 = (Graphics2D) g;
                G2.drawImage(Image, null, 32 * i, 32 * j);
            }
        }
    }

    public void UpdateField(File[][] Board){
        //this.xpos = xpos;
        //this.ypos = ypos;
        /*this.xpos = xpos;
        this.ypos = ypos;
        if(field[ypos][xpos] == 0){
            Paintit = Wall;
        }
         if(field[ypos][xpos] == 1){
            Paintit = Path;
        }
        else if(field[ypos][xpos] == 2){
            Paintit = crate;
        }
        else if(field[ypos][xpos] == 3 || field[ypos][xpos] == 7){
            Paintit = Character;
        }
        else if(field[ypos][xpos] == 4){
            Paintit = Goal;
        }
        else if(field[ypos][xpos] == 6){
            Paintit = MarkedCrate;
        }*/
        this.Board = Board;
        repaint();
    }

    public File[][] SetPictureBoard(int[][] field){
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
}
