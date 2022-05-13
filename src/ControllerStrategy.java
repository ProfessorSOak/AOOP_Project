import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControllerStrategy implements KeyListener {

    private final Sokoban m;


    public ControllerStrategy(Sokoban Game){
        m = Game;
        m.getFrame().addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE-> m.ResetPressed();

            case KeyEvent.VK_UP -> m.UpPressed();

            case KeyEvent.VK_DOWN -> m.DownPressed();

            case KeyEvent.VK_LEFT -> m.LeftPressed();

            case KeyEvent.VK_RIGHT -> m.RightPressed();

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
