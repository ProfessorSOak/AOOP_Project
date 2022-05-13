import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Logic extends Sokoban {
    private File[][] Board = GetBoard(); // exact copies of the two array from sokoban to give access to changes
    private int[][] field = GetField();
    private Boolean Win = false; //win value for when the win condition has been reached
    private final PictureComponent k = GetComponent(); //a component linked to the one in the frame
    private final List<BoardObserver> observers = new ArrayList<>(); //observer array


    public Logic() { //adds the text based observer to the observer array
        observers.add(new ObserverCollection());
    }


    @Override
    public void UpPressed() { //function for moving the player up on the field
        if (Win) { //if the win condition has been reached then the function will not run. (same for all directions)
            return;
        }
        Check(GetCharPosX(), GetCharPosY(), -1, 0, -2, 0); //function for checking the next location and updating field accordingly

        Board = k.SetPictureBoard(GetField()); //updates board to match field
        k.UpdateField(Board); //repaints component
        NotifyObservers(field, "Up"); //notify observer of the new change
        WinCondition(field); //check if win condition is reached
        if (Win) { //if it is reached then tell the observer about the game being cleared
            NotifyObservers(field, "Cleared Game");
        }
    }

    @Override
    public void DownPressed() {//move player down. built the same as UpPressed
        if (Win) {
            return;
        }
        Check(GetCharPosX(), GetCharPosY(), 1, 0, 2, 0);
        Board = k.SetPictureBoard(GetField());
        k.UpdateField(Board);
        NotifyObservers(field, "Down");
        WinCondition(field);
        if (Win) {
            NotifyObservers(field, "Cleared Game");
        }
    }

    @Override
    public void LeftPressed() { //move player left
        if (Win) {
            return;
        }
        Check(GetCharPosX(), GetCharPosY(), 0, -1, 0, -2);
        Board = k.SetPictureBoard(GetField());
        k.UpdateField(Board);
        NotifyObservers(field, "Left");
        WinCondition(field);
        if (Win) {
            NotifyObservers(field, "Cleared Game");
        }
    }

    @Override
    public void RightPressed() { //move player right
        if (Win) {
            return;
        }
        Check(GetCharPosX(), GetCharPosY(), 0, 1, 0, 2);
        Board = k.SetPictureBoard(GetField());
        k.UpdateField(Board);
        NotifyObservers(field, "Right");
        WinCondition(field);
        if (Win) {
            NotifyObservers(field, "Cleared Game");
        }
    }

    @Override
    public void ResetPressed() { // reset the game to the start position

        SetCharPosX(getStartX()); //update player placement with original values
        SetCharPosY(getStartY());

        SetBoard(GetStartField());//does the same with the field and board values
        SetPicBoard(k.SetPictureBoard(GetField()));

        Board = GetBoard(); //updates the local field and board values to match the ones above
        field = GetField();

        k.UpdateField(Board); //repaint
        Win = false; //reset win condition
        NotifyObservers(field, "Reset"); //notify observer of the reset
    }

    public void Check(int checkX, int checkY, int x1, int y1, int x2, int y2) {
        int[][] Board = GetField();
        if (Board[checkX + x1][checkY + y1] == 0) {//checks if next block is a wall
            return;
        }
        if (Board[checkX + x1][checkY + y1] == 1) { //checks if next value is a path
            Board[checkX + x1][checkY + y1] = 3;
            SetCharPosX(checkX + x1);
            SetCharPosY(checkY + y1);
            if (Board[checkX][checkY] == 3) { //checks if character is on a path or goal
                Board[checkX][checkY] = 1;
            } else {
                Board[checkX][checkY] = 4;
            }
            SetBoard(Board);
            return;
        }

        if (Board[checkX + x1][checkY + y1] == 2 || Board[checkX + x1][checkY + y1] == 6) { //checks if next block is a type of box
            if (Board[checkX + x2][checkY + y2] == 0 || Board[checkX + x2][checkY + y2] == 2 || Board[checkX + x2][checkY + y2] == 6) {
                return; //checks if the block after the box is another box or a wall
            }
            if (Board[checkX + x2][checkY + y2] == 1) {//checks if the block after the box is a path
                Board[checkX + x2][checkY + y2] = 2;
                if (Board[checkX + x1][checkY + y1] == 2) {//checks if box needs to be marked or not
                    Board[checkX + x1][checkY + y1] = 3;
                    SetCharPosX(checkX + x1);
                    SetCharPosY(checkY + y1);
                } else {
                    Board[checkX + x1][checkY + y1] = 7;
                    SetCharPosX(checkX + x1);
                    SetCharPosY(checkY + y1);
                }
                if (Board[checkX][checkY] == 3) { //checks player
                    Board[checkX][checkY] = 1;
                } else {
                    Board[checkX][checkY] = 4;
                }
                SetBoard(Board);
                return;
            }
            if (Board[checkX + x2][checkY + y2] == 4) { // checks if next block after box is a goal
                Board[checkX + x2][checkY + y2] = 6;
                if (Board[checkX + x1][checkY + y1] == 2) { // checks box
                    Board[checkX + x1][checkY + y1] = 3;
                    SetCharPosX(checkX + x1);
                    SetCharPosY(checkY + y1);
                } else {
                    Board[checkX + x1][checkY + y1] = 7;
                    SetCharPosX(checkX + x1);
                    SetCharPosY(checkY + y1);
                }
                if (Board[checkX][checkY] == 3) { // checks player
                    Board[checkX][checkY] = 1;
                } else {
                    Board[checkX][checkY] = 4;
                }
                SetBoard(Board);
                return;
            }
        }
        if (Board[checkX + x1][checkY + y1] == 4) { // checks if the block next to the player is a goal
            Board[checkX + x1][checkY + y1] = 7;
            SetCharPosX(checkX + x1);
            SetCharPosY(checkY + y1);
            if (Board[checkX][checkY] == 3) {
                Board[checkX][checkY] = 1;
            } else {
                Board[checkX][checkY] = 4;
            }
            SetBoard(Board);
        }
    }


    public void WinCondition(int[][] field) {
        int n = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) { //loops through field
                if (field[i][j] == 2) { // if there is a normal crate left then break
                    break;
                }
                n++; //otherwise increment n
            }
        }
        if (n == field.length * field[0].length) { //if there are no normal crates then set win to true
            Win = true;
        }
    }

    public void NotifyObservers(int[][] field, String update) {//method to check and update all observers
        for (BoardObserver BO : observers) {
            BO.UpdateBoard(field, update);
        }
    }
}
