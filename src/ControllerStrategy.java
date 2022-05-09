import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControllerStrategy implements KeyListener {
//private Sokoban a;
    Sokoban m;


    public ControllerStrategy(Sokoban Game){
        m = Game;
        m.getFrame().addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        PictureComponent test = new PictureComponent();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE: {
                m.ResetPressed();
                System.out.println("RESET");
                break;
            }
            case KeyEvent.VK_UP: {
                m.UpPressed();
                //UpdateBoard(PicBoard, k);
                System.out.println("UP");
                break;
            }

            case KeyEvent.VK_DOWN: {
                m.DownPressed();
                //UpdateBoard(PicBoard, k);
                System.out.println("DOWN");
                break;
            }
            case KeyEvent.VK_LEFT: {
                m.LeftPressed();
                //UpdateBoard(PicBoard, k);
                System.out.println("LEFT");
                break;
            }
            case KeyEvent.VK_RIGHT: {
                m.RightPressed();
                //UpdateBoard(PicBoard, k);
                System.out.println("RIGHT");
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
