import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class ObserverCollection {

    private List<BoardObserver> observers = new ArrayList<BoardObserver>();

    public void addSignalObserver(BoardObserver BO){
        observers.add(BO);
    }

    public void NotifyObservers(int[][] field, String update){
        for(BoardObserver BO : observers){
            BO.UpdateBoard(field, update);
        }
    }

}
