import java.io.File;

public interface BoardObserver {
    void UpdateBoard(int[][] field, String update, File[][] Board);//observer interface
}
