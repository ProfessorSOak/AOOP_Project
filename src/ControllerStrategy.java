import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControllerStrategy implements KeyListener {

    private final Sokoban m; //local variable for having access to the game field


    public ControllerStrategy(Sokoban Game){//takes in a variable of type sokoban and makes a local variable.
        m = Game;
        m.getFrame().addKeyListener(this);//adds keyListener to the frame
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {//checks for keys pressed on the keyboard

        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE-> m.ResetPressed(); //if space is pressed: reset board

            case KeyEvent.VK_UP -> m.UpPressed(); //if up arrow is pressed: move up

            case KeyEvent.VK_DOWN -> m.DownPressed(); //if down arrow is pressed: move down

            case KeyEvent.VK_LEFT -> m.LeftPressed(); //if left arrow is pressed: move left

            case KeyEvent.VK_RIGHT -> m.RightPressed(); //if right arrow is pressed: move right

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
