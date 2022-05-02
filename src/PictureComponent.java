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
    int xpos;
    int ypos;

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
        if(Paintit == null){
            return;
        }

        BufferedImage Image = null;

        Graphics2D G2 = (Graphics2D) g;
        G2.drawImage(Image, null, xpos, ypos);

    }

    public void UpdateField(int[][] field, int xpos, int ypos){
        this.xpos = xpos;
        this.ypos = ypos;
        if(field[xpos][ypos] == 0){
            Paintit = Wall;
        }
        else if(field[xpos][ypos] == 1){
            Paintit = Path;
        }
        else if(field[xpos][ypos] == 2){
            Paintit = crate;
        }
        else if(field[xpos][ypos] == 3 || field[xpos][ypos] == 7){
            Paintit = Character;
        }
        else if(field[xpos][ypos] == 4){
            Paintit = Goal;
        }
        else if(field[xpos][ypos] == 6){
            Paintit = MarkedCrate;
        }
        repaint();
    }

}
