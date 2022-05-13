import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Logic extends Sokoban {
    private File[][] Board = GetBoard();
    private int[][] field = GetField();
    private Boolean Win = false;
    private final PictureComponent k = GetComponent();
    private final List<BoardObserver> observers = new ArrayList<>();


    public Logic() {
        observers.add(new ObserverCollection());
    }


    @Override
    public void UpPressed() {
        if (Win) {
            return;
        }
        Check(GetCharPosX(), GetCharPosY(), -1, 0, -2, 0);

        Board = k.SetPictureBoard(GetField());
        k.UpdateField(Board);
        NotifyObservers(field, "Up");
        WinCondition(field);
        if (Win) {
            NotifyObservers(field, "Cleared Game");
        }
    }

    @Override
    public void DownPressed() {
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
    public void LeftPressed() {
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
    public void RightPressed() {
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
    public void ResetPressed() {

        SetCharPosX(getStartX());
        SetCharPosY(getStartY());

        SetBoard(GetStartField());
        SetPicBoard(k.SetPictureBoard(GetField()));

        Board = GetBoard();
        field = GetField();

        k.UpdateField(Board);
        Win = false;
        NotifyObservers(field, "Reset");
    }

    public void Check(int checkX, int checkY, int x1, int y1, int x2, int y2) {
        int[][] Board = GetField();
        if (Board[checkX + x1][checkY + y1] == 0) {
            return;
        }
        if (Board[checkX + x1][checkY + y1] == 1) {
            Board[checkX + x1][checkY + y1] = 3;
            SetCharPosX(checkX + x1);
            SetCharPosY(checkY + y1);
            if (Board[checkX][checkY] == 3) {
                Board[checkX][checkY] = 1;
            } else {
                Board[checkX][checkY] = 4;
            }
            SetBoard(Board);
            return;
        }

        if (Board[checkX + x1][checkY + y1] == 2 || Board[checkX + x1][checkY + y1] == 6) {
            if (Board[checkX + x2][checkY + y2] == 0 || Board[checkX + x2][checkY + y2] == 2 || Board[checkX + x2][checkY + y2] == 6) {
                return;
            }
            if (Board[checkX + x2][checkY + y2] == 1) {
                Board[checkX + x2][checkY + y2] = 2;
                if (Board[checkX + x1][checkY + y1] == 2) {
                    Board[checkX + x1][checkY + y1] = 3;
                    SetCharPosX(checkX + x1);
                    SetCharPosY(checkY + y1);
                } else {
                    Board[checkX + x1][checkY + y1] = 7;
                    SetCharPosX(checkX + x1);
                    SetCharPosY(checkY + y1);
                }
                if (Board[checkX][checkY] == 3) {
                    Board[checkX][checkY] = 1;
                } else {
                    Board[checkX][checkY] = 4;
                }
                SetBoard(Board);
                return;
            }
            if (Board[checkX + x2][checkY + y2] == 4) {
                Board[checkX + x2][checkY + y2] = 6;
                if (Board[checkX + x1][checkY + y1] == 2) {
                    Board[checkX + x1][checkY + y1] = 3;
                    SetCharPosX(checkX + x1);
                    SetCharPosY(checkY + y1);
                } else {
                    Board[checkX + x1][checkY + y1] = 7;
                    SetCharPosX(checkX + x1);
                    SetCharPosY(checkY + y1);
                }
                if (Board[checkX][checkY] == 3) {
                    Board[checkX][checkY] = 1;
                } else {
                    Board[checkX][checkY] = 4;
                }
                SetBoard(Board);
                return;
            }
        }
        if (Board[checkX + x1][checkY + y1] == 4) {
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
            for (int j = 0; j < 8; j++) {
                if (field[i][j] == 2) {
                    break;
                }
                n++;
            }
        }
        if (n == field.length * field[0].length) {
            Win = true;
        }
    }

    public void NotifyObservers(int[][] field, String update) {
        for (BoardObserver BO : observers) {
            BO.UpdateBoard(field, update);
        }
    }
}
