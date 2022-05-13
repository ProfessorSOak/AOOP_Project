import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ObserverCollection {

    int SAMPLING = 500;
    private List<BoardObserver> observers = new ArrayList<BoardObserver>();

    public ObserverCollection(int[][] field) {
        javax.swing.Timer t = new Timer(SAMPLING, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //double amplitude = Math.random() * 10;
                // notify all observers with amplitude
                NotifyObservers(field, "hej");
                /*Council.append("" + String.format("%.6f", amplitude) + "\n");
                printStars((int) amplitude);*/
            }
        });
        t.start();
    }

    public void addSignalObserver(BoardObserver BO){
        observers.add(BO);
    }

    public void NotifyObservers(int[][] field, String update){
        for(BoardObserver BO : observers){
            BO.UpdateBoard(field, update);
        }
    }

}
