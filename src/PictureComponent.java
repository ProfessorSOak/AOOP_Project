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
        try {
            Image = ImageIO.read(Paintit);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Graphics2D G2 = (Graphics2D) g;
        G2.drawImage(Image, null, 0, 0);
    }

    public void UpdateField(int[][] field, int ypos, int xpos){
        this.xpos = xpos;
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
        }
        repaint();
    }

}
